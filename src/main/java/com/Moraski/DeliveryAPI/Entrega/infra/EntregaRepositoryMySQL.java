package com.Moraski.DeliveryAPI.Entrega.infra;

import com.Moraski.DeliveryAPI.Entrega.application.repository.EntregaRepository;
import com.Moraski.DeliveryAPI.Entrega.domain.Entrega;
import com.Moraski.DeliveryAPI.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
@Slf4j
public class EntregaRepositoryMySQL implements EntregaRepository {

    private final EntregaMySQLSpringRepository entregaMySQLSpringRepository;

    @Override
    public Entrega salva(Entrega entrega) {
        log.info("[Inicia] EntregaRepositoryMySQL - salva");
        Entrega novaEntrega = entregaMySQLSpringRepository.save(entrega);
        log.info("[Finaliza] EntregaRepositoryMySQL - salva");
        return novaEntrega;
    }

    @Override
    public Entrega buscarPorId(UUID idEntrega) {
        log.info("[Inicia] EntregaRepositoryMySQL - buscarPorId");
        Entrega entrega = entregaMySQLSpringRepository.findById(idEntrega)
                .orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Entrega não encontrada"));
        log.info("[Finaliza] EntregaRepositoryMySQL - buscarPorId");
        return entrega;
    }
}
