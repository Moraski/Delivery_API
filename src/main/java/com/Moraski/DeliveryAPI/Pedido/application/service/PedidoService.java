package com.Moraski.DeliveryAPI.Pedido.application.service;

import com.Moraski.DeliveryAPI.Pedido.application.api.PedidoNovoRequest;
import com.Moraski.DeliveryAPI.Pedido.application.api.PedidoResponse;

public interface PedidoService {
    PedidoResponse criarNovoPedido(PedidoNovoRequest request);
}
