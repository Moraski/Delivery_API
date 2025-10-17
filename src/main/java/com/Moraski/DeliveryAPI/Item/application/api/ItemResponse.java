package com.Moraski.DeliveryAPI.Item.application.api;

import com.Moraski.DeliveryAPI.Item.domain.Item;
import lombok.Value;

import java.util.UUID;

@Value
public class ItemResponse {

    UUID idItem;
    String produto;
    Double valorUniterio;
    String descricao;

    public ItemResponse(Item item){
        this.idItem = item.getIdItem();
        this.produto = item.getProduto();
        this.valorUniterio = item.getValorUnitario();
        this.descricao = item.getDescrição();
    }
}
