package org.soulcodeacademy.helpr.repositories;

import org.soulcodeacademy.helpr.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
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
// CRUD de funcionarios
// ordem de criação: Entidade -> Repository -> DTO -> Service + Controller