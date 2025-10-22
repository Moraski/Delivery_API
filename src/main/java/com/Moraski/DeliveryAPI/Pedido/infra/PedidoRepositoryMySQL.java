package com.Moraski.DeliveryAPI.Pedido.infra;

import com.Moraski.DeliveryAPI.Pedido.application.repository.PedidoRepository;
import com.Moraski.DeliveryAPI.Pedido.domain.Pedido;
import com.Moraski.DeliveryAPI.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

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

    @Override
    public Pedido buscarPorId(UUID idPedido) {
        log.info("[Inicia] PedidoRepositoryMySQL - buscarPorId");
        Pedido pedido = pedidoMySQLSpringRepository.findById(idPedido)
                        .orElseThrow(()-> APIException.build(HttpStatus.NOT_FOUND, "Pedido não Encontrado"));
        log.info("[finaliza] PedidoRepositoryMySQL - buscarPorId");
        return pedido;
    }

    @Override
    public List<Pedido> buscarPorIdCliente(UUID idCliente) {
        log.info("[Inicia] PedidoRepositoryMySQL - buscaPorIdCliente");
        List<Pedido> pedidos = pedidoMySQLSpringRepository.buscaPorIdCliente(idCliente);


        if (pedidos.isEmpty()) {
            log.warn("Nenhum pedido encontrado para o cliente: {}", idCliente);
        }

        log.info("[finaliza] PedidoRepositoryMySQL - buscaPorIdCliente");
        return pedidos;
    }
}
