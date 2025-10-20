package com.Moraski.DeliveryAPI.Item.application.api;


import com.Moraski.DeliveryAPI.Item.application.service.ItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Validated
@Log4j2
@RequiredArgsConstructor
public class ItemController implements ItemAPI{

    private  final ItemService itemservece;

    @Override
    public ItemResponse postNovoItem(ItemNovoRequest item) {
        log.info("[Inicia] ItemController - postNovoItem");
        ItemResponse response = itemservece.criarNovoItem(item);
        log.info("[Finaliza] ItemController - postNovoItem");
        return response;
    }

    @Override
    public ItemResponse getItemPorId(UUID idItem) {
        log.info("[Inicia] ItemController - getItemPorId");
        ItemResponse response = itemservece.buscarItemPorId(idItem);
        log.info("[Finaliza] ItemController - getItemPorId");
        return response;
    }
}
