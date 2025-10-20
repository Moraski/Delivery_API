package com.Moraski.DeliveryAPI.Item.infra;


import com.Moraski.DeliveryAPI.Item.application.repository.ItemRepository;
import com.Moraski.DeliveryAPI.Item.domain.Item;
import com.Moraski.DeliveryAPI.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@RequiredArgsConstructor
@Slf4j
public class ItemRepositoryMySQL implements ItemRepository {

    private final ItemMySQLSprinRepository itemMySQLSprinRepository;

    @Override
    public Item salva(Item item) {
        log.info("[Inicia] ItemRepositoryMySQL - salva");
        Item novoItem = itemMySQLSprinRepository.save(item);
        log.info("[finaliza] ItemRepositoryMySQL - salva");
        return novoItem;
    }

    @Override
    public Item bucaPorId(UUID idItem) {
        log.info("[Inicia] ItemRepositoryMySQL - bucaPorId");
        Item item = itemMySQLSprinRepository.findById(idItem)
                        .orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Item não encontrado"));
        log.info("[finaliza] ItemRepositoryMySQL - bucaPorId");
        return item;
    }
}
