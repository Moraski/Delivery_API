package com.Moraski.DeliveryAPI.Item.infra;


import com.Moraski.DeliveryAPI.Item.application.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Slf4j
public class ItemRepositoryMySQL implements ItemRepository {
}
