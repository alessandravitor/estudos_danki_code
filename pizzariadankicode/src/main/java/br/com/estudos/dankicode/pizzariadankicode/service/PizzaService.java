package br.com.estudos.dankicode.pizzariadankicode.service;

import br.com.estudos.dankicode.pizzariadankicode.domain.Pizza;
import br.com.estudos.dankicode.pizzariadankicode.domain.dto.PizzaRequest;
import br.com.estudos.dankicode.pizzariadankicode.domain.dto.PizzaResponse;
import br.com.estudos.dankicode.pizzariadankicode.repository.PizzaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzaService {

    @Autowired
    private PizzaRepository repository;
    @Autowired
    private ModelMapper mapper;

    public PizzaResponse criar(PizzaRequest request) {
        var pizza = mapper.map(request, Pizza.class);
        repository.save(pizza);
        return mapper.map(pizza, PizzaResponse.class);
    }

    public List<PizzaResponse> listar() {
        var pizzas = repository.findAll();
        return pizzas.stream().map(p -> mapper.map(p, PizzaResponse.class)).toList();
    }

    public PizzaResponse buscar(Long id) {
        var pizza = repository.findById(id);
        return pizza.isPresent() ? mapper.map(pizza, PizzaResponse.class) : null;
    }

    public void remover(Long id) {
        repository.deleteById(id);
    }

    public PizzaResponse atualizar(Long id, PizzaRequest request) {
        var pizza = mapper.map(request, Pizza.class);
        pizza.setId(id);
        repository.save(pizza);
        return mapper.map(pizza, PizzaResponse.class);
    }

    public void atualizarDisponibilidade(Long id) {
        var pizzaOptional = repository.findById(id);
        if(pizzaOptional.isPresent()) {
            var pizza = pizzaOptional.get();
            pizza.setDisponivel(!pizza.isDisponivel());
            repository.save(pizza);
        }

    }
}
