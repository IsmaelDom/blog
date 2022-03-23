package com.rest.blog.service.impl;

import com.rest.blog.dto.RolDto;
import com.rest.blog.dto.UsuarioDto;
import com.rest.blog.exception.PersonalizedException;
import com.rest.blog.model.Usuario;
import com.rest.blog.repository.IRolRepository;
import com.rest.blog.repository.IUsuarioRepository;
import com.rest.blog.service.IUsuarioService;
import com.rest.blog.util.AppUtileria;
import com.rest.blog.util.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rest.blog.security.TokenProvider;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Optional;
import static com.rest.blog.util.Constantes.*;

@Service
public class UserServiceImpl implements IUsuarioService {

    @Autowired
    IUsuarioRepository usuarioRepository;

    @Autowired
    IRolRepository rolRepository;

    private AppUtileria appUtileria;

    @Override
    public UsuarioDto login(String usuario, String contraseña) throws PersonalizedException, IOException {
        long contador = 0;
        // Se valida si existe el usuario y/o esta activo
        Optional<Usuario> getUsuario = Optional.ofNullable(usuarioRepository.findByUsuarioAndEstatus(usuario, true)
                .orElseThrow(() -> new PersonalizedException(
                        "El usuario no existe.", 404)));

        AppUtileria utl = new AppUtileria();
        UsuarioDto usuarioDTO = new UsuarioDto();
        if (!getUsuario.isEmpty()) {

            if (getUsuario.get().getPassword().equals(utl.codificar(contraseña))) {

                usuarioDTO.setId(getUsuario.get().getId());
                usuarioDTO.setNombre(getUsuario.get().getNombre());
                usuarioDTO.setApellidoPaterno(getUsuario.get().getApellidoPaterno());
                usuarioDTO.setApellidoMaterno(getUsuario.get().getApellidoMaterno());
                usuarioDTO.setUsuario(getUsuario.get().getUsuario());
                usuarioDTO.setToken(TokenProvider.generateToken(usuario, getUsuario.get().getRoles(),
                        getUsuario.get().getId(), TOKEN_EXPIRATION_TIME));
                usuarioDTO.setExpiration(TOKEN_EXPIRATION_TIME);
                usuarioDTO.setTerminoSession(terminoSession(TOKEN_EXPIRATION_TIME));
                usuarioDTO.setRoles(MapperUtil.mapAll(getUsuario.get().getRoles(), RolDto.class));
                // usuarioDTO.setPermiso(getPermisos(getUsuario.get().getRol()));

                return usuarioDTO;

            } else {
                /*contador = getUsuario.get().getIntentos_login() + 1;
                actualizaIntentos(contador, getUsuario.get().getId());*/
                throw new PersonalizedException("Contraseña incorrecta, favor de validar", 400);
            }

        } else {
            throw new PersonalizedException("Usuario incorrecto, favor de validar.", 400);
        }
    }

    /**
     * Metodo que calcula la fecha y hora en que vence el token
     *
     * @return fecha y hora en que se terminara la sesion
     */

    public String terminoSession(long tiempoToken) {

        Long datetime = System.currentTimeMillis() + tiempoToken;
        Timestamp tiempoActual = new Timestamp(datetime);
        String fechaTermino = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(tiempoActual);

        return fechaTermino;
    }
}
