package com.Moraski.DeliveryAPI.Item.application.service;

import com.Moraski.DeliveryAPI.Item.application.api.ItemNovoRequest;
import com.Moraski.DeliveryAPI.Item.application.api.ItemResponse;
import com.Moraski.DeliveryAPI.Item.application.repository.ItemRepository;
import com.Moraski.DeliveryAPI.Item.domain.Item;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ItemApplicationService implements ItemService{

    private final ItemRepository itemRepository;

    @Override
    public ItemResponse criarNovoItem(ItemNovoRequest itemNovo) {
        log.info("[Inicia] ClienteApplicationService - criaNovoCliente");
        var item = new Item(itemNovo);
        itemRepository.salva(item);
        log.info("[Finaliza] ClienteApplicationService - criaNovoCliente");
        return new ItemResponse(item);
    }
}
