package com.project.finance.infra.adapters.outbound.repository;

import com.project.finance.core.model.User;
import com.project.finance.core.ports.contracts.TokenService;
import org.springframework.stereotype.Component;

@Component
public class TokenServiceImpl implements TokenService {
    @Override
    public String generateToken(User user) {
        return "";
    }

    @Override
    public User validateToken(String token) {
        return null;
    }
}
