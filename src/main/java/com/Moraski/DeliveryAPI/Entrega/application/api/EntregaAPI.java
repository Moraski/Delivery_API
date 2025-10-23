package com.Moraski.DeliveryAPI.Entrega.application.api;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RequestMapping("/public/v1/entrega")
public interface EntregaAPI {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    EntregaResponse postNovaEntrega(@RequestBody @Valid EntregaNovoRequest novaEntrega);

    @GetMapping("/{idEntrega}")
    @ResponseStatus(HttpStatus.OK)
    EntregaResponse getEntrega(@PathVariable UUID idEntrega);

    @PutMapping("/{idEntrega}/finaliza")
    @ResponseStatus(HttpStatus.OK)
    EntregaResponse finalizaEntrega(@PathVariable UUID idEntrega);
}
