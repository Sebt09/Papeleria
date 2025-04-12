package com.example.Papeleria.Controller;


import com.example.Papeleria.Model.Proveedor;
import com.example.Papeleria.Service.ProveedorService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("apiproveedor")
public class ProveedorController {

    public final ProveedorService proveedorService;

    public ProveedorController(ProveedorService proveedorService) {
        this.proveedorService = proveedorService;
    }

    @PostMapping("/guardar")
    public Proveedor guardarProveedor(@RequestBody Proveedor proveedor){
        return proveedorService.guardarProveedor(proveedor);
    }

    @GetMapping("/listar")
    public List<Proveedor> listarProveedor(){
        return proveedorService.listarProveedor();
    }

    @GetMapping("/buscar/{id}")
    public Optional<Proveedor> listarProveedorPorId(@PathVariable long id){
        return proveedorService.listarProveedorPorId(id);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarProveedor(@PathVariable long id){
        proveedorService.eliminarProveedor(id);
    }

    @PutMapping("/actualizar")
    public Proveedor actualizarProveedor(@RequestBody Proveedor proveedor){
        return proveedorService.guardarProveedor(proveedor);
    }
}
