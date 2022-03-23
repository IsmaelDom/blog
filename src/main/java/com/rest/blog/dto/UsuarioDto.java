package com.rest.blog.dto;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UsuarioDto implements Serializable {

    private long id;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String fullName;
    private String usuario;
    private Boolean estatus;
    private List<RolDto> roles;
    private String token;
    private Integer expiration;
    private String terminoSession;

}
