package com.Moraski.DeliveryAPI.Entrega.application.repository;

import com.Moraski.DeliveryAPI.Entrega.domain.Entrega;

import java.util.UUID;

public interface EntregaRepository {
    Entrega salva(Entrega entrega);
    Entrega buscarPorId(UUID idEntrega);
}
