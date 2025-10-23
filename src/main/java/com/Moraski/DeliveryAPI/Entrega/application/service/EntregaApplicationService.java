package com.Moraski.DeliveryAPI.Entrega.application.service;

import com.Moraski.DeliveryAPI.Cliente.application.repository.ClienteRepository;
import com.Moraski.DeliveryAPI.Cliente.domain.Cliente;
import com.Moraski.DeliveryAPI.Entrega.application.api.EntregaNovoRequest;
import com.Moraski.DeliveryAPI.Entrega.application.api.EntregaResponse;
import com.Moraski.DeliveryAPI.Entrega.domain.Entrega;
import com.Moraski.DeliveryAPI.Entrega.application.repository.EntregaRepository;
import com.Moraski.DeliveryAPI.Pedido.application.repository.PedidoRepository;
import com.Moraski.DeliveryAPI.Pedido.domain.Pedido;
import com.Moraski.DeliveryAPI.Pedido.domain.StatusPedido;
import com.Moraski.DeliveryAPI.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class EntregaApplicationService implements EntregaService {

    private final EntregaRepository entregaRepository;
    private final PedidoRepository pedidoRepository;
    private final ClienteRepository clienteRepository;

    @Override
    public EntregaResponse criarEntrega(EntregaNovoRequest novaEntrega) {
        log.info("[Inicia] EntregaApplicationService - criarEntrega");

        Pedido pedido = pedidoRepository.buscarPorId(novaEntrega.getIdPedido());
        if (pedido == null){
            throw APIException.build(HttpStatus.NOT_FOUND, "Pedido Não encontrado");
        }
        if (pedido.getEntrega() != null){

            throw APIException.build(HttpStatus.BAD_REQUEST, "Entrega já criada para esse pedido");
        }

        Cliente cliente = clienteRepository.buscaPorId(pedido.getIdCliente());
        String enderecoEntrega = cliente.getEndereco();

        Entrega entrega = new Entrega(pedido, enderecoEntrega);
        pedido.vincularEntrega(entrega);
        pedido.editaPedido(StatusPedido.EM_ENTREGA);

        entregaRepository.salva(entrega);

        log.info("[Finaliza] EntregaApplicationService - criarEntrega");
        return new EntregaResponse(entrega);
    }

    @Override
    public EntregaResponse buscarPorId(UUID idEntrega) {
        log.info("[Inicia] EntregaApplicationService - buscarPorId");
        Entrega entrega = entregaRepository.buscarPorId(idEntrega);
        log.info("[Finaliza] EntregaApplicationService - buscarPorId");
        return new EntregaResponse(entrega);
    }

    @Override
    public EntregaResponse finalizaEntrega(UUID idEntrega) {
        log.info("[Inicia] EntregaApplicationService - registrarEntrega");
        Entrega entrega = entregaRepository.buscarPorId(idEntrega);

        Pedido pedido = entrega.getPedido();
        pedido.editaPedido(StatusPedido.ENTREGUE);

        entrega.registrarEntrega();
        entregaRepository.salva(entrega);
        log.info("[Finaliza] EntregaApplicationService - registrarEntrega");
        return null;
    }
}
