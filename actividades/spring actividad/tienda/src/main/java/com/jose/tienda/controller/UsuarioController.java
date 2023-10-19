package com.jose.tienda.controller;


import com.jose.tienda.data.Usuario;
import com.jose.tienda.data.dto.UsuarioDto;
import com.jose.tienda.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService  usuarioService;


    @GetMapping("/getUsuario")
    public List<UsuarioDto> getTodosUsuarios(){
        return usuarioService.getUsuarios();
    }

    @PostMapping("/guardarUsuario")
    public UsuarioDto guardarUsuario(@RequestBody UsuarioDto dto){
        return usuarioService.guardarUsuario(dto);
    }

    @PutMapping("/editarUsuario/{id}")
    public UsuarioDto editarUsuario(@PathVariable Integer id, @RequestBody UsuarioDto dto) {
        return usuarioService.editarUsuario(id, dto);
    }

    @DeleteMapping("/eliminarUsuario/{id}")
    public void eliminarUsuario(@PathVariable Integer id) {
        usuarioService.eliminarUsuario(id);
    }
}