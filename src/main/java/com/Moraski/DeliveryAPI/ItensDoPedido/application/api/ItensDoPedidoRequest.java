package com.Moraski.DeliveryAPI.ItensDoPedido.application.api;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.util.UUID;

@Getter
public class ItensDoPedidoRequest {

    @NotNull(message = "idItem é obrigatório")
    private final UUID idItem;

    @NotNull(message = "quantidade é obrigatória")
    @Min(value = 1, message = "quantidade deve ser no mínimo 1")
    private final Integer quantidade;

    public ItensDoPedidoRequest(UUID idItem, Integer quantidade) {
        this.idItem = idItem;
        this.quantidade = quantidade;
    }
}