package com.example.Papeleria.Service;

import com.example.Papeleria.Model.Cliente;
import com.example.Papeleria.Repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente guardarCliente(Cliente cliente) {

        try{
            if(cliente.getNombre() == null || cliente.getNombre().isEmpty() || cliente.getCedula() == null || cliente.getCedula().isEmpty()){
                throw new IllegalArgumentException("El nombre o la cedula no pueden estar vacíos.");
            }
            return clienteRepository.save(cliente);

        }catch (Exception e){
            System.out.println("Error al guardar el cliente: " + e.getMessage());
            throw new RuntimeException("No se pudo guardar el cliente", e);
        }
    }

    public List<Cliente> listarCliente() {
        try{
            return clienteRepository.findAll();
        }catch(Exception e){
            throw new RuntimeException("Error al listar clientes: " + e.getMessage(), e);
        }
    }

    public void eliminarCliente(long id) {
        try {
            if(!clienteRepository.existsById(id)){
                throw new IllegalArgumentException("No se encontro el cliente con ID: " + id);
            }
            clienteRepository.deleteById(id);

        }catch(IllegalArgumentException e){
            System.out.println("Error al eliminar el cliente: " + e.getMessage());
        }catch(Exception e) {
            System.out.println("Error al eliminar el cliente: " + e.getMessage());
        }
    }

    public Optional<Cliente> listarClientePorId(long id) {
        try{
            if(!clienteRepository.existsById(id)){
                throw new IllegalArgumentException("No se encontro el cliente con ID: " + id);
            }
            return clienteRepository.findById(id);
        }catch(Exception e){
            throw new RuntimeException("Error al buscar el cliente por ID: " + id + e.getMessage(), e);
        }
    }

}
