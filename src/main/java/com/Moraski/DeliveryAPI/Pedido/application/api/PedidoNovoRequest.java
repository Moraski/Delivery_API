package com.Moraski.DeliveryAPI.Pedido.application.api;

import com.Moraski.DeliveryAPI.ItensDoPedido.application.api.ItensDoPedidoRequest;
import com.Moraski.DeliveryAPI.Pedido.domain.StatusPedido;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Value;

import java.util.List;
import java.util.UUID;

@Value
public class PedidoNovoRequest {

    @NotNull(message = "idCliente é obrigatório")
    UUID idCliente;

    @NotBlank(message = "Endereço de entrega é obrigatório")
    @Size(max = 100, message = "Endereço de entrega não pode ultrapassar 100 caracteres")
    String enderecoEntrega;

    @NotNull(message = "O status do pedido é obrigatório")
    StatusPedido statusPedido;

    @Valid
    @NotEmpty(message = "O pedido deve conter pelo menos um item")
    List<ItensDoPedidoRequest> itensDoPedido;
}
