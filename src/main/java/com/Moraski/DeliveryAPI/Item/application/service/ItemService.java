package com.Moraski.DeliveryAPI.Item.application.service;

import com.Moraski.DeliveryAPI.Item.application.api.EditaItemRequest;
import com.Moraski.DeliveryAPI.Item.application.api.ItemNovoRequest;
import com.Moraski.DeliveryAPI.Item.application.api.ItemResponse;
import com.Moraski.DeliveryAPI.Item.domain.Item;

import java.util.UUID;

public interface ItemService {
    ItemResponse criarNovoItem(ItemNovoRequest itemNovo);
    ItemResponse buscarItemPorId(UUID idItem);
    ItemResponse editaItem(UUID idItem, EditaItemRequest itemEditado);
    void deletaItem(UUID idItem);
}
