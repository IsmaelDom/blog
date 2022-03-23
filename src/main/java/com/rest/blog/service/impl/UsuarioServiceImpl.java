package com.rest.blog.service.impl;

import com.rest.blog.model.Usuario;
import com.rest.blog.repository.IUsuarioRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.stream.Collectors;

@Service
@Log
public class UsuarioServiceImpl implements UserDetailsService {

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> usuario = usuarioRepository.findByUsuario(username);

        if (usuario.isEmpty()) {
            log.log(Level.SEVERE, "Error en el Login: No existe el usuario " + username);
            throw new UsernameNotFoundException("Error en el Login: No existe el usuario " + username);
        }
        List<GrantedAuthority> authorities = usuario.get().getRoles().stream()
                                    .map(rol -> new SimpleGrantedAuthority(rol.getNombre())).collect(Collectors.toList());

        return new User(usuario.get().getUsuario(), usuario.get().getPassword(), usuario.get().getEstatus(), true, true, true, authorities);
    }
}