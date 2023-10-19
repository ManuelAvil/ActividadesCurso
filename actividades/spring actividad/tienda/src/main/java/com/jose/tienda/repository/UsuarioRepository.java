package com.jose.tienda.repository;

import com.jose.tienda.data.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {



}
