package com.example.Papeleria.Controller;

import com.example.Papeleria.Model.Cliente;
import com.example.Papeleria.Service.ClienteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("apicliente")
public class ClienteController {

    public final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping("/guardar")
    public Cliente guardarCliente(@RequestBody Cliente cliente){
        return clienteService.guardarCliente(cliente);
    }

    @GetMapping("/listar")
    public List<Cliente> listarCliente(){
        return clienteService.listarCliente();
    }

    @GetMapping("/buscar/{id}")
    public Optional<Cliente> listarClientePorId(@PathVariable long id){
        return clienteService.listarClientePorId(id);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarCliente(@PathVariable long id){
        clienteService.eliminarCliente(id);
    }

    @PutMapping("/actualizar")
    public Cliente actualizarCliente(@RequestBody Cliente cliente){
        return clienteService.guardarCliente(cliente);
    }

}
