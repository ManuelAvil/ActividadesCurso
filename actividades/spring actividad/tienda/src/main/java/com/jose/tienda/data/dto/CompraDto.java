package com.jose.tienda.data.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CompraDto {
    private Integer idCompra;
    private Integer idUsuario;
    private Integer idMetodoPago;
    private Integer cantidad;
    private Integer idProducto;
    private Date fecha;
}

