package com.jose.tienda.service;

import com.jose.tienda.data.Pago;
import com.jose.tienda.data.dto.PagoDto;
import com.jose.tienda.repository.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PagoService {

    @Autowired
    PagoRepository pagoRepository;

    public List<PagoDto> getPagos(){
        List<PagoDto> listaPagos = new ArrayList<>();

        for(Pago pago: pagoRepository.findAll()){
            PagoDto categoriaDto = new PagoDto();
            categoriaDto.setId(pago.getId());
            categoriaDto.setNombre(pago.getNombre());
            categoriaDto.setDescripcion(pago.getDescripcion());
            listaPagos.add(categoriaDto);
        }
        return listaPagos;
    }

    public PagoDto guardarPago(PagoDto dto){
        Pago pago = new Pago();
        pago.setNombre(dto.getNombre());
        pago.setDescripcion(dto.getDescripcion());
        pago = pagoRepository.save(pago);
        dto.setId(pago.getId());
        return dto;
    }

    public PagoDto editarPago(Integer id, PagoDto dto) {
        Pago pago = pagoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Método de pago no encontrado"));

        pago.setNombre(dto.getNombre());
        pago.setDescripcion(dto.getDescripcion());
        pago = pagoRepository.save(pago);

        PagoDto pagoDto = new PagoDto();
        pagoDto.setId(pago.getId());
        pagoDto.setNombre(pago.getNombre());
        pagoDto.setDescripcion(pago.getDescripcion());

        return pagoDto;
    }

    public void eliminarPago(Integer id) {
        pagoRepository.deleteById(id);
    }
}
