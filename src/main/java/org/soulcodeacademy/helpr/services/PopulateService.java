package org.soulcodeacademy.helpr.services;

import org.soulcodeacademy.helpr.domain.Cargo;
import org.soulcodeacademy.helpr.domain.Chamado;
import org.soulcodeacademy.helpr.domain.Cliente;
import org.soulcodeacademy.helpr.domain.Funcionario;
import org.soulcodeacademy.helpr.domain.enums.Perfil;
import org.soulcodeacademy.helpr.domain.enums.Status;
import org.soulcodeacademy.helpr.repositories.CargoRepository;
import org.soulcodeacademy.helpr.repositories.ChamadoRepository;
import org.soulcodeacademy.helpr.repositories.ClienteRepository;
import org.soulcodeacademy.helpr.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // indica para o Spring que esta classe será gerenciada por ele
public class PopulateService {

    @Autowired
    private PasswordEncoder encoder;
    @Autowired // injetar o objeto direto na classe
    private CargoRepository cargoRepository;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ChamadoRepository chamadoRepository;

    public void populate(){
        Cargo c1 = new Cargo(null, "Diretor Geral", "Gerencia a empresa", 30000.0);
        Cargo c2 = new Cargo(null, "Diretor Setor", "Gerencia o setor da empresa", 18000.0);
        Cargo c3 = new Cargo(null, "Tecnico Geral", "Resolve os chamados urgentes", 12000.0);

        Funcionario f1 = new Funcionario(null, "Renato Pereira", "renato.pereira@gmail.com", "94292417024", encoder.encode("12345"), null, c1);
        f1.setPerfil(Perfil.ADMIN);
        Funcionario f2 = new Funcionario(null, "Victor Icoma", "victor.icoma@gmail.com", "46250532773", encoder.encode("12345"), null, c1);

        Cliente cliente1 = new Cliente(null, "Fernando Silva", "fernando.silva@gmail.com", "39823783209", encoder.encode("12345"), "99-13456789");
        Cliente cliente2 = new Cliente(null, "Luiz Silva", "luiz.silva@gmail.com", "41181155819", encoder.encode("12345"), "99-65748390");

        Chamado chamado1 = new Chamado(null, "Primerio chamado", "Revisar entidades criadas");
        chamado1.setCliente(cliente1);
        Chamado chamado2 = new Chamado(null, "Segundo chamado", "Ativar VPN do sistema");
        chamado2.setCliente(cliente2);
        chamado2.setFuncionario(f1);
        chamado2.setStatus(Status.ATRIBUIDO);

//        this.cargoRepository.save(c1); //Equivalente ao Insert Into
//        this.cargoRepository.save(c2);
//        this.cargoRepository.save(c3);
//        this.funcionarioRepository.save(f1);
//        this.funcionarioRepository.save(f2);
//        this.clienteRepository.save(cliente1);
//        this.clienteRepository.save(cliente2);

        this.cargoRepository.saveAll(List.of(c1,c2,c3));
        this.funcionarioRepository.saveAll(List.of(f1,f2));
        this.clienteRepository.saveAll(List.of(cliente1,cliente2));
        this.chamadoRepository.saveAll(List.of(chamado1, chamado2));
    }
}

//o objetivo desta classe é inserir no banco, dados ficticios (de teste)
//IOC = inversion of Control
// Container = é o local onde o Spring guarda os objetos anotados
// @Service = indica que a classe é um serviço
// Injeção de dependencias = injeção de objeto na classe