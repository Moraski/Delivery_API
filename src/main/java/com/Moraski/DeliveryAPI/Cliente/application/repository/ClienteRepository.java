package com.Moraski.DeliveryAPI.Cliente.application.repository;

import com.Moraski.DeliveryAPI.Cliente.domain.Cliente;

import java.util.Optional;
import java.util.UUID;

public interface ClienteRepository {
    Cliente salva(Cliente cliente);
    Optional<Cliente> buscaPorEmail(String email);
    Cliente buscaPorId(UUID idCliente);
}
