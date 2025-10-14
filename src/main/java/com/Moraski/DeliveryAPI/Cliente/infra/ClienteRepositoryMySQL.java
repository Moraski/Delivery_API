package com.Moraski.DeliveryAPI.Cliente.infra;

import com.Moraski.DeliveryAPI.Cliente.application.repository.ClienteRepository;
import com.Moraski.DeliveryAPI.Cliente.domain.Cliente;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

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
}
