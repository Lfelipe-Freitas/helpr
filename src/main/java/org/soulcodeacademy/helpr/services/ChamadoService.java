package org.soulcodeacademy.helpr.services;

import org.soulcodeacademy.helpr.domain.Chamado;
import org.soulcodeacademy.helpr.domain.Cliente;
import org.soulcodeacademy.helpr.domain.Funcionario;
import org.soulcodeacademy.helpr.domain.dto.ChamadoDTO;
import org.soulcodeacademy.helpr.domain.enums.Status;
import org.soulcodeacademy.helpr.repositories.ChamadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChamadoService {
    @Autowired
    private ChamadoRepository chamadoRepository;

    @Autowired ClienteService clienteService;

    @Autowired FuncionarioService funcionarioService;

    public List<Chamado> listar(){
        return this.chamadoRepository.findAll();
    }

    public Chamado getChamado(Integer idChamado){
        return this.chamadoRepository.findById(idChamado).orElseThrow(() -> new RuntimeException("Chamado não encontrado"));

//        Optional<Chamado> chamado = this.chamadoRepository.findById(idChamado);
//
//        if(chamado.isEmpty()){
//            throw new RuntimeException("Chamdo não encontrado");
//        } else {
//            return chamado.get();
//        }
    }

    public Chamado salvar(ChamadoDTO dto){
        Cliente cliente = this.clienteService.getCliente(dto.getIdCliente());

        Chamado novoChamado = new Chamado(null, dto.getTitulo(), dto.getDescricao());
        novoChamado.setCliente(cliente);
        return this.chamadoRepository.save(novoChamado);
    }

    public Chamado atualizar(Integer idChamado, ChamadoDTO dto){
        Chamado chamado = this.getChamado(idChamado);

        Cliente cliente = this.clienteService.getCliente(dto.getIdCliente());

        Funcionario funcionario = this.funcionarioService.getFuncionario(dto.getIdFuncionario());
        chamado.setFuncionario(funcionario);
        chamado.setStatus(dto.getStatus());
        chamado.setDescricao(dto.getDescricao());
        chamado.setTitulo(dto.getTitulo());

        return this.chamadoRepository.save(chamado);
    }

    public void deletar(Integer idChamado){
        Chamado chamado = this.getChamado(idChamado);

        this.chamadoRepository.delete(chamado);
    }

}
