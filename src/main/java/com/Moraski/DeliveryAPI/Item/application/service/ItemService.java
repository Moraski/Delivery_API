package com.Moraski.DeliveryAPI.Item.application.service;

import com.Moraski.DeliveryAPI.Item.application.api.ItemNovoRequest;
import com.Moraski.DeliveryAPI.Item.application.api.ItemResponse;

import java.util.UUID;

public interface ItemService {
    ItemResponse criarNovoItem(ItemNovoRequest itemNovo);
    ItemResponse buscarItemPorId(UUID idItem);
    void deletaItem(UUID idItem);
}
