package com.Moraski.DeliveryAPI.Item.application.service;

import com.Moraski.DeliveryAPI.Item.application.api.ItemNovoRequest;
import com.Moraski.DeliveryAPI.Item.application.api.ItemResponse;

public interface ItemService {
    ItemResponse criarNovoItem(ItemNovoRequest itemNovo);
}
