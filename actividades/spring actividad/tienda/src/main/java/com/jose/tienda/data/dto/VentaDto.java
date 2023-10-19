package com.jose.tienda.data.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VentaDto {
    private Integer idProducto;
    private Integer idCompra;
    private Integer cantidad;
    private Double precio;
    private Double total;
}
