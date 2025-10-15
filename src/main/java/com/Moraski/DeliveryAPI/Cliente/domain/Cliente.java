package com.Moraski.DeliveryAPI.Cliente.domain;

import com.Moraski.DeliveryAPI.Cliente.application.api.ClienteNovoRequest;
import com.Moraski.DeliveryAPI.Cliente.application.api.EditaClienteRequest;
import com.Moraski.DeliveryAPI.handler.APIException;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;
import org.springframework.http.HttpStatus;

import java.util.UUID;

@Entity
@Table(name = "clientes")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Cliente {

    @Id
    @GeneratedValue
    private UUID idCliente;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String cpf;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String telefone;

    @Column(nullable = false)
    private String endereco;

    public Cliente(@Valid ClienteNovoRequest clienteNovo) {
        this.idCliente = clienteNovo.getIdCliente();
        this.nome = clienteNovo.getNome();
        this.cpf = clienteNovo.getCpf();
        this.email = clienteNovo.getEmail();
        this.telefone = clienteNovo.getTelefone();
        this.endereco = clienteNovo.getEndereco();
    }

    public void editaCliente(EditaClienteRequest editaClienteRequest){
        this.nome = editaClienteRequest.getNome();
        this.cpf = editaClienteRequest.getCpf();
        this.email = editaClienteRequest.getEmail();
        this.telefone = editaClienteRequest.getTelefone();
        this.endereco = editaClienteRequest.getEndereco();
    }
}
