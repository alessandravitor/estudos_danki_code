package br.com.estudos.dankicode.pizzariadankicode.repository;

import br.com.estudos.dankicode.pizzariadankicode.domain.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaRepository extends JpaRepository<Pizza, Long> {
}
