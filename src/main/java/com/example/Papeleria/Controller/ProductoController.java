package com.example.Papeleria.Controller;

import com.example.Papeleria.Model.Producto;
import com.example.Papeleria.Service.ProductoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("apiproducto")
public class ProductoController {

    public final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @PostMapping("/guardar")
    public Producto guardarProducto(@RequestBody Producto producto){
        return productoService.guardarProducto(producto);
    }

    @GetMapping("/listar")
    public List<Producto> listarProducto(){
        return productoService.listarProducto();
    }

    @GetMapping("/buscar/{id}")
    public Optional<Producto> listarProductoPorId(@PathVariable long id){
        return productoService.listarProductoPorId(id);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarProducto(@PathVariable long id){
        productoService.eliminarProducto(id);
    }

    @PutMapping("/actualizar")
    public Producto actualizarProducto(@RequestBody Producto producto){
        return productoService.guardarProducto(producto);
    }

    @GetMapping("/producto/proveedor/{id}")
    public List<Producto> listarProductosPorProveedor(@PathVariable long id){
        return productoService.listarProductosPorProveedor(id);
    }

}
