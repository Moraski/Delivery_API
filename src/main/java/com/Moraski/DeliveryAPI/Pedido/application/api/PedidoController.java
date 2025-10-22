package com.Moraski.DeliveryAPI.Pedido.application.api;

import com.Moraski.DeliveryAPI.Pedido.application.service.PedidoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

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

    @Override
    public PedidoResponse getPedidoPorId(UUID idPedido) {
        log.info("[Inicia] PedidoController - getPedidoPorId");
        PedidoResponse response = pedidoService.buscarPedidoPorId(idPedido);
        log.info("[Finaliza] PedidoController - getPedidoPorId");
        return response;
    }

    @Override
    public List<PedidoResponse>  getPedidoPorIdCliente(UUID idCliente) {
        log.info("[Inicia] PedidoController - getPedidoPorIdCliente");
        List<PedidoResponse> response = pedidoService.buscarPedidoPorIdCliente(idCliente);
        log.info("[Finaliza] PedidoController - getPedidoPorIdCliente");
        return response;
    }

    @Override
    public PedidoResponse mudaStatusPedido(UUID idPedido, MudaStatusPedido mudaStatusPedido) {
        log.info("[Inicia] PedidoController - mudaStatusPedido");
        PedidoResponse response = pedidoService.mudaStatusPedido(idPedido, mudaStatusPedido);
        log.info("[Finaliza] PedidoController - mudaStatusPedido");
        return response;
    }
}
