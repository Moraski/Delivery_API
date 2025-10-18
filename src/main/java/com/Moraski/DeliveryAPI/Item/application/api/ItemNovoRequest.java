package com.Moraski.DeliveryAPI.Item.application.api;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Value;

import java.util.UUID;

@Value
public class ItemNovoRequest {

    UUID idItem;

    @NotBlank(message = "produto é obrigatório")
    @Size(max = 100, message = "produto não pode ultrapassar 100 caracteres")
    String produto;

    @NotNull(message = "valorUnitario é obrigatório")
    Double valorUnitario;

    @NotBlank(message = "descricao é obrigatório")
    @Size(max = 100, message = "descricao não pode ultrapassar 100 caracteres")
    String descricao;
}
