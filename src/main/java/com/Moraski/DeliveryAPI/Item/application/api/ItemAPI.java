package com.Moraski.DeliveryAPI.Item.application.api;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@RequestMapping(value = "/public/v1/item")
public interface ItemAPI {

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    ItemResponse postNovoItem(@RequestBody @Valid ItemNovoRequest item);
}
