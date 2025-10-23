package com.Moraski.DeliveryAPI.Pedido.domain;

import com.Moraski.DeliveryAPI.Entrega.domain.Entrega;
import com.Moraski.DeliveryAPI.Item.application.repository.ItemRepository;
import com.Moraski.DeliveryAPI.Item.domain.Item;
import com.Moraski.DeliveryAPI.ItensDoPedido.domain.ItensDoPedido;
import com.Moraski.DeliveryAPI.Pedido.application.api.PedidoNovoRequest;
import com.Moraski.DeliveryAPI.handler.APIException;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Entity
@Table(name = "pedidos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Pedido {

    @Id
    @GeneratedValue
    private UUID idPedido;

    @Column(nullable = false)
    private UUID idCliente;

    @Column(nullable = false)
    private StatusPedido statusPedido;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItensDoPedido> itensDoPedido = new ArrayList<>();

    @Column(nullable = false)
    private LocalDateTime dataCriacao;

    @OneToOne(mappedBy = "pedido")
    private Entrega entrega;

    public Pedido(PedidoNovoRequest request, List<ItensDoPedido> itensDoPedido) {
        this.idCliente = request.getIdCliente();
        this.dataCriacao = LocalDateTime.now();
        this.statusPedido = request.getStatusPedido();
        this.itensDoPedido = itensDoPedido.stream()
                .map(i -> new ItensDoPedido(i.getItem(), i.getQuantidade(), this))
                .toList();
    }
    public void editaPedido(StatusPedido statusPedido){
        if (statusPedido == null){
            throw APIException.build(HttpStatus.BAD_REQUEST, "Status do pedido não pode estar vazio");
        }
        this.statusPedido = statusPedido;
    }
    public Double getTotal(){
        return itensDoPedido.stream()
                .mapToDouble(ItensDoPedido::getSubtotal)
                .sum();
    }

    public void vincularEntrega(Entrega entrega) {
        this.entrega = entrega;
    }

}
