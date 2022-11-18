package org.soulcodeacademy.helpr.repositories;

import org.soulcodeacademy.helpr.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
     Optional<Usuario> findByEmail(String email); // Where email = email

     Optional<Usuario> findByCpf(String cpf); // Where cpf = cpf

     List<Usuario> findByNomeContaining(String busca); // Filtrar pelo nome
}

// Seguindo a convenção findBy o Spring implementa o método derivado/customizado
// Obs: Optional = 1 resultado. Varios = LIST

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