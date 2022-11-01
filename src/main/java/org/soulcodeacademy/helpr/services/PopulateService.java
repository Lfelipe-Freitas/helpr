package org.soulcodeacademy.helpr.services;

import org.soulcodeacademy.helpr.domain.Cargo;
import org.soulcodeacademy.helpr.repositories.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // indica para o Spring que esta classe será gerenciada por ele
public class PopulateService {
    @Autowired // injetar o objeto direto na classe
    private CargoRepository cargoRepository;

    public void populate(){
        Cargo c1 = new Cargo(null, "Diretor Geral", "Gerencia a empresa", 30000.0);
        Cargo c2 = new Cargo(null, "Diretor Setor", "Gerencia o setor da empresa", 18000.0);
        Cargo c3 = new Cargo(null, "Tecnico Geral", "Resolve os chamados urgentes", 12000.0);

        this.cargoRepository.save(c1); //Equivalente ao Insert Into
        this.cargoRepository.save(c2);
        this.cargoRepository.save(c3);
    }
}

//o objetivo desta classe é inserir no banco, dados ficticios (de teste)
//IOC = inversion of Control
// Container = é o local onde o Spring guarda os objetos anotados
// @Service = indica que a classe é um serviço
// Injeção de dependencias = injeção de objeto na classe