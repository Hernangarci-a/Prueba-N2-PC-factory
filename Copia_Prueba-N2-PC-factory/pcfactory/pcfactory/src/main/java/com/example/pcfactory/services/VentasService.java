package com.example.pcfactory.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.example.pcfactory.model.Ventas;
import com.example.pcfactory.repository.VentasRepository;
import jakarta.transaction.Transactional;

@Transactional
@Service
public class VentasService {
    @Autowired

    private VentasRepository ventasRepository;

    public List<Ventas> obtenerVentas(){
        return ventasRepository.findAll();
    }

    public Ventas obtenerPorId(Integer Id){
        return ventasRepository.findById(Id).orElse(null);
    }

    public List<Ventas> obtenerPorRutCliente(String rut){
        return ventasRepository.findByClienteRut(rut);
    }

    public Ventas guardarVentas(Ventas ventas){
        return ventasRepository.save(ventas);
    }

    public Ventas actualizarVenta(Integer id, Ventas ventaActualizada){
        return ventasRepository.|;
    }

    public void elminarVenta(Integer id){
        ventasRepository.deleteById(id);
    }
}