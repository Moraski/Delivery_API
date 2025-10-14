package com.Moraski.DeliveryAPI.Cliente.application.service;

import com.Moraski.DeliveryAPI.Cliente.application.api.ClienteNovoRequest;
import com.Moraski.DeliveryAPI.Cliente.application.api.ClienteResponse;
import com.Moraski.DeliveryAPI.Cliente.application.repository.ClienteRepository;
import com.Moraski.DeliveryAPI.Cliente.domain.Cliente;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClienteApplicationService implements ClienteService{

    private final ClienteRepository clienteRepository;

    @Override
    public ClienteResponse criarNovoCliente(ClienteNovoRequest clienteNovo) {
        log.info("[Inicia] ClienteApplicationService - criaNovoCliente");
        var cliente = new Cliente(clienteNovo);
        clienteRepository.salva(cliente);
        log.info("[Finaliza] ClienteApplicationService - criaNovoCliente");
        return null;
    }
}
