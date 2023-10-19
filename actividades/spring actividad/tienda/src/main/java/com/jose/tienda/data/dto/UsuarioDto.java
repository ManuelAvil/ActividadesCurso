package com.jose.tienda.data.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.Value;

import java.io.Serializable;
@Getter
@Setter
public class UsuarioDto implements Serializable {
    Integer id;
    String nombre;
    String apellidoPaterno;
    String apellidoMaterno;
    String correo;
    String rol;
    String telefono;
    String direccion;

    public UsuarioDto() {

    }

}