package com.dinheiro.monitor;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class SecurityJwt {
    private final SecretKey Key = Keys.secretKeyFor(io.jsonwebtoken.SignatureAlgorithm.HS256);

    public String geraToken(String gmail) {
        Date agora = new Date();
        Date expiracao = new Date(agora.getTime() + 3600000);
        return Jwts.builder()
                .subject(gmail)
                .issuedAt(agora)
                .expiration(expiracao)
                .signWith(Key)
                .compact();
    }

    public String validarToken(String token) {
        return Jwts.parser()
                .verifyWith(Key)
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }
}