package com.rest.blog.dto;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RolDto implements Serializable {
    private Long id;
    private String nombre;
}
