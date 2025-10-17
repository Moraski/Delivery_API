package com.Moraski.DeliveryAPI.Item.application.api;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Value;

import java.util.UUID;

@Value
public class ItemNovoRequest {

    UUID idItem;

    @NotBlank(message = "Nome é obrigatório")
    @Size(max = 100, message = "Nome não pode ultrapassar 100 caracteres")
    String produto;

    @NotBlank(message = "Nome é obrigatório")
    @Size(max = 100, message = "Nome não pode ultrapassar 100 caracteres")
    Double valorUniterio;

    @NotBlank(message = "Nome é obrigatório")
    @Size(max = 100, message = "Nome não pode ultrapassar 100 caracteres")
    String descricao;
}
