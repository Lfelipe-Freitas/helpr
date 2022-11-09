package org.soulcodeacademy.helpr.services;

import org.soulcodeacademy.helpr.domain.Cargo;
import org.soulcodeacademy.helpr.domain.Funcionario;
import org.soulcodeacademy.helpr.domain.dto.FuncionarioDTO;
import org.soulcodeacademy.helpr.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private CargoService cargoService;

    public List<Funcionario> listar(){
        return this.funcionarioRepository.findAll();
    }

    public Funcionario getFuncionario(Integer id){
        Optional<Funcionario> funcionario = this.funcionarioRepository.findById(id);

        if(funcionario.isEmpty()){
            throw new RuntimeException("O funcionario não foi encontrado");
        } else {
            return funcionario.get();
        }
    }

    public Funcionario salvar(FuncionarioDTO dto){
        Cargo cargo = this.cargoService.getCargo(dto.getIdCargo()); // verificando se o cargo existe mesmo
        Funcionario funcionario = new Funcionario(null, dto.getNome(), dto.getEmail(), dto.getCpf(), dto.getSenha(), dto.getFoto(), cargo);
        this.funcionarioRepository.save(funcionario);
        return funcionario;
    }

    public Funcionario atualizar(Integer id, FuncionarioDTO dto){
        // Verificar se o funcionario existe mesmo
        Funcionario funcionarioAtual = this.getFuncionario(id);

        //Busca os dados do cargo a ser alterado.
        Cargo cargo = this.cargoService.getCargo(dto.getIdCargo());

        funcionarioAtual.setNome(dto.getNome());
        funcionarioAtual.setEmail(dto.getEmail());
        funcionarioAtual.setCpf(dto.getCpf());
        funcionarioAtual.setFoto(dto.getFoto());
        funcionarioAtual.setSenha(dto.getSenha());
        funcionarioAtual.setCargo(cargo);

        return this.funcionarioRepository.save(funcionarioAtual);
    }

    public void deletar(Integer id){
        Funcionario funcionario = this.getFuncionario(id);

        this.funcionarioRepository.delete(funcionario);
    }
}
