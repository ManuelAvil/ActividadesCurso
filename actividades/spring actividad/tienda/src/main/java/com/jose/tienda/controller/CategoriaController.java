package com.jose.tienda.controller;


import com.jose.tienda.data.Categoria;
import com.jose.tienda.data.dto.CategoriaDto;
import com.jose.tienda.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService  categoriaService;


    @GetMapping("/getCategoria")
    public List<CategoriaDto> getTodasCategorias(){
        return categoriaService.getCategorias();
    }

    @PostMapping("/guardarCategoria")
    public CategoriaDto guardarCategoria(@RequestBody CategoriaDto dto){
        return categoriaService.guardarCategoria(dto);
    }

    @PutMapping("/editarCategoria/{id}")
    public CategoriaDto editarCategoria(@PathVariable Integer id, @RequestBody CategoriaDto dto) {
        return categoriaService.editarCategoria(id, dto);
    }

    @DeleteMapping("/eliminarCategoria/{id}")
    public void eliminarCategoria(@PathVariable Integer id) {
        categoriaService.eliminarCategoria(id);
    }
}
