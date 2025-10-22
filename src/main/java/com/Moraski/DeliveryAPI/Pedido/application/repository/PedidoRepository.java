package com.Moraski.DeliveryAPI.Pedido.application.repository;

import com.Moraski.DeliveryAPI.Pedido.domain.Pedido;

public interface PedidoRepository {
    Pedido salva(Pedido pedido);
}
