package com.rest.blog.service;

import com.rest.blog.dto.UsuarioDto;
import com.rest.blog.exception.PersonalizedException;

import java.io.IOException;

public interface IUsuarioService {
    public UsuarioDto login(String usuario, String contraseña) throws PersonalizedException, IOException;
}
