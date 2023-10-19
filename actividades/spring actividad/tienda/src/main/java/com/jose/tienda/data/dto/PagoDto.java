package com.jose.tienda.data.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.Value;

import java.io.Serializable;
@Getter
@Setter
public class PagoDto implements Serializable {
    Integer id;
    String nombre;
    String descripcion;

    public PagoDto() {

    }

}