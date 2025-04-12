package com.example.Papeleria.Service;

import com.example.Papeleria.Model.Venta;
import com.example.Papeleria.Repository.ClienteRepository;
import com.example.Papeleria.Repository.EmpleadoRepository;
import com.example.Papeleria.Repository.VentaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VentaService {

    public final VentaRepository ventaRepository;
    private final EmpleadoRepository empleadoRepository;
    private final ClienteService clienteService;
    private final ClienteRepository clienteRepository;

    public VentaService(VentaRepository ventaRepository, EmpleadoRepository empleadoRepository, ClienteService clienteService, ClienteRepository clienteRepository) {
        this.ventaRepository = ventaRepository;
        this.empleadoRepository = empleadoRepository;
        this.clienteService = clienteService;
        this.clienteRepository = clienteRepository;
    }

    public Venta guardarVenta(Venta venta) {

        try{
            if(venta.getCliente() == null || venta.getEmpleado() == null){
                throw new IllegalArgumentException("Datos incompletos.");
            }
            return ventaRepository.save(venta);

        }catch (Exception e){
            System.out.println("Error al guardar el venta: " + e.getMessage());
            throw new RuntimeException("No se pudo guardar el venta", e);
        }
    }

    public List<Venta> listarVenta() {
        try{
            return ventaRepository.findAll();
        }catch(Exception e){
            throw new RuntimeException("Error al listar ventas: " + e.getMessage(), e);
        }
    }

    public void eliminarVenta(long id) {
        try {
            if(!ventaRepository.existsById(id)){
                throw new IllegalArgumentException("No se encontro el venta con ID: " + id);
            }
            ventaRepository.deleteById(id);

        }catch(IllegalArgumentException e){
            System.out.println("Error al eliminar el venta: " + e.getMessage());
        }catch(Exception e) {
            System.out.println("Error al eliminar el venta: " + e.getMessage());
        }
    }

    public Optional<Venta> listarVentaPorId(long id) {
        try{
            if(!ventaRepository.existsById(id)){
                throw new IllegalArgumentException("No se encontro la venta con ID: " + id);
            }
            return ventaRepository.findById(id);
        }catch(Exception e){
            throw new RuntimeException("Error al buscar el venta por ID: " + id + e.getMessage(), e);
        }
    }

    public List<Venta> listarVentasPorEmpleado(long id){
        try{
            if(!empleadoRepository.existsById(id)){
                throw new IllegalArgumentException("No se encontro el empleado con ID: " + id);
            }
            return ventaRepository.listarVentasPorEmpleado(id);
        }catch(Exception e){
            System.out.println("Error al listar las ventas por empleado " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public List<Venta> listarVentasEmpleadoPorCliente(long idEmpleado, long idCliente){
        try{
            if(!empleadoRepository.existsById(idEmpleado)){
                throw new IllegalArgumentException("No se encontro el empleado con ID: " + idEmpleado);
            }else if (!clienteRepository.existsById(idCliente)) {
                throw new IllegalArgumentException("No se encontro el cliente con ID: " + idCliente);
            }
            return ventaRepository.listarVentasEmpleadoPorCliente(idEmpleado, idCliente);
        }catch(Exception e){
            System.out.println("Error al listar las ventas del empleado por cliente " + e.getMessage());
            return new ArrayList<>();
        }
    }

}
