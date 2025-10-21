package com.Moraski.DeliveryAPI.Pedido.application.api;

import com.Moraski.DeliveryAPI.Pedido.application.service.PedidoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@Log4j2
@RequiredArgsConstructor
public class PedidoController implements PedidoAPI {

    private final PedidoService pedidoService;

    @Override
    public PedidoResponse postNovoPedido(PedidoNovoRequest pedidoNovo) {
        log.info("[Inicia] PedidoController - postNovoPedido");
        PedidoResponse response = pedidoService.criarNovoPedido(pedidoNovo);
        log.info("[Finaliza] PedidoController - postNovoPedido");
        return response;
    }
}
