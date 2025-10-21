package com.Moraski.DeliveryAPI.Pedido.domain;

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

    public Double getTotal(){
        return itensDoPedido.stream()
                .mapToDouble(ItensDoPedido::getSubtotal)
                .sum();
    }

    public Pedido(PedidoNovoRequest request, ItemRepository itemRepository){

        this.idCliente = request.getIdCliente();
        this.dataCriacao = LocalDateTime.now();
        this.statusPedido = request.getStatusPedido();

        if (request.getItensDoPedido() != null){
            this.itensDoPedido = request.getItensDoPedido().stream()
                    .map( i -> {
                        Item item = itemRepository.bucaPorId(i.getIdItem());
                        if (item == null){
                            throw APIException.build(HttpStatus.NOT_FOUND, "Item especificado não foi encontrado");
                        }
                        return ItensDoPedido.builder()
                                .item(item)
                                .quantidade(i.getQuantidade())
                                .pedido(this)
                                .build();
                    })
                    .collect(Collectors.toList());
        }
    }

    public void editaPedido(StatusPedido statusPedido){
        if (statusPedido == null){
            throw APIException.build(HttpStatus.BAD_REQUEST, "Status do pedido não pode estar vazio");
        }
        this.statusPedido = statusPedido;
    }
}
