package org.soulcodeacademy.helpr.repositories;

import org.soulcodeacademy.helpr.domain.Chamado;
import org.soulcodeacademy.helpr.domain.Cliente;
import org.soulcodeacademy.helpr.domain.Funcionario;
import org.soulcodeacademy.helpr.domain.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ChamadoRepository extends JpaRepository<Chamado, Integer> {
    List<Chamado> findByStatus(Status status); // Filtrar os chamados de acordo com o status

    List<Chamado> findByCliente(Cliente cliente); //Filtrar os chamados de um cliente.

    List<Chamado> findByFuncionario(Funcionario funcionario); //Filtrar os chamados de um Funcionario.

    @Query(value = "SELECT * FROM chamado WHERE data_abertura BETWEEN :date1 AND :date2", nativeQuery = true)
    List<Chamado> buscarEntreDatas(LocalDate date1, LocalDate date2);
}
