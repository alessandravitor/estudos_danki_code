package br.com.estudos.dankicode.pizzariadankicode.controller;

import br.com.estudos.dankicode.pizzariadankicode.domain.dto.PizzaRequest;
import br.com.estudos.dankicode.pizzariadankicode.domain.dto.PizzaResponse;
import br.com.estudos.dankicode.pizzariadankicode.service.PizzaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pizzas")
public class PizzaController {

    @Autowired
    private PizzaService service;

    @PostMapping
    public  ResponseEntity cadastrar(@RequestBody @Valid PizzaRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(request));
    }

    @GetMapping
    public  ResponseEntity listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public  ResponseEntity buscar(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscar(id));
    }

    @PutMapping("/{id}")
    public  ResponseEntity atualizar(@PathVariable Long id,  @RequestBody @Valid PizzaRequest request) {
        return ResponseEntity.ok(service.atualizar(id, request));
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity remover(@PathVariable Long id) {
        service.remover(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
