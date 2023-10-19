package com.jose.tienda.controller;


import com.jose.tienda.data.Usuario;
import com.jose.tienda.data.dto.PagoDto;
import com.jose.tienda.service.PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pagos")
public class PagoController {

    @Autowired
    private PagoService  pagoService;


    @GetMapping("/getPago")
    public List<PagoDto> getTodosPagos(){
        return pagoService.getPagos();
    }

    @PostMapping("/guardarPago")
    public PagoDto guardarPago(@RequestBody PagoDto dto){
        return pagoService.guardarPago(dto);
    }

    @PutMapping("/editarPago/{id}")
    public PagoDto editarPago(@PathVariable Integer id, @RequestBody PagoDto dto) {
        return pagoService.editarPago(id, dto);
    }

    @DeleteMapping("/eliminarPago/{id}")
    public void eliminarPago(@PathVariable Integer id) {
        pagoService.eliminarPago(id);
    }
}