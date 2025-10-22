package com.Moraski.DeliveryAPI.Pedido.infra;

import com.Moraski.DeliveryAPI.Pedido.application.repository.PedidoRepository;
import com.Moraski.DeliveryAPI.Pedido.domain.Pedido;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Slf4j
public class PedidoRepositoryMySQL implements PedidoRepository {

    private final PedidoMySQLSpringRepository pedidoMySQLSpringRepository;

    @Override
    public Pedido salva(Pedido pedido) {
        log.info("[Inicia] PedidoRepositoryMySQL - salva");
        Pedido novoPedido = pedidoMySQLSpringRepository.save(pedido);
        log.info("[finaliza] PedidoRepositoryMySQL - salva");
        return novoPedido;
    }
}
