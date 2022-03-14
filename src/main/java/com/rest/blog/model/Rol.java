package com.rest.blog.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "roles")
public class Rol implements Serializable {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(unique = true)
        private String nombre;

        /* Hacer Bidireccional la relacion */
        @ManyToMany(mappedBy = "roles")
        private List<Usuario> usuarios;

        private static final long serialVersionUID = 1L;
}
