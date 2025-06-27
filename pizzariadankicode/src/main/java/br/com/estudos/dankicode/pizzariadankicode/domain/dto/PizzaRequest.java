package br.com.estudos.dankicode.pizzariadankicode.domain.dto;

import br.com.estudos.dankicode.pizzariadankicode.domain.constante.CategoriaEnum;
import br.com.estudos.dankicode.pizzariadankicode.domain.constante.SaborEnum;
import br.com.estudos.dankicode.pizzariadankicode.domain.constante.TamnhoEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PizzaRequest {

    @NotBlank
    private String nome;
    @Positive
    private double preco;
    private boolean disponivel;
    private SaborEnum sabor;
    private TamnhoEnum tamanho;
    private CategoriaEnum categoria;
}
