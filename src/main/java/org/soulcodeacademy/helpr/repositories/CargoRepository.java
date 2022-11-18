package org.soulcodeacademy.helpr.repositories;

import org.soulcodeacademy.helpr.domain.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CargoRepository extends JpaRepository<Cargo, Integer> {
     List<Cargo> findByNome(String valor); // Where nome = valor

     List<Cargo> findBySalario(Double valor); // Where salario = valor

     List<Cargo> findBySalarioGreaterThan(Double valor); // Where salario > valor

     List<Cargo> findBySalarioGreaterThanEqual(Double valor); // Where salario >= valor

     List<Cargo> findBySalarioLessThan(Double valor); // Where salario < valor

     List<Cargo> findBySalarioLessThanEqual(Double valor); // Where salario <= valor

     List<Cargo> findBySalarioBetween(Double valor1, Double valor2); // WHERE salario entre valor1 e valor 2
}

/*
 -> Repository é um recurso que permite manipular a entidade no banco de dados. Pode Adicionar entidades, atualizar entidades, remover entidades e listar (CRUD).
 -> Indicar qual a entidade vai ser gerenciada pelo repository e qual o tipo da PK.
OBS: o Spring gera uma classe dinamica com base em nossa interface Cargo
 -> CrudRepository = contem as operações basicas de um banco de dados
 -> JpaRepository = possui mais funcionalidades p/ tratar a entidade
 Metodos presentes:
    -findAll => SELECT * FROM usuarios
    -findById (Integer) => SELECT * FROM usuarios WHERE id = ?
    -save (Entidade) => INSERT INTO(caso id nulo) ou UPDATE (caso id nao nulo)
    -delete (Entidade) => DELETE FROM usuarios where id = ?;
 */