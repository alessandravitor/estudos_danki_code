package br.com.estudos.dankicode.pizzariadankicode.controller;

import br.com.estudos.dankicode.pizzariadankicode.domain.dto.UsuarioRequest;
import br.com.estudos.dankicode.pizzariadankicode.domain.dto.UsuarioResponse;
import br.com.estudos.dankicode.pizzariadankicode.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequiredArgsConstructor
@RequestMapping("/usuarios")
@SecurityRequirement(name = "bearer-key")
public class UserController {

    private final UserService service;

    @PostMapping
    public ResponseEntity<UsuarioResponse> cadastrar(@RequestBody @Valid UsuarioRequest request, UriComponentsBuilder uriBuilder) {
        var user = service.criar(request);
        return ResponseEntity.created(uriBuilder.path("usuarios/{id}").buildAndExpand(user.getId()).toUri())
                .body(user);
    }

    public ResponseEntity<Page<UsuarioResponse>> listar(@PageableDefault(size = 5, sort = "nome") Pageable paginacao) {
        return ResponseEntity.ok(service.listar(paginacao));
    }
}
