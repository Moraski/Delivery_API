package com.Moraski.DeliveryAPI.ItensDoPedido.domain;


import com.Moraski.DeliveryAPI.Item.domain.Item;
import com.Moraski.DeliveryAPI.Pedido.domain.Pedido;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "pedido_itens")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ItensDoPedido {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pedido", nullable = false)
    private Pedido pedido;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_item", nullable = false)
    private Item item;

    @Column(nullable = false)
    private Integer quantidade;

    public Double getSubtotal() {
        return item.getValorUnitario() + quantidade;
    }
}
