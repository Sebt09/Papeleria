package com.example.Papeleria.Service;

import com.example.Papeleria.Model.Producto;
import com.example.Papeleria.Model.Proveedor;
import com.example.Papeleria.Repository.ProductoRepository;
import com.example.Papeleria.Repository.ProveedorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    public final ProductoRepository productoRepository;
    private final ProveedorService proveedorService;
    private final ProveedorRepository proveedorRepository;

    public ProductoService(ProductoRepository productoRepository, ProveedorService proveedorService, ProveedorRepository proveedorRepository) {
        this.productoRepository = productoRepository;
        this.proveedorService = proveedorService;
        this.proveedorRepository = proveedorRepository;
    }

    public Producto guardarProducto(Producto producto) {

        try{
            if(producto.getNombre() == null || producto.getNombre().isEmpty() || producto.getPrecio() <= 0){
                throw new IllegalArgumentException("El nombre y el precio no son validos.");
            }
            return productoRepository.save(producto);

        }catch (Exception e){
            System.out.println("Error al guardar el producto: " + e.getMessage());
            throw new RuntimeException("No se pudo guardar el producto", e);
        }
    }

    public List<Producto> listarProducto() {
        try{
            return productoRepository.findAll();
        }catch(Exception e){
            throw new RuntimeException("Error al listar productos: " + e.getMessage(), e);
        }
    }

    public void eliminarProducto(long id) {
        try {
            if(!productoRepository.existsById(id)){
                throw new IllegalArgumentException("No se encontro el producto con ID: " + id);
            }
            productoRepository.deleteById(id);

        }catch(IllegalArgumentException e){
            System.out.println("Error al eliminar el producto: " + e.getMessage());
        }catch(Exception e) {
            System.out.println("Error al eliminar el producto: " + e.getMessage());
        }
    }

    public Optional<Producto> listarProductoPorId(long id) {
        try{
            if(!productoRepository.existsById(id)){
                throw new IllegalArgumentException("No se encontro el producto con ID: " + id);
            }
            return productoRepository.findById(id);
        }catch(Exception e){
            throw new RuntimeException("Error al buscar el producto por ID: " + id + e.getMessage(), e);
        }
    }

    public List<Producto> listarProductosPorProveedor(long id) {
        try{
            if(!proveedorRepository.existsById(id)){
                throw new IllegalArgumentException("No se encontro el proveedor con ID: " + id);
            }
            return productoRepository.listarProductosPorProveedor(id);
        }catch(Exception e){
            System.out.println("Error al listar productos por proveedor " + e.getMessage());
            return new ArrayList<>();
        }
    }
}
