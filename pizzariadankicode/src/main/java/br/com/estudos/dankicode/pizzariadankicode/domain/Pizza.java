package br.com.estudos.dankicode.pizzariadankicode.domain;

import br.com.estudos.dankicode.pizzariadankicode.domain.constante.SaborEnum;
import br.com.estudos.dankicode.pizzariadankicode.domain.constante.TamnhoEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="pizza")
public class Pizza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private double preco;
    private boolean disponivel;
    @Enumerated(EnumType.STRING)
    private SaborEnum sabor;
    @Enumerated(EnumType.STRING)
    private TamnhoEnum tamanho;

}
