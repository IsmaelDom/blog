package com.rest.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

@AllArgsConstructor
@Getter
@ToString
public class PublicacionDto implements Serializable {
    private final Long id;
    private final String titulo;
    private final String descripcion;
    private final String contenido;
}
