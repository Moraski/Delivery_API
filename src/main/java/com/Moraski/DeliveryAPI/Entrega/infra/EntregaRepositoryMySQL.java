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

}
