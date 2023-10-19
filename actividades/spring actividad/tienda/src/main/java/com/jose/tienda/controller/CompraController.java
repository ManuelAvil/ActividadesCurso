package com.jose.tienda.controller;

import com.jose.tienda.data.dto.CompraDto;
import com.jose.tienda.service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/compras")
public class CompraController {
    private final CompraService compraService;

    @Autowired
    public CompraController(CompraService compraService) {
        this.compraService = compraService;
    }

    @PostMapping
    public ResponseEntity<CompraDto> crearCompra(@RequestBody @Validated CompraDto compraDto) {
        CompraDto createdCompra = compraService.crearCompra(compraDto);
        return new ResponseEntity<>(createdCompra, HttpStatus.CREATED);
    }
}
