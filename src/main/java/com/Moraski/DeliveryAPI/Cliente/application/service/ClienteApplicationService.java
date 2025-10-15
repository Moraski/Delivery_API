package com.Moraski.DeliveryAPI.Cliente.application.service;

import com.Moraski.DeliveryAPI.Cliente.application.api.ClienteNovoRequest;
import com.Moraski.DeliveryAPI.Cliente.application.api.ClienteResponse;
import com.Moraski.DeliveryAPI.Cliente.application.api.EditaClienteRequest;
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

        clienteRepository.buscaPorEmail(clienteNovo.getEmail())
                .ifPresent(c -> {
                    throw APIException.build(HttpStatus.CONFLICT, "Já existe um cliente com este e-mail.");
                });

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

    @Override
    public ClienteResponse editaCliente(UUID idCliente, EditaClienteRequest editaClienteRequest) {
        log.info("[Inicia] ClienteApplicationService - editaCliente");

        Cliente cliente = clienteRepository.buscaPorId(idCliente);
        clienteRepository.buscaPorEmail(editaClienteRequest.getEmail())
                .filter(c -> !c.getIdCliente().equals(cliente.getIdCliente()))
                .ifPresent(c -> {
                    throw APIException.build(HttpStatus.CONFLICT, "Já existe um cliente com este e-mail.");
                });
        cliente.editaCliente(editaClienteRequest);
        clienteRepository.salva(cliente);
        log.info("[Finaliza] ClienteApplicationService - editaCliente");
        return new ClienteResponse(cliente);
    }

    @Override
    public void deletaCliente(UUID idCliente) {
        log.info("[Inicia] ClienteApplicationService - deletaCliente");
        clienteRepository.deletaCliente(idCliente);
        log.info("[Finaliza] ClienteApplicationService - deletaCliente");
    }
}
