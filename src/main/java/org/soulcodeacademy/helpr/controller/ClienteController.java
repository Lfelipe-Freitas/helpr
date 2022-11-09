package org.soulcodeacademy.helpr.controller;

import org.soulcodeacademy.helpr.domain.Cliente;
import org.soulcodeacademy.helpr.domain.dto.ClienteDTO;
import org.soulcodeacademy.helpr.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/clientes")
    public List<Cliente> listar(){
        return this.clienteService.listar();
    }

    @GetMapping("/clientes/{idCliente}")
    public Cliente getCliente(@PathVariable Integer idCliente){
        return this.clienteService.getCliente(idCliente);
    }

    @PostMapping("/clientes")
    public Cliente salvar(@Valid @RequestBody ClienteDTO dto){
        return this.clienteService.salvar(dto);
    }

    @PutMapping("/clientes/{idCliente}")
    public Cliente atualizar(@PathVariable Integer idCliente, @Valid @RequestBody ClienteDTO dto){
        return this.clienteService.atualizar(idCliente, dto);
    }

    @DeleteMapping("/clientes/{idCliente}")
    public void deletar(@PathVariable Integer idCliente){
        this.clienteService.deletar(idCliente);
    }
}
