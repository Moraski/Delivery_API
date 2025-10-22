package com.Moraski.DeliveryAPI.Item.domain;

import com.Moraski.DeliveryAPI.Item.application.api.EditaItemRequest;
import com.Moraski.DeliveryAPI.Item.application.api.ItemNovoRequest;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "itens")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Item {
    @Id
    @GeneratedValue
    private UUID idItem;

    @Column(nullable = false)
    private String produto;

    @Column(nullable = false)
    private Double valorUnitario;

    @Column(nullable = false)
    private String descrição;


    public Item(@Valid ItemNovoRequest itemNovo){
        this.idItem = itemNovo.getIdItem();
        this.produto = itemNovo.getProduto();
        this.valorUnitario = itemNovo.getValorUnitario();
        this.descrição = itemNovo.getDescricao();
    }

    public void editaItem(EditaItemRequest editaItem){
        this.produto = editaItem.getProduto();
        this.valorUnitario = editaItem.getValorUnitario();
        this.descrição = editaItem.getDescricao();
    }
}
