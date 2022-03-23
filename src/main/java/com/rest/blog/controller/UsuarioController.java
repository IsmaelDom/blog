package com.rest.blog.controller;

import com.rest.blog.dto.UsuarioDto;
import com.rest.blog.dto.UsuarioLoginDTO;
import com.rest.blog.exception.PersonalizedException;
import com.rest.blog.repository.IUsuarioRepository;
import com.rest.blog.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {

    @Autowired
    private IUsuarioService usuarioService;

    @Autowired
    IUsuarioRepository usuarioRepository;

    @PostMapping(value = "/login")
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
