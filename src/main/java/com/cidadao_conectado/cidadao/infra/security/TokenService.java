package com.cidadao_conectado.cidadao.infra.security;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.cidadao_conectado.cidadao.domain.model.User;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;

    public String generateToken(User user){
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);

            String token = JWT.create()
            .withIssuer("cidadao_conectado")
            .withSubject(user.getEmail())
            .withExpiresAt(this.generateExpirationDate())
            .sign(algorithm);
        return token;
        } catch (JWTCreationException exception) {
            throw new RuntimeException("Error while authenticating");
        }
    }

    public String validateToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            
            return JWT.require(algorithm)
            .withIssuer("cidadao_conectado")
            .build()
            .verify(token)
            .getSubject();

        } catch (JWTVerificationException exception) {
            return null;
        }
    }

    private Instant generateExpirationDate() {
    return LocalDateTime.now(ZoneId.of("America/Sao_Paulo"))
            .plusHours(2)
            .toInstant(ZoneId.of("America/Sao_Paulo").getRules().getOffset(Instant.now()));
}

}
