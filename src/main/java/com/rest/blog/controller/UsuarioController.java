package com.rest.blog.controller;

import com.rest.blog.dto.UsuarioDto;
import com.rest.blog.dto.UsuarioLoginDTO;
import com.rest.blog.exception.PersonalizedException;
import com.rest.blog.repository.IUsuarioRepository;
import com.rest.blog.service.IUsuarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping(value = "/usuario")
@Api(value = "UsuarioController", tags = {"UsuarioController"})
@Tag(name = "UsuarioController", description = "Servicios REST de Usuarios, Login y CRUD")
public class UsuarioController {

    @Autowired
    private IUsuarioService usuarioService;

    @Autowired
    IUsuarioRepository usuarioRepository;

    @PostMapping(value = "/login")
    @ApiOperation(
            value = "login",
            notes = "Valida que el usuario y contraseña exista en la bd si es asi devuelve un token."
    )
    public UsuarioDto login(HttpServletResponse response, @RequestBody UsuarioLoginDTO usuario)
            throws IOException, PersonalizedException {

        try {
            return usuarioService.login(usuario.getUsuario(), usuario.getPassword());
        } catch (PersonalizedException e) {
            ((HttpServletResponse) response).sendError(e.getCodigoError(), e.getMessage());
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            ((HttpServletResponse) response).sendError(500, e.getMessage());
            return null;
        }

    }
}
