package br.com.estudos.dankicode.pizzariadankicode.domain.dto;

import br.com.estudos.dankicode.pizzariadankicode.domain.constante.SaborEnum;
import br.com.estudos.dankicode.pizzariadankicode.domain.constante.TamnhoEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PizzaDTO {
    private String nome;
    private double preco;
    private boolean disponivel;
    private SaborEnum sabor;
    private TamnhoEnum tamanho;
}
