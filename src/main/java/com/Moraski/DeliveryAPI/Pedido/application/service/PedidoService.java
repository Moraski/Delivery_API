package com.Moraski.DeliveryAPI.Pedido.application.service;

import com.Moraski.DeliveryAPI.Pedido.application.api.MudaStatusPedido;
import com.Moraski.DeliveryAPI.Pedido.application.api.PedidoNovoRequest;
import com.Moraski.DeliveryAPI.Pedido.application.api.PedidoResponse;

import java.util.List;
import java.util.UUID;

public interface PedidoService {
    PedidoResponse criarNovoPedido(PedidoNovoRequest request);
    PedidoResponse buscarPedidoPorId(UUID idPedido);
    List<PedidoResponse> buscarPedidoPorIdCliente(UUID idCliente);
    PedidoResponse mudaStatusPedido(UUID idPedido, MudaStatusPedido mudaStatusPedido);
}
