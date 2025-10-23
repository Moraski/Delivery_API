package com.Moraski.DeliveryAPI.Pedido.application.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "Pedido", description = "Endpoints de gestão de pedidos")
@RequestMapping(value = "/public/v1/pedido")
public interface PedidoAPI {

    @Operation(summary = "Cria um novo pedido")
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    PedidoResponse postNovoPedido(@RequestBody @Valid PedidoNovoRequest pedidoNovo);

    @Operation(summary = "Busca um pedido por ID")
    @GetMapping("/{idPedido}")
    @ResponseStatus(code = HttpStatus.OK)
    PedidoResponse getPedidoPorId(@PathVariable UUID idPedido);

    @Operation(summary = "Busca todos os pedidos de um cliente")
    @GetMapping("/cliente/{idCliente}")
    @ResponseStatus(code = HttpStatus.OK)
    List<PedidoResponse> getPedidoPorIdCliente(@PathVariable UUID idCliente);

    @Operation(summary = "Muda o status do pedido")
    @PutMapping("/status/{idPedido}")
    @ResponseStatus(code = HttpStatus.OK)
    PedidoResponse mudaStatusPedido(@PathVariable UUID idPedido, @RequestBody @Valid MudaStatusPedido mudaStatusPedido);
}
