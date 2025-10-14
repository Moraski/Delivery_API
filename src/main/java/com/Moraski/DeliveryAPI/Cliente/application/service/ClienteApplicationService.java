package com.Moraski.DeliveryAPI.Cliente.application.service;

import com.Moraski.DeliveryAPI.Cliente.application.api.ClienteNovoRequest;
import com.Moraski.DeliveryAPI.Cliente.application.api.ClienteResponse;
import com.Moraski.DeliveryAPI.Cliente.application.repository.ClienteRepository;
import com.Moraski.DeliveryAPI.Cliente.domain.Cliente;
import com.Moraski.DeliveryAPI.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClienteApplicationService implements ClienteService{

    private final ClienteRepository clienteRepository;

    @Override
    public ClienteResponse criarNovoCliente(ClienteNovoRequest clienteNovo) {
        log.info("[Inicia] ClienteApplicationService - criaNovoCliente");

        boolean verificaEmail = clienteRepository.buscaPorEmail(clienteNovo.getEmail()).isPresent();
        if (verificaEmail) {
            log.warn("[Falha] Tentativa de cadastro com e-mail já existente: {}", clienteNovo.getEmail());
            throw APIException.build(HttpStatus.CONFLICT, "Já existe um cliente com este e-mail.");
        }

        var cliente = new Cliente(clienteNovo);
        clienteRepository.salva(cliente);
        log.info("[Finaliza] ClienteApplicationService - criaNovoCliente");
        return new ClienteResponse(cliente);
    }

    @Override
    public ClienteResponse buscarClientePorId(UUID idCliente) {
        log.info("[Inicia] ClienteApplicationService - buscarClientePorId");
        Cliente cliente = clienteRepository.buscaPorId(idCliente);
        log.info("[Finaliza] ClienteApplicationService - buscarClientePorId");
        return new ClienteResponse(cliente);
    }
}
