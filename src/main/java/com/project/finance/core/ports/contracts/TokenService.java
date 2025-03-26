package com.project.finance.core.ports.contracts;

import com.project.finance.core.model.User;

public interface TokenService {

    String generateToken(User user);
}
