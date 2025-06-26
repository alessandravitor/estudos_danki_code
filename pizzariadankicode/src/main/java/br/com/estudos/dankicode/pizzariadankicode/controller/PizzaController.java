package br.com.estudos.dankicode.pizzariadankicode.controller;

import br.com.estudos.dankicode.pizzariadankicode.domain.dto.PizzaDTO;
import br.com.estudos.dankicode.pizzariadankicode.service.PizzaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "/pizzas")
public class PizzaController {

    @Autowired
    private PizzaService service;

    @PostMapping
    public  ResponseEntity cadastrar(@RequestBody PizzaDTO request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(request));
    }

}
