package com.Moraski.DeliveryAPI.Pedido.application.repository;

import com.Moraski.DeliveryAPI.Pedido.domain.Pedido;

import java.util.UUID;

public interface PedidoRepository {
    Pedido salva(Pedido pedido);
    Pedido buscarPorId(UUID idPedido);
}
