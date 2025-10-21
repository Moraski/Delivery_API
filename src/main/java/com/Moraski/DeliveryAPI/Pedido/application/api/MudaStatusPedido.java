package com.Moraski.DeliveryAPI.Pedido.application.api;

import com.Moraski.DeliveryAPI.Pedido.domain.StatusPedido;
import lombok.Getter;

@Getter
public class MudaStatusPedido {
    private final StatusPedido statusPedido;

    public MudaStatusPedido(StatusPedido statusPedido){
        this.statusPedido = statusPedido;
    }
}
