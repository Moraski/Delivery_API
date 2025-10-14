package com.Moraski.DeliveryAPI.Cliente.domain;

import jakarta.persistence.*;
import lombok.*;

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
}
