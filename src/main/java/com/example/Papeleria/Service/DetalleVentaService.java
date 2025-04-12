package com.example.Papeleria.Service;

import com.example.Papeleria.Model.DetalleVenta;
import com.example.Papeleria.Repository.DetalleVentaRepository;
import com.example.Papeleria.Repository.EmpleadoRepository;
import com.example.Papeleria.Repository.ClienteRepository;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class DetalleVentaService {

    private final DetalleVentaRepository detalleVentaRepository;
    private final EmpleadoRepository empleadoRepository;
    private final ClienteRepository clienteRepository;

    public DetalleVentaService(DetalleVentaRepository detalleVentaRepository, EmpleadoRepository empleadoRepository, ClienteRepository clienteRepository) {
        this.detalleVentaRepository = detalleVentaRepository;
        this.empleadoRepository = empleadoRepository;
        this.clienteRepository = clienteRepository;
    }

    public DetalleVenta guardarDetalleVenta(DetalleVenta detalleVenta) {

        try{
            if(detalleVenta.getCantidad() <= 0){
                throw new IllegalArgumentException("Datos invalidos");
            }
            return detalleVentaRepository.save(detalleVenta);

        }catch (Exception e){
            System.out.println("Error al guardar el detalle de la venta: " + e.getMessage());
            throw new RuntimeException("No se pudo guardar el detalle de la venta", e);
        }
    }

    public List<DetalleVenta> listarDetalleVenta() {
        try{
            return detalleVentaRepository.findAll();
        }catch(Exception e){
            throw new RuntimeException("Error al listar detalle de las ventas: " + e.getMessage(), e);
        }
    }

    public void eliminarDetalleVenta(long id) {
        try {
            if(!detalleVentaRepository.existsById(id)){
                throw new IllegalArgumentException("No se encontro el detalle de la venta con ID: " + id);
            }
            detalleVentaRepository.deleteById(id);

        }catch(IllegalArgumentException e){
            System.out.println("Error al eliminar el detalle de la venta: " + e.getMessage());
        }catch(Exception e) {
            System.out.println("Error al eliminar el detalle de la venta: " + e.getMessage());
        }
    }

    public Optional<DetalleVenta> listarDetalleVentaPorId(long id) {
        try{
            if(!detalleVentaRepository.existsById(id)){
                throw new IllegalArgumentException("No se encontro el detalle de la venta con ID: " + id);
            }
            return detalleVentaRepository.findById(id);
        }catch(Exception e){
            throw new RuntimeException("Error al buscar el detalle de la venta por ID: " + e.getMessage(), e);
        }
    }

    public List<DetalleVenta> obtenerDetallesPorEmpleadoYCliente(long idEmpleado, long idCliente){
        try{
            if(!empleadoRepository.existsById(idEmpleado)){
                throw new IllegalArgumentException("No se encontro el empleado con ID: " + idEmpleado);
            }else if (!clienteRepository.existsById(idCliente)) {
                throw new IllegalArgumentException("No se encontro el cliente con ID: " + idCliente);
            }
            return detalleVentaRepository.obtenerDetallesPorEmpleadoYCliente(idEmpleado, idCliente);
        }catch(Exception e){
            System.out.println("Error al listar el detalle de las ventas del empleado por cliente " + e.getMessage());
            return new ArrayList<>();
        }
    }

}
