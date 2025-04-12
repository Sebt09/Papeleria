package com.example.Papeleria.Controller;

import com.example.Papeleria.Model.Venta;
import com.example.Papeleria.Service.VentaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("apiventa")
public class VentaController {
    
    public final VentaService ventaService;

    public VentaController(VentaService ventaService) {
        this.ventaService = ventaService;
    }

    @PostMapping("/guardar")
    public Venta guardarVenta(@RequestBody Venta venta){
        return ventaService.guardarVenta(venta);
    }

    @GetMapping("/listar")
    public List<Venta> listarVenta(){
        return ventaService.listarVenta();
    }

    @GetMapping("/buscar/{id}")
    public Optional<Venta> listarVentaPorId(@PathVariable long id){
        return ventaService.listarVentaPorId(id);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarVenta(@PathVariable long id){
        ventaService.eliminarVenta(id);
    }

    @PutMapping("/actualizar")
    public Venta actualizarVenta(@RequestBody Venta venta){
        return ventaService.guardarVenta(venta);
    }

    @GetMapping("/listar/empleado/{id}")
    public List<Venta> listarVentasPorEmpleado(@PathVariable long id){
        return ventaService.listarVentasPorEmpleado(id);
    }

    @GetMapping("/listar/empleado/{idEmpleado}/cliente/{idCliente}")
    public List<Venta> listarVentasEmpleadoPorCliente(@PathVariable long idEmpleado, @PathVariable long idCliente){
        return ventaService.listarVentasEmpleadoPorCliente(idEmpleado, idCliente);
    }

}
