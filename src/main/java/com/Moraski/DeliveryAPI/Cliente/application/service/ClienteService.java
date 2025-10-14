package com.Moraski.DeliveryAPI.Cliente.application.service;

import com.Moraski.DeliveryAPI.Cliente.application.api.ClienteNovoRequest;
import com.Moraski.DeliveryAPI.Cliente.application.api.ClienteResponse;
import jakarta.validation.Valid;

public interface ClienteService {
    ClienteResponse criarNovoCliente(@Valid ClienteNovoRequest cliente);
}
