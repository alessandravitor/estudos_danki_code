package br.com.estudos.dankicode.pizzariadankicode.domain;

import br.com.estudos.dankicode.pizzariadankicode.domain.constante.SaborEnum;
import br.com.estudos.dankicode.pizzariadankicode.domain.constante.TamnhoEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pizza {

    private Long id;
    private String nome;
    private SaborEnum sabor;
    private double preco;
    private TamnhoEnum tamanho;
    private boolean disponivel;

}
