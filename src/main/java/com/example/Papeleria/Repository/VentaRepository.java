package com.example.Papeleria.Repository;

import com.example.Papeleria.Model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Long> {

    @Query(value = "SELECT * FROM Venta WHERE id_empleado = :IdEmpleado", nativeQuery = true)
    List<Venta> listarVentasPorEmpleado(@Param("IdEmpleado") long IdEmpleado);

    @Query(value = "SELECT * FROM Venta WHERE id_empleado = :IdEmpleado AND id_cliente = :IdCliente", nativeQuery = true)
    List<Venta> listarVentasEmpleadoPorCliente(@Param("IdEmpleado") long IdEmpleado, @Param("IdCliente") long IdCliente);

}
