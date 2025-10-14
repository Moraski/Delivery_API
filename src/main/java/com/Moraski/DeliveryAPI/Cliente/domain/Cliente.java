package com.Moraski.DeliveryAPI.Cliente.domain;

import com.Moraski.DeliveryAPI.Cliente.application.api.ClienteNovoRequest;
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

    @Column
    private String nome;

    @Column
    private String cpf;

    @Column
    private String email;

    @Column
    private String telefone;

    @Column
    private String endereco;

    public Cliente(@Valid ClienteNovoRequest clienteNovo) {
        this.idCliente = clienteNovo.getIdCliente();
        this.nome = clienteNovo.getNome();
        this.cpf = clienteNovo.getCpf();
        this.email = clienteNovo.getEmail();
        this.telefone = clienteNovo.getTelefone();
        this.endereco = clienteNovo.getEndereco();
    }

    public void editaCliente(String nome, String cpf, String email, String telefone, String endereco){
        if (nome == null || nome.isBlank()){
            throw APIException.build(HttpStatus.BAD_REQUEST, "Nome não pode estar vazio");
        }
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
    }
}
