package com.Moraski.DeliveryAPI.Cliente.infra;

import com.Moraski.DeliveryAPI.Cliente.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ClienteMySQLSpringRepository extends JpaRepository<Cliente, UUID> {
    Optional<Cliente> findByEmail(String email);
}
