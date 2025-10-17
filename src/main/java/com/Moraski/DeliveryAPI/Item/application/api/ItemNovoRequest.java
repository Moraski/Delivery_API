package com.Moraski.DeliveryAPI.Item.application.api;

import lombok.Value;

import java.util.UUID;

@Value
public class ItemNovoRequest {

    UUID idItem;
    String produto;
    Double valorUniterio;
    String descricao;
}
