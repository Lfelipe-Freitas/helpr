package org.soulcodeacademy.helpr.controller;

import org.soulcodeacademy.helpr.domain.Chamado;
import org.soulcodeacademy.helpr.domain.dto.ChamadoDTO;
import org.soulcodeacademy.helpr.services.ChamadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @DeleteMapping("/chamados/{idChamados}")
    public void deletar(@PathVariable Integer idChamados){
        this.chamadoService.deletar(idChamados);
    }
}
