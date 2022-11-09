package org.soulcodeacademy.helpr.repositories;

import org.soulcodeacademy.helpr.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
