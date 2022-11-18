package org.soulcodeacademy.helpr.services;

import org.soulcodeacademy.helpr.domain.Chamado;
import org.soulcodeacademy.helpr.domain.Cliente;
import org.soulcodeacademy.helpr.domain.Funcionario;
import org.soulcodeacademy.helpr.domain.dto.ChamadoDTO;
import org.soulcodeacademy.helpr.domain.enums.Status;
import org.soulcodeacademy.helpr.repositories.ChamadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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

        if(dto.getIdFuncionario() == null){
            throw new RuntimeException("idFuncionario obrigatório");
        } else {
            Funcionario funcionario = this.funcionarioService.getFuncionario(dto.getIdFuncionario());

            switch (dto.getStatus()) {

                case RECEBIDO -> {
                    chamado.setStatus(Status.RECEBIDO);
                    chamado.setFuncionario(null);
                    chamado.setDataFechamento(null);
                }
                case ATRIBUIDO -> {
                    chamado.setStatus(Status.ATRIBUIDO);
                    chamado.setFuncionario(funcionario);
                    chamado.setDataFechamento(null);
                }
                case CONCLUIDO -> {
                    chamado.setStatus(Status.CONCLUIDO);
                    chamado.setFuncionario(funcionario);
                    chamado.setDataFechamento(LocalDate.now());
                }
            }
        }

        chamado.setStatus(dto.getStatus());
        chamado.setDescricao(dto.getDescricao());
        chamado.setTitulo(dto.getTitulo());

        return this.chamadoRepository.save(chamado);
    }

    public List<Chamado> listarPorStatus(Status status){
        return this.chamadoRepository.findByStatus(status);
    }

    public List<Chamado> listarPorFuncionario(Integer idFuncionario) {
        Funcionario funcionario = this.funcionarioService.getFuncionario(idFuncionario);
        return this.chamadoRepository.findByFuncionario(funcionario);
    }

    public List<Chamado> listarPorCliente(Integer idCliente) {
        Cliente cliente = this.clienteService.getCliente(idCliente);
        return this.chamadoRepository.findByCliente(cliente);
    }

    public List<Chamado> listarPorIntervaloDatas(LocalDate date1, LocalDate date2){
        return this.chamadoRepository.buscarEntreDatas(date1, date2);
    }
}
