package com.Moraski.DeliveryAPI.Entrega.domain;

import com.Moraski.DeliveryAPI.Pedido.domain.Pedido;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "entregas")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
//@ToString(exclude = "pedido")
public class Entrega {

    @Id
    @GeneratedValue
    private UUID idEntrega;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pedido", nullable = false, unique = true)
    private Pedido pedido;

    @Column(nullable = false)
    private String enderecoEntrega;

    @Column
    private LocalDateTime dataSaida;

    @Column
    private LocalDateTime dataEntrega;

    public Entrega(Pedido pedido, String enderecoEntrega) {
        this.pedido = pedido;
        this.enderecoEntrega = enderecoEntrega;
        this.dataSaida = LocalDateTime.now();
    }

    public void registrarEntrega() {
        this.dataEntrega = LocalDateTime.now();
    }
}
