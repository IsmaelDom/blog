package com.rest.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class PublicacionDto implements Serializable {
    private Long id;
    private String titulo;
    private String descripcion;
    private String contenido;
}
