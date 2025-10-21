package com.Moraski.DeliveryAPI.Pedido.application.api;

import jakarta.validation.Valid;
import lombok.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@RequestMapping(value = "/public/v1/pedido")
public interface PedidoAPI {

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    PedidoResponse postNovoPedido(@RequestBody @Valid PedidoNovoRequest pedidoNovo);

}
