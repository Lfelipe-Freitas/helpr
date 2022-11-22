package org.soulcodeacademy.helpr.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TokenUtil {
    @Value("${senhaJwt}")
    private String senhaJwt;
    @Value("${validadeJwt}")
    private Long validadeJwt;

    public String gerarToken(String email, String perfil) {
        return JWT.create()
                .withSubject(email)
                .withClaim("perfil", perfil)
                .withExpiresAt(new Date(System.currentTimeMillis() + this.validadeJwt))
                .sign(Algorithm.HMAC512(this.senhaJwt));
    }

    public String extrairEmail(String token) {
        return JWT.require(Algorithm.HMAC512(this.senhaJwt))
                .build()
                .verify(token)
                .getSubject();
    }

    public boolean validarToken(String token) {
        try {
            JWT.require((Algorithm.HMAC512(this.senhaJwt)))
                    .build()
                    .verify(token);
            return true;
        } catch(JWTVerificationException ex) {
            return false;
        }
    }
}
