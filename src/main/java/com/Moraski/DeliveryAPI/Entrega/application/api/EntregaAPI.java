package com.Moraski.DeliveryAPI.Entrega.application.api;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/public/v1/entrega")
public interface EntregaAPI {

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    EntregaResponse postNovaEntrega(@RequestBody @Valid EntregaNovoRequest novaEntrega);
}
