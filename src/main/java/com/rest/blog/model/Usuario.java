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

    private String apellidoPaterno;

    private String apellidoMaterno;

    private String fullName;

    @Column(unique = true)
    private String usuario;

    private String password;

    private long intentos;

    private Boolean estatus;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    /* Para personalizar el nombre de la tabla intermedia, nombre de la columna de la tabla Usuario y nombre de la columna de la tabla rol */
    //@JoinTable(name = "users_authorities", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    //El usuario solo puede tener el mismo rol una vez
    @JoinTable(uniqueConstraints = { @UniqueConstraint(columnNames = {"usuarios_id", "roles_id"})})
    private List<Rol> roles;

    private static final long serialVersionUID = 1L;
}
