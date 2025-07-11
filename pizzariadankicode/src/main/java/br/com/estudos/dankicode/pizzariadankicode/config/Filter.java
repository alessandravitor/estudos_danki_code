package br.com.estudos.dankicode.pizzariadankicode.config;

import br.com.estudos.dankicode.pizzariadankicode.exception.ForbiddenException;
import br.com.estudos.dankicode.pizzariadankicode.repository.UserRepository;
import br.com.estudos.dankicode.pizzariadankicode.service.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Component
@RequiredArgsConstructor
public class Filter extends OncePerRequestFilter {

    private final TokenService tokenService;
    private final UserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var token = buscarToken(request);
        if(nonNull(token)) {
            var usuarioLogin = tokenService.buscarUsuarioToken(token);
            var usuario = userRepository.findByLogin(usuarioLogin);
            var autenticador = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());

            SecurityContextHolder.getContext().setAuthentication(autenticador);
        }
        filterChain.doFilter(request, response);
    }

    private String buscarToken(HttpServletRequest request) {
        var authorization = request.getHeader("Authorization");
        if(isNull(authorization)) {
            return null;
        }
        return authorization.replace("Bearer ", "");
    }
}
