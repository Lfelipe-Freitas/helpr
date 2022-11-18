package org.soulcodeacademy.helpr.controller;

import org.soulcodeacademy.helpr.domain.Chamado;
import org.soulcodeacademy.helpr.domain.dto.ChamadoDTO;
import org.soulcodeacademy.helpr.domain.enums.Status;
import org.soulcodeacademy.helpr.services.ChamadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@RestController
public class ChamadoController {

    @Autowired
    private ChamadoService chamadoService;

    @GetMapping("/chamados")
    public List<Chamado> listar(){
        return this.chamadoService.listar();
    }
    @GetMapping("/chamados/{idChamado}")
    public Chamado listarChamado(@PathVariable Integer idChamado){
        return this.chamadoService.getChamado(idChamado);
    }

    @PostMapping("/chamados")
    public Chamado salvar(@Valid @RequestBody ChamadoDTO dto){
        return this.chamadoService.salvar(dto);
    }

    @PutMapping("/chamados/{idChamados}")
    public Chamado atualizar(@PathVariable Integer idChamados, @Valid @RequestBody ChamadoDTO dto){
        return this.chamadoService.atualizar(idChamados, dto);
    }

    @GetMapping("/chamados/clientes/{idCliente}")
    public List<Chamado> listarPorCliente(@PathVariable Integer idCliente) {
        return this.chamadoService.listarPorCliente(idCliente);
    }

    @GetMapping("/chamados/funcionarios/{idFuncionario}")
    public List<Chamado> listarPorFuncionario(@PathVariable Integer idFuncionario) {
        return this.chamadoService.listarPorFuncionario(idFuncionario);
    }

    /*
    Calculadora
    /soma?numero1=200&numero2=500 ===> 700
     */
    @GetMapping("/soma")
    public Integer soma(@RequestParam Integer numero1, @RequestParam Integer numero2){
        return numero1 + numero2;
    }

    //Listar por status
    @GetMapping("/chamados/status")
    public List<Chamado> listarPorStatus(@RequestParam Status status){
        return this.chamadoService.listarPorStatus(status);
    }
    //Listar por data (intervalo)
    @GetMapping("/chamados/intervalo")
    public List<Chamado> listarPorData(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date1, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date2){
        return this.chamadoService.listarPorIntervaloDatas(date1, date2);
    }
}
