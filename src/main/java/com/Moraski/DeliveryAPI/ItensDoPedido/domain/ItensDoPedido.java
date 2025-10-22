package com.Moraski.DeliveryAPI.ItensDoPedido.domain;


import com.Moraski.DeliveryAPI.Item.domain.Item;
import com.Moraski.DeliveryAPI.Pedido.domain.Pedido;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "pedido_itens")
@Getter
@AllArgsConstructor
@Builder
@ToString
public class ItensDoPedido {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pedido", nullable = false)
    private final Pedido pedido;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_item", nullable = false)
    private final Item item;

    @Column(nullable = false)
    private final Integer quantidade;

    @Column(nullable = false)
    private final Double subtotal;

    // Construtor principal
    public ItensDoPedido(Item item, Integer quantidade, Pedido pedido) {
        if (item == null || quantidade == null || pedido == null) {
            throw new IllegalArgumentException("Item, quantidade e pedido não podem ser nulos");
        }
        this.item = item;
        this.quantidade = quantidade;
        this.pedido = pedido;
        this.subtotal = item.getValorUnitario() * quantidade;
    }

    public Double getSubtotal() {
        return subtotal;
    }
}
