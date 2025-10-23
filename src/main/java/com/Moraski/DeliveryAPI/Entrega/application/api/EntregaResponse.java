package com.Moraski.DeliveryAPI.Entrega.application.api;

import com.Moraski.DeliveryAPI.Entrega.domain.Entrega;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public class EntregaResponse {

    private UUID idEntrega;
    private UUID idPedido;
    private String enderecoEntrega;
    private LocalDateTime dataSaida;
    private LocalDateTime dataEntrega;

    public EntregaResponse(Entrega entrega) {
        this.idEntrega = entrega.getIdEntrega();
        this.idPedido = entrega.getPedido().getIdPedido();
        this.enderecoEntrega = entrega.getEnderecoEntrega();
        this.dataSaida = entrega.getDataSaida();
        this.dataEntrega = entrega.getDataEntrega();
    }
}
