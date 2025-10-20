package com.Moraski.DeliveryAPI.Item.application.service;

import com.Moraski.DeliveryAPI.Item.application.api.EditaItemRequest;
import com.Moraski.DeliveryAPI.Item.application.api.ItemNovoRequest;
import com.Moraski.DeliveryAPI.Item.application.api.ItemResponse;
import com.Moraski.DeliveryAPI.Item.application.repository.ItemRepository;
import com.Moraski.DeliveryAPI.Item.domain.Item;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

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

    @Override
    public ItemResponse buscarItemPorId(UUID idItem) {
        log.info("[Inicia] ClienteApplicationService - buscarItemPorId");
        Item item = itemRepository.bucaPorId(idItem);
        log.info("[Finaliza] ClienteApplicationService - buscarItemPorId");
        return new ItemResponse(item);
    }
    @Override
    public ItemResponse editaItem(UUID idItem, EditaItemRequest itemEditado) {
        log.info("[Inicia] ClienteApplicationService - editaItem");
        Item item = itemRepository.bucaPorId(idItem);
        item.editaItem(itemEditado);
        itemRepository.salva(item);
        log.info("[Finaliza] ClienteApplicationService - editaItem");
        return new ItemResponse(item);
    }

    @Override
    public void deletaItem(UUID idItem) {
        log.info("[Inicia] ClienteApplicationService - deletaItem");
        itemRepository.delete(idItem);
        log.info("[Finaliza] ClienteApplicationService - deletaItem");
    }
}
