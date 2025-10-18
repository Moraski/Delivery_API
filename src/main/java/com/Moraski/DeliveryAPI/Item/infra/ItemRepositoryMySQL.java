package com.Moraski.DeliveryAPI.Item.infra;


import com.Moraski.DeliveryAPI.Item.application.repository.ItemRepository;
import com.Moraski.DeliveryAPI.Item.domain.Item;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

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
}
