package com.Moraski.DeliveryAPI.Pedido.infra;

import com.Moraski.DeliveryAPI.Pedido.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PedidoMySQLSpringRepository extends JpaRepository<Pedido, UUID> {

    @Query("SELECT p FROM Pedido p LEFT JOIN FETCH p.itensDoPedido WHERE p.idCliente = :idCliente")
    List<Pedido> buscaPorIdCliente(@Param("idCliente") UUID idCliente);




}
