package com.example.Papeleria.Service;


import com.example.Papeleria.Model.Proveedor;
import com.example.Papeleria.Repository.ProveedorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProveedorService {

    public final ProveedorRepository proveedorRepository;

    public ProveedorService(ProveedorRepository proveedorRepository) {
        this.proveedorRepository = proveedorRepository;
    }

    public Proveedor guardarProveedor(Proveedor proveedor) {

        try{
            if(proveedor.getNombre() == null || proveedor.getNombre().isEmpty() || proveedor.getTelefono() == null || proveedor.getTelefono().isEmpty()){
                throw new IllegalArgumentException("El nombre y el cargo no pueden estar vacíos.");
            }
            return proveedorRepository.save(proveedor);

        }catch (Exception e){
            System.out.println("Error al guardar el proveedor: " + e.getMessage());
            throw new RuntimeException("No se pudo guardar el proveedor", e);
        }
    }

    public List<Proveedor> listarProveedor() {
        try{
            return proveedorRepository.findAll();
        }catch(Exception e){
            throw new RuntimeException("Error al listar proveedors: " + e.getMessage(), e);
        }
    }

    public void eliminarProveedor(long id) {
        try {
            if(!proveedorRepository.existsById(id)){
                throw new IllegalArgumentException("No se encontro el proveedor con ID: " + id);
            }
            proveedorRepository.deleteById(id);

        }catch(IllegalArgumentException e){
            System.out.println("Error al eliminar el proveedor: " + e.getMessage());
        }catch(Exception e) {
            System.out.println("Error al eliminar el proveedor: " + e.getMessage());
        }
    }

    public Optional<Proveedor> listarProveedorPorId(long id) {
        try{
            if(!proveedorRepository.existsById(id)){
                throw new IllegalArgumentException("No se encontro el proveedor con ID: " + id);
            }
            return proveedorRepository.findById(id);
        }catch(Exception e){
            throw new RuntimeException("Error al buscar el proveedor por ID: " + id + e.getMessage(), e);
        }
    }
}
