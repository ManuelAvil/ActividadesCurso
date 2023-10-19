package com.jose.tienda.data;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tblusuario")
public class Usuario {
    @Id
    @Column(name = "idusuario", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 45)
    private String nombre;

    @Column(name = "apellidopaterno", nullable = false, length = 45)
    private String apellidoPaterno;

    @Column(name = "apellidomaterno", nullable = false, length = 45)
    private String apellidoMaterno;

    @Column(name = "correo", nullable = false, length = 45)
    private String correo;

    @Column(name = "rol", nullable = false, length = 20)
    private String rol;

    @Column(name = "telefono", nullable = false, length = 45)
    private String telefono;

    @Column(name = "direccion", nullable = false, length = 45)
    private String direccion;
}
