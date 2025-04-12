package com.example.Papeleria.Controller;


import com.example.Papeleria.Model.DetalleVenta;
import com.example.Papeleria.Service.DetalleVentaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("apidetalleventa")
public class DetalleVentaController {

    public final DetalleVentaService detalleVentaService;

    public DetalleVentaController(DetalleVentaService detalleVentaService) {
        this.detalleVentaService = detalleVentaService;
    }

    @PostMapping("/guardar")
    public DetalleVenta guardarDetalleVenta(@RequestBody DetalleVenta detalleVenta){
        return detalleVentaService.guardarDetalleVenta(detalleVenta);
    }

    @GetMapping("/listar")
    public List<DetalleVenta> listarDetalleVenta(){
        return detalleVentaService.listarDetalleVenta();
    }

    @GetMapping("/buscar/{id}")
    public Optional<DetalleVenta> listarDetalleVentaPorId(@PathVariable long id){
        return detalleVentaService.listarDetalleVentaPorId(id);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarDetalleVenta(@PathVariable long id){
        detalleVentaService.eliminarDetalleVenta(id);
    }

    @PutMapping("/actualizar")
    public DetalleVenta actualizarDetalleVenta(@RequestBody DetalleVenta detalleVenta){
        return detalleVentaService.guardarDetalleVenta(detalleVenta);
    }

    @GetMapping("/listar/empleado/{idEmpleado}/cliente/{idCliente}")
    public List<DetalleVenta> obtenerDetallesPorEmpleadoYCliente(@PathVariable long idEmpleado, @PathVariable long idCliente){
        return detalleVentaService.obtenerDetallesPorEmpleadoYCliente(idEmpleado, idCliente);
    }

}
