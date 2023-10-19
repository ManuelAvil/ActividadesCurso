package com.jose.tienda.repository;

import com.jose.tienda.data.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto,Integer> {

}