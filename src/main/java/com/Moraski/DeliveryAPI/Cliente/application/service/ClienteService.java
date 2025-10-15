package com.Moraski.DeliveryAPI.Cliente.application.service;

import com.Moraski.DeliveryAPI.Cliente.application.api.ClienteNovoRequest;
import com.Moraski.DeliveryAPI.Cliente.application.api.ClienteResponse;
import com.Moraski.DeliveryAPI.Cliente.application.api.EditaClienteRequest;
import jakarta.validation.Valid;

import java.util.UUID;

public interface ClienteService {
    ClienteResponse criarNovoCliente(@Valid ClienteNovoRequest cliente);
    ClienteResponse buscarClientePorId(UUID idCliente);
    ClienteResponse editaCliente(UUID idCliente, EditaClienteRequest editaClienteRequest);
}
