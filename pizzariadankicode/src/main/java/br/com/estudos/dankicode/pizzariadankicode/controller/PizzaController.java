package br.com.estudos.dankicode.pizzariadankicode.controller;

import br.com.estudos.dankicode.pizzariadankicode.domain.dto.PizzaRequest;
import br.com.estudos.dankicode.pizzariadankicode.domain.dto.PizzaResponse;
import br.com.estudos.dankicode.pizzariadankicode.service.PizzaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pizzas")
@SecurityRequirement(name = "bearer-key")
public class PizzaController {

    private final PizzaService service;

    @PostMapping
    public  ResponseEntity<Object> cadastrar(@RequestBody @Valid PizzaRequest request, UriComponentsBuilder uriBuilder) {
        var pizza = service.criar(request);
        return ResponseEntity
                .created(uriBuilder.path("pizzas/{id}").buildAndExpand(pizza.getId()).toUri())
                .body(pizza);
    }

    @GetMapping
    public  ResponseEntity<Page<PizzaResponse>> listar(@PageableDefault(size = 5, sort = "nome") Pageable paginacao) {
        return ResponseEntity.ok(service.listar(paginacao));
    }

    @GetMapping("/{id}")
    public  ResponseEntity<Object> buscar(@PathVariable @NotNull Long id) {
        return ResponseEntity.ok(service.buscar(id));
    }

    @PutMapping("/{id}")
    public  ResponseEntity<Object> atualizar(@PathVariable @NotNull Long id,  @RequestBody @Valid PizzaRequest request) {
        return ResponseEntity.ok(service.atualizar(id, request));
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<Object> remover(@PathVariable Long id) {
        service.remover(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    public  ResponseEntity<Void> atualizarDisponibilidade(@PathVariable @NotNull Long id) {
        service.atualizarDisponibilidade(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
