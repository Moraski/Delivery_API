package com.Moraski.DeliveryAPI.Entrega.application.api;

import com.Moraski.DeliveryAPI.Entrega.application.api.EntregaAPI;

import com.Moraski.DeliveryAPI.Entrega.application.service.EntregaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;


@RestController
@Validated
@Slf4j
@RequiredArgsConstructor
public class EntregaController implements EntregaAPI {

    private final EntregaService entregaService;

    @Override
    public EntregaResponse postNovaEntrega(EntregaNovoRequest novaEntrega) {
        log.info("[Inicia] EntregaController - postNovaEntrega");
        EntregaResponse response = entregaService.criarEntrega(novaEntrega);
        log.info("[Finaliza] EntregaController - postNovaEntrega");
        return response;
    }

    @Override
    public EntregaResponse getEntrega(UUID idEntrega) {
        log.info("[Inicia] EntregaController - GetEntrega");
        EntregaResponse response = entregaService.buscarPorId(idEntrega);
        log.info("[Finaliza] EntregaController - GetEntrega");
        return response;
    }

    @Override
    public EntregaResponse finalizaEntrega(UUID idEntrega) {
        log.info("[Inicia] EntregaController - finalizaEntrega");
        EntregaResponse response = entregaService.finalizaEntrega(idEntrega);
        log.info("[Finaliza] EntregaController - finalizaEntrega");
        return response;
    }
}
