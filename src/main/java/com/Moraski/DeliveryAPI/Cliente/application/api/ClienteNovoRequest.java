package com.Moraski.DeliveryAPI.Cliente.application.api;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Value;

import java.util.UUID;

@Value
public class ClienteNovoRequest {

    UUID idCliente;

    @NotBlank(message = "Nome é obrigatório")
    @Size(max = 100, message = "Nome não pode ultrapassar 100 caracteres")
    String nome;

    @NotBlank(message = "CPF é obrigatório")
    @Size(min = 11, max = 14, message = "CPF deve ter entre 11 e 14 caracteres")
    String cpf;

    @NotBlank(message = "Email é obrigatório")
    @Email(message = "Formato de email inválido")
    String email;

    @NotBlank(message = "Telefone é obrigatório")
    @Size(max = 20, message = "Telefone não pode ultrapassar 20 caracteres")
    String telefone;

    @NotBlank(message = "Endereço é obrigatório")
    @Size(max = 255, message = "Endereço não pode ultrapassar 255 caracteres")
    String endereco;
}
