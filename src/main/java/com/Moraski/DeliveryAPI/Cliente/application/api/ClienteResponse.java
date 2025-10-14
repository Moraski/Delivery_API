package com.Moraski.DeliveryAPI.Cliente.application.api;

import com.Moraski.DeliveryAPI.Cliente.domain.Cliente;
import lombok.Value;

import java.util.UUID;

@Value
public class ClienteResponse {
    UUID idCliente;
    String nome;
    String cpf;
    String email;
    String telefone;
    String endereco;

    public ClienteResponse(Cliente cliente){
        this.idCliente = cliente.getIdCliente();
        this.nome = cliente.getNome();
        this.cpf = cliente.getCpf();
        this.email = cliente.getEmail();
        this.telefone = cliente.getTelefone();
        this.endereco =  cliente.getEndereco();
    }
}
