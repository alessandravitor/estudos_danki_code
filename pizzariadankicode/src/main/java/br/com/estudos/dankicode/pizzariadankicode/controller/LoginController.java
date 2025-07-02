package br.com.estudos.dankicode.pizzariadankicode.controller;

import br.com.estudos.dankicode.pizzariadankicode.domain.Usuario;
import br.com.estudos.dankicode.pizzariadankicode.domain.dto.UsuarioRequest;
import br.com.estudos.dankicode.pizzariadankicode.service.TokenService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/login")
public class LoginController {

    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    @PostMapping
    public ResponseEntity<String> login(@RequestBody @Valid UsuarioRequest request) {

        var token = new UsernamePasswordAuthenticationToken(request.getLogin(), request.getPassword());
        var authentication = authenticationManager.authenticate(token);

        return ResponseEntity.ok(tokenService.criarToken((Usuario) authentication.getPrincipal()));
    }

}
