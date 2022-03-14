package com.rest.blog.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "usuarios")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nombre;

    private String aPaterno;

    private String aMaterno;

    private String fullName;

    @Column(unique = true)
    private String usuario;

    private String password;

    private long intentos_login;

    private Boolean estatus;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    /* Para personalizar el nombre de la tabla intermedia, nombre de la columna de la tabla Usuario y nombre de la columna de la tabla rol */
    //@JoinTable(name = "users_authorities", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Rol> roles;

    private static final long serialVersionUID = 1L;
}
