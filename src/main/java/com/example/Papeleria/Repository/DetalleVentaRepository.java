package com.example.Papeleria.Repository;

import com.example.Papeleria.Model.DetalleVenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetalleVentaRepository extends JpaRepository<DetalleVenta, Long> {

    @Query(value = "SELECT dv.* FROM Detalle_Venta dv INNER JOIN Venta v ON dv.id_venta = v.id WHERE v.id_empleado = :idEmpleado AND v.id_cliente = :idCliente", nativeQuery = true)
    List<DetalleVenta> obtenerDetallesPorEmpleadoYCliente(@Param("idEmpleado") long idEmpleado, @Param("idCliente") long idCliente);

}
