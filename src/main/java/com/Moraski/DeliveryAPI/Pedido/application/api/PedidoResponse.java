package com.Moraski.DeliveryAPI.Pedido.application.api;

import com.Moraski.DeliveryAPI.ItensDoPedido.application.api.ItensDoPedidoResponse;
import com.Moraski.DeliveryAPI.ItensDoPedido.domain.ItensDoPedido;
import com.Moraski.DeliveryAPI.Pedido.domain.Pedido;
import com.Moraski.DeliveryAPI.Pedido.domain.StatusPedido;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Getter
public class PedidoResponse {

    private final UUID idPedido;
    private final UUID idCliente;
    private final LocalDateTime dataCriacao;
    private final StatusPedido statusPedido;
    private final Double total;
    private final List<ItensDoPedidoResponse> itens;

    public PedidoResponse(Pedido pedido){
        this.idPedido = pedido.getIdPedido();
        this.idCliente = pedido.getIdCliente();
        this.dataCriacao = pedido.getDataCriacao();
        this.statusPedido = pedido.getStatusPedido();
        this.total = pedido.getTotal();
        this.itens = pedido.getItensDoPedido().stream()
                .map(ItensDoPedidoResponse::new)
                .collect(Collectors.toList());
    }
}
