package com.Moraski.DeliveryAPI.Cliente.application.api;

import lombok.Value;

import java.util.UUID;

@Value
public class ClienteNovoRequest {

    UUID idCliente;
    String nome;
    String cpf;
    String email;
    String telefone;
    String endereco;
}
