package com.jose.tienda.controller;


import com.jose.tienda.data.dto.ProductoDto;
import com.jose.tienda.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @PostMapping("/guardarProducto")
    public ProductoDto guardarProducto(@RequestBody  ProductoDto productoDTO){
        return productoService.guardarProducto(productoDTO);
    }
}
