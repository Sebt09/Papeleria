package com.example.Papeleria.Controller;

import com.example.Papeleria.Model.Empleado;
import com.example.Papeleria.Service.EmpleadoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("apiempleado")
public class EmpleadoController {

    public final EmpleadoService empleadoService;


    public EmpleadoController(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    @PostMapping("/guardar")
    public Empleado guardarEmpleado(@RequestBody Empleado empleado){
        return empleadoService.guardarEmpleado(empleado);
    }

    @GetMapping("/listar")
    public List<Empleado> listarEmpleado(){
        return empleadoService.listarEmpleado();
    }

    @GetMapping("/buscar/{id}")
    public Optional<Empleado> listarEmpleadoPorId(@PathVariable long id){
        return empleadoService.listarEmpleadoPorId(id);
    }

    @DeleteMapping("eliminar/{id}")
    public void eliminarEmpleado(@PathVariable long id){
        empleadoService.eliminarEmpleado(id);
    }

    @PutMapping("actualizar")
    public Empleado actualizarEmpleado(@RequestBody Empleado empleado){
        return empleadoService.guardarEmpleado(empleado);
    }

}
