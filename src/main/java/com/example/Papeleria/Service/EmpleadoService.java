package com.example.Papeleria.Service;

import com.example.Papeleria.Model.Empleado;
import com.example.Papeleria.Model.Proveedor;
import com.example.Papeleria.Repository.EmpleadoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class EmpleadoService {

    private final EmpleadoRepository empleadoRepository;

    public EmpleadoService(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    public Empleado guardarEmpleado(Empleado empleado) {

        try{
            if(empleado.getNombre() == null || empleado.getNombre().isEmpty() || empleado.getCargo() == null || empleado.getCargo().isEmpty()){
                throw new IllegalArgumentException("El nombre y el cargo no pueden estar vacíos.");
            }
            return empleadoRepository.save(empleado);

        }catch (Exception e){
            System.out.println("Error al guardar el empleado: " + e.getMessage());
            throw new RuntimeException("No se pudo guardar el empleado", e);
        }
    }

    public List<Empleado> listarEmpleado() {
        try{
            return empleadoRepository.findAll();
        }catch(Exception e){
            throw new RuntimeException("Error al listar empleados: " + e.getMessage(), e);
        }
    }

    public void eliminarEmpleado(long id) {
        try {
            if(!empleadoRepository.existsById(id)){
                throw new IllegalArgumentException("No se encontro el empleado con ID: " + id);
            }
            empleadoRepository.deleteById(id);

        }catch(IllegalArgumentException e){
            System.out.println("Error al eliminar el empleado: " + e.getMessage());
        }catch(Exception e) {
            System.out.println("Error al eliminar el empleado: " + e.getMessage());
        }
    }

    public Optional<Empleado> listarEmpleadoPorId(long id) {
        try{
            if(!empleadoRepository.existsById(id)){
                throw new IllegalArgumentException("No se encontro el empleado con ID: " + id);
            }
            return empleadoRepository.findById(id);
        }catch(Exception e){
            throw new RuntimeException("Error al buscar el empleado por ID: " + id + e.getMessage(), e);
        }
    }

}