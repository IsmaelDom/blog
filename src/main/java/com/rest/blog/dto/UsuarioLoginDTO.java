package com.rest.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@Getter
@Setter
public class UsuarioLoginDTO implements Serializable {
    private final String usuario;
    private final String password;
}
