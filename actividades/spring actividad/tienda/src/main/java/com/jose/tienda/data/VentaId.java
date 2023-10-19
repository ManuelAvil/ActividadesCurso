package com.jose.tienda.data;

import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;

@Data
@Embeddable
public class VentaId implements Serializable {
    private Integer idProducto;
    private Integer idCompra;

    // Constructores, getters y setters

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VentaId ventaId = (VentaId) o;
        return Objects.equals(idProducto, ventaId.idProducto) &&
                Objects.equals(idCompra, ventaId.idCompra);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProducto, idCompra);
    }
}


