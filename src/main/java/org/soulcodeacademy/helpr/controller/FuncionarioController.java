package org.soulcodeacademy.helpr.controller;

import org.soulcodeacademy.helpr.domain.Funcionario;
import org.soulcodeacademy.helpr.services.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping("/funcionarios")
    public List<Funcionario> listar(){
        return funcionarioService.listar();
    }

    @GetMapping("/funcionarios/{id}")
    public Funcionario getCargo(@PathVariable Integer id){
        return this.funcionarioService.getCargo(id);
    }

}
