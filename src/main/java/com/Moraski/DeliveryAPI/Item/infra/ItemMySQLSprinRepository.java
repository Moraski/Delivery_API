package com.Moraski.DeliveryAPI.Item.infra;

import com.Moraski.DeliveryAPI.Item.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ItemMySQLSprinRepository extends JpaRepository<Item, UUID> {
}
