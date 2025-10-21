package com.Moraski.DeliveryAPI.Pedido.application.api;

import com.Moraski.DeliveryAPI.ItensDoPedido.application.api.ItensDoPedidoRequest;
import com.Moraski.DeliveryAPI.Pedido.domain.StatusPedido;
import lombok.Value;

import java.util.List;
import java.util.UUID;

@Value
public class PedidoNovoRequest {

    UUID idCliente;
    String enderecoEntrega;
    StatusPedido statusPedido;
    List<ItensDoPedidoRequest> itensDoPedido;
}
