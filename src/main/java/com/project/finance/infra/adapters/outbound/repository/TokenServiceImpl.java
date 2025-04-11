package com.project.finance.infra.adapters.outbound.repository;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.project.finance.core.exception.UserNotFound;
import com.project.finance.core.model.User;
import com.project.finance.core.ports.contracts.TokenService;
import com.project.finance.core.ports.repository.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class TokenServiceImpl implements TokenService {

    //TODO: add issuer in env variables
    private final static String jwtIssuer = "app";
    //TODO: add secret in env variables
    private final static String jwtSecret = "secret";
    private final UserRepository userRepository;

    public TokenServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public String generateToken(User user) {
        return JWT.create()
                .withClaim("email", user.email())
                .withIssuer(jwtIssuer)
                .sign(getAlgorithm());
    }

    @Override
    public User validateToken(String token) {
        JWTVerifier jwtVerifier = JWT
                .require(getAlgorithm())
                .withIssuer(jwtIssuer)
                .build();

        DecodedJWT decodedJWT = jwtVerifier.verify(token);
        String email = decodedJWT.getClaim("email").asString();

        return userRepository.getUserByEmail(email).orElseThrow(UserNotFound::new);
    }

    private Algorithm getAlgorithm() {
        return Algorithm.HMAC256(jwtSecret);
    }
}
