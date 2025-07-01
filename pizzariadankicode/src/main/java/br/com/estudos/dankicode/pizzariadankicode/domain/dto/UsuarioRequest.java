package br.com.estudos.dankicode.pizzariadankicode.domain.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioRequest {
    @NotBlank
    private String login;
    @NotBlank
    private String password;
}
