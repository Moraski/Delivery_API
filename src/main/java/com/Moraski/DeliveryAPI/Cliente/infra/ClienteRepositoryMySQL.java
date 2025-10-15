package com.Moraski.DeliveryAPI.Cliente.infra;

import com.Moraski.DeliveryAPI.Cliente.application.repository.ClienteRepository;
import com.Moraski.DeliveryAPI.Cliente.domain.Cliente;
import com.Moraski.DeliveryAPI.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
@Slf4j
public class ClienteRepositoryMySQL implements ClienteRepository {

    private final ClienteMySQLSpringRepository clienteMySQLSpringRepository;

    @Override
    public Cliente salva(Cliente cliente) {
        log.info("[Inicia] ClienteRepositoryMySQL - salva");
        Cliente novoCliente = clienteMySQLSpringRepository.save(cliente);
        log.info("[Finaliza] ClienteRepositoryMySQL - salva");
        return novoCliente;
    }

    @Override
    public Optional<Cliente> buscaPorEmail(String email) {
        log.info("[Inicia] ClienteRepositoryMySQL - buscaPorEmail");
        Optional<Cliente> cliente = clienteMySQLSpringRepository.findByEmail(email);
        log.info("[Finaliza] ClienteRepositoryMySQL - buscaPorEmail");
        return cliente;
    }

    @Override
    public Cliente buscaPorId(UUID idCliente) {
        log.info("[Inicia] ClienteRepositoryMySQL - buscaPorId");
        Cliente cliente = clienteMySQLSpringRepository.findById(idCliente)
                        .orElseThrow(()-> APIException.build(HttpStatus.NOT_FOUND, "Cliente não encontrado!"));
        log.info("[Finaliza] ClienteRepositoryMySQL - buscaPorId");
        return cliente;
    }

    @Override
    public void deletaCliente(UUID idCliente) {
        log.info("[Inicia] ClienteRepositoryMySQL - deletaCliente");
        clienteMySQLSpringRepository.delete(buscaPorId(idCliente));
        log.info("[Finaliza] ClienteRepositoryMySQL - deletaCliente");
    }
}
