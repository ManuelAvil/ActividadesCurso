package com.jose.tienda.service;

import com.jose.tienda.data.Compra;
import com.jose.tienda.data.Usuario;
import com.jose.tienda.data.Pago;
import com.jose.tienda.data.dto.CompraDto;
import com.jose.tienda.repository.CompraRepository;
import com.jose.tienda.repository.UsuarioRepository;
import com.jose.tienda.repository.PagoRepository;
import com.jose.tienda.data.Producto;
import com.jose.tienda.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Date;

@Service
public class CompraService {
    private final CompraRepository compraRepository;
    private final UsuarioRepository usuarioRepository;
    private final PagoRepository metodoPagoRepository;
    private final ProductoRepository productoRepository;

    @Autowired
    public CompraService(CompraRepository compraRepository, UsuarioRepository usuarioRepository, PagoRepository metodoPagoRepository, ProductoRepository productoRepository) {
        this.compraRepository = compraRepository;
        this.usuarioRepository = usuarioRepository;
        this.metodoPagoRepository = metodoPagoRepository;
        this.productoRepository = productoRepository;
    }

    @Transactional
    public CompraDto crearCompra(CompraDto compraDto) {
        Producto producto = productoRepository.findById(compraDto.getIdProducto())
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND, "Producto no encontrado"));

        // Validar que haya suficiente cantidad disponible
        if (producto.getCantidad() < compraDto.getCantidad()) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "No hay suficiente cantidad disponible para comprar este producto");
        }

        Compra compra = new Compra();
        compra.setFecha(new Date());
        compra.setCantidad(compraDto.getCantidad());

        // Calcular el total en función de la cantidad y el precio del producto
        double total = producto.getPrecio() * compraDto.getCantidad();
        compra.setTotal(total);

        Usuario usuario = usuarioRepository.findById(compraDto.getIdUsuario())
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND, "Usuario no encontrado"));
        Pago metodoPago = metodoPagoRepository.findById(compraDto.getIdMetodoPago())
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND, "Método de pago no encontrado"));

        compra.setUsuario(usuario);
        compra.setMetodoPago(metodoPago);

        compra = compraRepository.save(compra);

        // Actualizar la cantidad disponible del producto
        producto.setCantidad(producto.getCantidad() - compraDto.getCantidad());
        productoRepository.save(producto);

        compraDto.setIdCompra(compra.getIdCompra());
        return compraDto;
    }
}

