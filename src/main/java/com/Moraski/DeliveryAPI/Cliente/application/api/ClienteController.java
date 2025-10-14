package com.Moraski.DeliveryAPI.Cliente.application.api;

import com.Moraski.DeliveryAPI.Cliente.application.service.ClienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Validated
@Log4j2
@RequiredArgsConstructor
public class ClienteController implements ClienteAPI{

    private final ClienteService clienteService;

    @Override
    public ClienteResponse postNovoCliente(ClienteNovoRequest cliente) {
        log.info("[Inicia] ClienteController - postNovoCliente");
        ClienteResponse clienteResponse = clienteService.criarNovoCliente(cliente);
        log.info("[Finaliza] ClienteController - postNovoCliente");
        return clienteResponse;
    }

    @Override
    public ClienteResponse getClientePorId(UUID idCliente) {
        log.info("[Inicia] ClienteController - getClientePorId");
        ClienteResponse clienteResponse = clienteService.buscarClientePorId(idCliente);
        log.info("[Finaliza] ClienteController - getClientePorId");
        return clienteResponse;
    }
}
