package com.Moraski.DeliveryAPI.Entrega.application.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@Tag(name = "Entrega", description = "Endpoints de gestão de entregas")
@RequestMapping("/public/v1/entrega")
public interface EntregaAPI {

    @Operation(summary = "Cria uma nova entrega")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    EntregaResponse postNovaEntrega(@RequestBody @Valid EntregaNovoRequest novaEntrega);

    @Operation(summary = "Busca uma entrega pelo ID")
    @GetMapping("/{idEntrega}")
    @ResponseStatus(HttpStatus.OK)
    EntregaResponse getEntrega(@PathVariable UUID idEntrega);

    @Operation(summary = "Finaliza uma entrega")
    @PutMapping("/{idEntrega}/finaliza")
    @ResponseStatus(HttpStatus.OK)
    EntregaResponse finalizaEntrega(@PathVariable UUID idEntrega);
}
