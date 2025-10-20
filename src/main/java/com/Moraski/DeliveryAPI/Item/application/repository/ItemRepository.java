package com.Moraski.DeliveryAPI.Item.application.repository;

import com.Moraski.DeliveryAPI.Item.domain.Item;

import java.util.UUID;

public interface ItemRepository {
    Item salva(Item item);
    Item bucaPorId(UUID idItem);
    void delete(UUID idItem);
}
