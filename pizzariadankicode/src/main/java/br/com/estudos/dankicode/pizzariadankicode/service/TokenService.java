package br.com.estudos.dankicode.pizzariadankicode.service;

import br.com.estudos.dankicode.pizzariadankicode.domain.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {


    public String criarToken(Usuario usuario) {
        try {
            Algorithm algorithm = Algorithm.HMAC256("1234");
            var dataExpiracao = LocalDateTime.now().plusHours(2);
            return JWT.create().withIssuer("curso Danki Code")
                    .withSubject(usuario.getLogin())
                    .withExpiresAt(dataExpiracao.toInstant(ZoneOffset.of("-03:00")))
                    .sign(algorithm);
        } catch (JWTCreationException e) {
            throw new RuntimeException("Erro ao criar token", e);
        }
    }

    public String buscarUsuarioToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256("1234");
            return JWT.require(algorithm)
                    .withIssuer("curso Danki Code")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTVerificationException e) {
            throw new RuntimeException("Erro ao criar token", e);
        }
    }
}
