package com.Moraski.DeliveryAPI.Pedido.application.service;

import com.Moraski.DeliveryAPI.Item.application.repository.ItemRepository;
import com.Moraski.DeliveryAPI.ItensDoPedido.domain.ItensDoPedido;
import com.Moraski.DeliveryAPI.Pedido.application.api.PedidoNovoRequest;
import com.Moraski.DeliveryAPI.Pedido.application.api.PedidoResponse;
import com.Moraski.DeliveryAPI.Pedido.application.repository.PedidoRepository;
import com.Moraski.DeliveryAPI.Pedido.domain.Pedido;
import com.Moraski.DeliveryAPI.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class PedidoApplicationService implements PedidoService{

    private final PedidoRepository pedidoRepository;
    private final ItemRepository itemRepository;

    @Override
    public PedidoResponse criarNovoPedido(PedidoNovoRequest request) {
        log.info("[Inicia] PedidoApplicationService - criarNovoPedido");

        var itens = montaItensDoPedido(request);
        var pedido = new Pedido(request, itens);
        pedidoRepository.salva(pedido);
        log.info("[Finaliza] PedidoApplicationService - criarNovoPedido");
        return new PedidoResponse(pedido);
    }


    private List<ItensDoPedido> montaItensDoPedido(PedidoNovoRequest pedidoNovo) {
        if (pedidoNovo.getItensDoPedido() == null || pedidoNovo.getItensDoPedido().isEmpty()) {
            throw APIException.build(HttpStatus.BAD_REQUEST, "O pedido deve conter pelo menos um item");
        }

        return pedidoNovo.getItensDoPedido().stream()
                .map(i -> {
                    var item = itemRepository.bucaPorId(i.getIdItem());
                    if (item == null) {
                        throw APIException.build(HttpStatus.NOT_FOUND, "Item não encontrado: " + i.getIdItem());
                    }
                    return ItensDoPedido.builder()
                            .item(item)
                            .quantidade(i.getQuantidade())
                            .build();
                })
                .collect(Collectors.toList());
    }

}
