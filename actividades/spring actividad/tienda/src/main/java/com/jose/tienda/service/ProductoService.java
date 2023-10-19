package com.jose.tienda.service;

import com.jose.tienda.data.Categoria;
import com.jose.tienda.data.Producto;
import com.jose.tienda.data.dto.ProductoDto;
import com.jose.tienda.repository.CategoriaRepository;
import com.jose.tienda.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoService {


    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;



    public ProductoDto guardarProducto(ProductoDto productoDTO){
        Producto productoNuevo = new Producto();
        productoNuevo.setDescripcion(productoDTO.getDescripcion());
        productoNuevo.setNombre(productoDTO.getNombre());
        productoNuevo.setCantidad(productoDTO.getCantidad());
        productoNuevo.setPrecio(productoDTO.getPrecio());

        Categoria categoria = buscarCategoriaPorId(productoDTO.getIdCategoria());
        productoNuevo.setCategoria(categoria);
        productoRepository.save(productoNuevo);
        productoDTO.setId(productoNuevo.getId());
        return productoDTO;
    }

    private Categoria buscarCategoriaPorId(int idCategoria) {
        Categoria categoria = categoriaRepository.getReferenceById(idCategoria);
        return categoria;
    }
}