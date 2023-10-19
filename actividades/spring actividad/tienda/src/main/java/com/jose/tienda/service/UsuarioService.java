package com.jose.tienda.service;

import com.jose.tienda.data.Usuario;
import com.jose.tienda.data.dto.UsuarioDto;
import com.jose.tienda.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public List<UsuarioDto> getUsuarios(){
        List<UsuarioDto> listaUsuarios = new ArrayList<>();

        for(Usuario usuario: usuarioRepository.findAll()){
            UsuarioDto usuarioDto = new UsuarioDto();
            usuarioDto.setId(usuario.getId());
            usuarioDto.setNombre(usuario.getNombre());
            usuarioDto.setApellidoPaterno(usuario.getApellidoPaterno());
            usuarioDto.setApellidoMaterno(usuario.getApellidoMaterno());
            usuarioDto.setCorreo(usuario.getCorreo());
            usuarioDto.setRol(usuario.getRol());
            usuarioDto.setTelefono(usuario.getTelefono());
            usuarioDto.setDireccion(usuario.getDireccion());
            listaUsuarios.add(usuarioDto);
        }
        return listaUsuarios;
    }

    public UsuarioDto guardarUsuario(UsuarioDto dto){
        Usuario usuario = new Usuario();
        usuario.setNombre(dto.getNombre());
        usuario.setApellidoPaterno(dto.getApellidoPaterno());
        usuario.setApellidoMaterno(dto.getApellidoMaterno());
        usuario.setCorreo(dto.getCorreo());
        usuario.setRol(dto.getRol());
        usuario.setTelefono(dto.getTelefono());
        usuario.setDireccion(dto.getDireccion());
        usuario = usuarioRepository.save(usuario);
        dto.setId(usuario.getId());
        return dto;
    }

    public UsuarioDto editarUsuario(Integer id, UsuarioDto dto) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        usuario.setNombre(dto.getNombre());
        usuario.setApellidoPaterno(dto.getApellidoPaterno());
        usuario.setApellidoMaterno(dto.getApellidoMaterno());
        usuario.setCorreo(dto.getCorreo());
        usuario.setRol(dto.getRol());
        usuario.setTelefono(dto.getTelefono());
        usuario.setDireccion(dto.getDireccion());
        usuario = usuarioRepository.save(usuario);

        UsuarioDto usuarioDto = new UsuarioDto();
        usuarioDto.setId(usuario.getId());
        usuarioDto.setNombre(usuario.getNombre());
        usuarioDto.setApellidoPaterno(usuario.getApellidoPaterno());
        usuarioDto.setApellidoMaterno(usuario.getApellidoMaterno());
        usuarioDto.setCorreo(usuario.getCorreo());
        usuarioDto.setRol(usuario.getRol());
        usuarioDto.setTelefono(usuario.getTelefono());
        usuarioDto.setDireccion(usuario.getDireccion());

        return usuarioDto;
    }

    public void eliminarUsuario(Integer id) {
        usuarioRepository.deleteById(id);
    }
}
