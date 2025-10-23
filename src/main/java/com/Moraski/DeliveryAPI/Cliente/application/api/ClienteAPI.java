package com.Moraski.DeliveryAPI.Cliente.application.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "Cliente", description = "Endpoints de gestão de clientes")
@RequestMapping(value = "/public/v1/cliente")


public interface ClienteAPI {
    @Operation(summary = "Cria um novo cliente")
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    ClienteResponse postNovoCliente(@RequestBody @Valid ClienteNovoRequest cliente);

    @Operation(summary = "Busca um cliente pelo ID")
    @GetMapping(value = "/{idCliente}")
    @ResponseStatus(code = HttpStatus.OK)
    ClienteResponse getClientePorId(@PathVariable UUID idCliente);

    @Operation(summary = "Altera os dados de um cliente")
    @PutMapping(value = "/{idCliente}")
    @ResponseStatus(code = HttpStatus.OK)
    ClienteResponse editaCliente(@PathVariable UUID idCliente, @RequestBody @Valid EditaClienteRequest editaClienteRequest);

    @Operation(summary = "Deleta um cliente existente")
    @DeleteMapping(value = "/{idCliente}/delete")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void deletaCliente(@PathVariable UUID idCliente);

}
