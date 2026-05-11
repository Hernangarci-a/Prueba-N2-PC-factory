package com.example.pcfactory.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.pcfactory.dto.ClienteDTO;
import com.example.pcfactory.model.Cliente;
import com.example.pcfactory.repository.ClienteRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public List<ClienteDTO> obtenerTodos(){
        return clienteRepository.findAll().stream()
                .map(this::convertirADTO)
                .toList();
    }

    public ClienteDTO buscarPorId(Integer id){
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("no se econtro cliente con ID: " + id));
        return convertirADTO(cliente);
    }

    public Cliente buscarCliente(Integer id){
        return clienteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("no se encontro un cliente con ID: " + id));
    }

    public Cliente guardarCliente(Cliente cliente){
        if (cliente.getNombreCliente() == null || cliente.getApellidoCliente().trim().isEmpty()){
            throw new RuntimeException("el nombre no debe estar vacio");
        }
        return clienteRepository.save(cliente);
    }

    public String eliminarCliente(Integer id){
        try{
            Cliente cliente = clienteRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("no se puede eliminar al cliente con ID " + id + " no existe."));
            clienteRepository.delete(cliente);
            return "el cliente " + cliente.getNombreCliente() + " se elimino";
        } catch (RuntimeException e){
            return e.getMessage();
        }
    }

    private ClienteDTO convertirADTO(Cliente cliente){
        ClienteDTO dto = new ClienteDTO();
        dto.setIdCliente(cliente.getIdCliente());
        dto.setPrimerNombre(cliente.getNombreCliente());
        dto.setApellidoCliente(cliente.getApellidoCliente());
        return dto;
    }
}