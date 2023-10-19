package com.jose.tienda.data;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tblcategoria")
public class Categoria {
    @Id
    @Column(name = "idcategoria", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 45)
    private String nombre;

    @Column(name = "descripcion", nullable = false, length = 45)
    private String descripcion;

}
