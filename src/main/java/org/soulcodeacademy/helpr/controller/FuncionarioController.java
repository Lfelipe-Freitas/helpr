package org.soulcodeacademy.helpr.controller;

import org.soulcodeacademy.helpr.domain.Funcionario;
import org.soulcodeacademy.helpr.domain.dto.FuncionarioDTO;
import org.soulcodeacademy.helpr.services.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping("/funcionarios")
    public List<Funcionario> listar() {
        return funcionarioService.listar();
    }

    // @RequestParam = Captura os valores de parâmetro após ?, ex: /funcionarios/salario?valor1=1000&valor2=2000
    @GetMapping("/funcionario/salario")
    List<Funcionario> listarPorFaixaSalarial(@RequestParam Double valor1, @RequestParam Double valor2) {
        return this.funcionarioService.listarPorFaixaSalarial(valor1, valor2);
    }

    @GetMapping("/funcionarios/{id}")
    public Funcionario getCFuncionario(@PathVariable Integer id) {
        return this.funcionarioService.getFuncionario(id);
    }

    @PostMapping("/funcionarios")
    public Funcionario salvar(@Valid @RequestBody FuncionarioDTO dto) {
        return this.funcionarioService.salvar(dto);
    }

    @PutMapping("/funcionarios/{id}")
    public Funcionario atualizar(@PathVariable Integer id, @Valid @RequestBody FuncionarioDTO dto) {
        return this.funcionarioService.atualizar(id, dto);
    }

    @DeleteMapping("/funcionarios/{id}")
    public void deletar(@PathVariable Integer id) {
        this.funcionarioService.deletar(id);

    }
}

