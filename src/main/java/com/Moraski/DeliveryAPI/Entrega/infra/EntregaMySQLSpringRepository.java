package com.Moraski.DeliveryAPI.Entrega.infra;

import com.Moraski.DeliveryAPI.Entrega.domain.Entrega;
import com.Moraski.DeliveryAPI.Pedido.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface EntregaMySQLSpringRepository extends JpaRepository<Entrega, UUID> {
}
