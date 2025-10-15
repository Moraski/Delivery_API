package com.Moraski.DeliveryAPI.Cliente.application.api;

import com.Moraski.DeliveryAPI.Cliente.domain.Cliente;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping(value = "/public/v1/cliente")


public interface ClienteAPI {
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    ClienteResponse postNovoCliente(@RequestBody @Valid ClienteNovoRequest cliente);

    @GetMapping(value = "/{idCliente}")
    @ResponseStatus(code = HttpStatus.OK)
    ClienteResponse getClientePorId(@PathVariable UUID idCliente);

    @PutMapping(value = "/{idCliente}")
    @ResponseStatus(code = HttpStatus.OK)
    ClienteResponse editaCliente(@PathVariable UUID idCliente, @RequestBody @Valid EditaClienteRequest editaClienteRequest);
}
