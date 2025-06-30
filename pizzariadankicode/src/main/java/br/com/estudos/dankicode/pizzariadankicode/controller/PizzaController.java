package br.com.estudos.dankicode.pizzariadankicode.controller;

import br.com.estudos.dankicode.pizzariadankicode.domain.dto.PizzaRequest;
import br.com.estudos.dankicode.pizzariadankicode.domain.dto.PizzaResponse;
import br.com.estudos.dankicode.pizzariadankicode.service.PizzaService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pizzas")
public class PizzaController {

    @Autowired
    private PizzaService service;

    @PostMapping
    public  ResponseEntity<PizzaResponse> cadastrar(@RequestBody @Valid PizzaRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(request));
    }

    @GetMapping
    public  ResponseEntity<List<PizzaResponse>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public  ResponseEntity<PizzaResponse> buscar(@PathVariable @NotNull Long id) {
        return ResponseEntity.ok(service.buscar(id));
    }

    @PutMapping("/{id}")
    public  ResponseEntity<PizzaResponse> atualizar(@PathVariable @NotNull Long id,  @RequestBody @Valid PizzaRequest request) {
        return ResponseEntity.ok(service.atualizar(id, request));
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<Void> remover(@PathVariable Long id) {
        service.remover(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PatchMapping("/{id}")
    public  ResponseEntity<Void> atualizarDisponibilidade(@PathVariable @NotNull Long id) {
        service.atualizarDisponibilidade(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
