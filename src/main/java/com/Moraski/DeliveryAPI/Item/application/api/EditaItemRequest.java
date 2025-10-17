package com.Moraski.DeliveryAPI.Item.application.api;

import com.Moraski.DeliveryAPI.Item.domain.Item;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class EditaItemRequest {

    String produto;
    Double valorUnitario;
    String descricao;

    public EditaItemRequest(Item item){
        this.produto = item.getProduto();
        this.valorUnitario = item.getValorUnitario();
        this.descricao = item.getDescrição();
    }
}
