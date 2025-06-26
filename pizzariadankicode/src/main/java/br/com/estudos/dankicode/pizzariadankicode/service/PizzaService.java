package br.com.estudos.dankicode.pizzariadankicode.service;

import br.com.estudos.dankicode.pizzariadankicode.domain.Pizza;
import br.com.estudos.dankicode.pizzariadankicode.domain.dto.PizzaDTO;
import br.com.estudos.dankicode.pizzariadankicode.repository.PizzaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PizzaService {

    @Autowired
    private PizzaRepository repository;
    @Autowired
    private ModelMapper mapper;

    public PizzaDTO criar(PizzaDTO request) {
        var pizza = mapper.map(request, Pizza.class);
        repository.save(pizza);
        return mapper.map(pizza, PizzaDTO.class);
    }
}
