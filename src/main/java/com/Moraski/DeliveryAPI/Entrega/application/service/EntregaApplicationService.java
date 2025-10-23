package com.Moraski.DeliveryAPI.Entrega.application.service;

import com.Moraski.DeliveryAPI.Cliente.application.repository.ClienteRepository;
import com.Moraski.DeliveryAPI.Cliente.domain.Cliente;
import com.Moraski.DeliveryAPI.Entrega.application.api.EntregaNovoRequest;
import com.Moraski.DeliveryAPI.Entrega.application.api.EntregaResponse;
import com.Moraski.DeliveryAPI.Entrega.domain.Entrega;
import com.Moraski.DeliveryAPI.Entrega.application.repository.EntregaRepository;
import com.Moraski.DeliveryAPI.Pedido.application.repository.PedidoRepository;
import com.Moraski.DeliveryAPI.Pedido.domain.Pedido;
import com.Moraski.DeliveryAPI.Pedido.domain.StatusPedido;
import com.Moraski.DeliveryAPI.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class EntregaApplicationService implements EntregaService {

}
