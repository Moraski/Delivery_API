package com.Moraski.DeliveryAPI.Cliente.application.api;

import com.Moraski.DeliveryAPI.Cliente.domain.Cliente;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class EditaClienteRequest {

    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private String endereco;

    public EditaClienteRequest(Cliente cliente){
        this.nome = cliente.getNome();
        this.cpf = cliente.getCpf();
        this.email = cliente.getEmail();
        this.telefone = cliente.getTelefone();
        this.endereco = cliente.getEndereco();
    }
}
