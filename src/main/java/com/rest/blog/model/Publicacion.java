package com.rest.blog.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "publicaciones", uniqueConstraints = {@UniqueConstraint(columnNames = {"titulo"})})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Publicacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "Identificador unico", name="id", required=true, value="identificador")
    private Long id;

    @Column(name = "titulo", nullable = false)
    @ApiModelProperty(notes = "Titulo de la publicacion", name="titulo", required=true, value="titulo")
    private String titulo;

    @Column(nullable = false)
    @ApiModelProperty(notes = "Descripcion de la publicacion", name="descripcion", required=true, value="descripcion")
    private String descripcion;

    @Column(nullable = false)
    @ApiModelProperty(notes = "Contenido de la publicacion", name="contenido", required=true, value="contenido")
    private String contenido;
}
