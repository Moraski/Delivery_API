package com.Moraski.DeliveryAPI.ItensDoPedido.application.api;

import com.Moraski.DeliveryAPI.ItensDoPedido.domain.ItensDoPedido;
import lombok.Getter;

import java.util.UUID;

@Getter
public class ItensDoPedidoResponse {

    private final UUID idItem;

    private final String produto;

    private final Integer quantidade;

    private final Double valorUnitario;

    private final Double subtotal;

    public ItensDoPedidoResponse(ItensDoPedido itensDoPedido){
        this.idItem = itensDoPedido.getItem().getIdItem();
        this.produto = itensDoPedido.getItem().getProduto();
        this.quantidade = itensDoPedido.getQuantidade();
        this.valorUnitario = itensDoPedido.getItem().getValorUnitario();
        this.subtotal = itensDoPedido.getSubtotal();
    }
}
