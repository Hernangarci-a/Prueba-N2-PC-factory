package com.example.pcfactory.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.example.pcfactory.model.Sucursal;
import com.example.pcfactory.repository.SucursalRepository;
import jakarta.transaction.Transactional;

@Transactional
@Service
public class SucursalService {
    @Autowired
    private SucursalRepository sucursalRepository;

    public List<Sucursal> obtenerSucursal(){
        return sucursalRepository.findAll();
    }

    public Sucursal obtenerPorId(Integer id){
        return sucursalRepository.findById(id).orElse(null);
    }

    public Sucursal actualizarSucursal(Sucursal sucursal){
        return sucursalRepository.save(sucursal);
    }

    public void eliminarSucursal(Intger id){
        sucursalRepository.delete(id);
    }
}
