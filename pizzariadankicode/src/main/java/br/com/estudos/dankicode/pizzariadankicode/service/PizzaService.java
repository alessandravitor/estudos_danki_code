package br.com.estudos.dankicode.pizzariadankicode.service;

import br.com.estudos.dankicode.pizzariadankicode.domain.Pizza;
import br.com.estudos.dankicode.pizzariadankicode.domain.dto.PizzaRequest;
import br.com.estudos.dankicode.pizzariadankicode.domain.dto.PizzaResponse;
import br.com.estudos.dankicode.pizzariadankicode.repository.PizzaRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PizzaService {

    private final PizzaRepository repository;
    private final ModelMapper mapper;

    public PizzaResponse criar(PizzaRequest request) {
        var pizza = mapper.map(request, Pizza.class);
        repository.save(pizza);
        return mapper.map(pizza, PizzaResponse.class);
    }

    public Page<PizzaResponse> listar(Pageable paginacao) {
        return repository.findAll(paginacao).map(p -> mapper.map(p, PizzaResponse.class));
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
