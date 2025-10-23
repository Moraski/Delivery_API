package com.Moraski.DeliveryAPI.Entrega.application.api;

import jakarta.validation.constraints.NotNull;
import lombok.Value;

import java.util.UUID;

@Value
public class EntregaNovoRequest {

    @NotNull(message = "idPedido é obrigatório")
    UUID idPedido;
}
