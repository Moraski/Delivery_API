package com.Moraski.DeliveryAPI.Pedido.application.api;

import jakarta.validation.Valid;
import lombok.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping(value = "/public/v1/pedido")
public interface PedidoAPI {

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    PedidoResponse postNovoPedido(@RequestBody @Valid PedidoNovoRequest pedidoNovo);

    @GetMapping("/{idPedido}")
    @ResponseStatus(code = HttpStatus.OK)
    PedidoResponse getPedidoPorId(@PathVariable UUID idPedido);

    @GetMapping("/cliente/{idCliente}")
    @ResponseStatus(code = HttpStatus.OK)
    List<PedidoResponse> getPedidoPorIdCliente(@PathVariable UUID idCliente);
}
