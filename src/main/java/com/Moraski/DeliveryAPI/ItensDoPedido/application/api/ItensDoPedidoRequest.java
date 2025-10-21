package com.Moraski.DeliveryAPI.ItensDoPedido.application.api;

import lombok.Getter;

import java.util.UUID;

@Getter
public class ItensDoPedidoRequest {
    private final UUID idItem;
    private final Integer quantidade;

    public ItensDoPedidoRequest(UUID idItem, Integer quantidade) {
        this.idItem = idItem;
        this.quantidade = quantidade;
    }
}