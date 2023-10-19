package com.jose.tienda.service;

import com.jose.tienda.data.Categoria;
import com.jose.tienda.data.dto.CategoriaDto;
import com.jose.tienda.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository categoriaRepository;

    public List<CategoriaDto> getCategorias(){
        List<CategoriaDto> listaCategorias = new ArrayList<>();

        for(Categoria categoria: categoriaRepository.findAll()){
            CategoriaDto categoriaDto = new CategoriaDto();
            categoriaDto.setId(categoria.getId());
            categoriaDto.setNombre(categoria.getNombre());
            categoriaDto.setDescripcion(categoria.getDescripcion());
            listaCategorias.add(categoriaDto);
        }
        return listaCategorias;
    }

    public CategoriaDto guardarCategoria(CategoriaDto dto){
        Categoria categoria = new Categoria();
        categoria.setNombre(dto.getNombre());
        categoria.setDescripcion(dto.getDescripcion());
        categoria = categoriaRepository.save(categoria);
        dto.setId(categoria.getId());
        return dto;
    }

    public CategoriaDto editarCategoria(Integer id, CategoriaDto dto) {
        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));

        categoria.setNombre(dto.getNombre());
        categoria.setDescripcion(dto.getDescripcion());
        categoria = categoriaRepository.save(categoria);

        CategoriaDto categoriaDto = new CategoriaDto();
        categoriaDto.setId(categoria.getId());
        categoriaDto.setNombre(categoria.getNombre());
        categoriaDto.setDescripcion(categoria.getDescripcion());

        return categoriaDto;
    }

    public void eliminarCategoria(Integer id) {
        categoriaRepository.deleteById(id);
    }
}