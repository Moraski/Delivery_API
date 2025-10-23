package com.Moraski.DeliveryAPI.Item.application.api;

import com.Moraski.DeliveryAPI.Item.domain.Item;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@Tag(name = "Item", description = "Endpoints de gestão de itens")
@RequestMapping(value = "/public/v1/item")
public interface ItemAPI {

    @Operation(summary = "Cria um novo item")
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    ItemResponse postNovoItem(@RequestBody @Valid ItemNovoRequest item);

    @Operation(summary = "Busca um item por ID")
    @GetMapping("/{idItem}")
    @ResponseStatus(code = HttpStatus.OK)
    ItemResponse getItemPorId(@PathVariable UUID idItem);

    @Operation(summary = "Edita um item")
    @PutMapping("/{idItem}")
    @ResponseStatus(code = HttpStatus.OK)
    ItemResponse editaItem(@PathVariable UUID idItem, @RequestBody @Valid EditaItemRequest item);

    @Operation(summary = "Deleta um item")
    @DeleteMapping("/{idItem}/delete")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void deleteItem(@PathVariable UUID idItem);
}
