package br.com.estudos.dankicode.pizzariadankicode.config;

import br.com.estudos.dankicode.pizzariadankicode.exception.ForbiddenException;
import br.com.estudos.dankicode.pizzariadankicode.service.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

import static java.util.Objects.isNull;

@Component
@RequiredArgsConstructor
public class Filter extends OncePerRequestFilter {

    private final TokenService tokenService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var token = buscarToken(request);
        var usuarioLogin = tokenService.buscarUsuarioToken(token);
        filterChain.doFilter(request, response);
    }

    private String buscarToken(HttpServletRequest request) {
        var authorization = request.getHeader("Authorization");
        if(isNull(authorization)) {
            throw new ForbiddenException("Token não encontrado!");
        }
        return authorization.replace("Bearer ", "");
    }
}
