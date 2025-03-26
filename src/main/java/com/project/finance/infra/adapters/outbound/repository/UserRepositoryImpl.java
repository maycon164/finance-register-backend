package com.project.finance.infra.adapters.outbound.repository;

import com.project.finance.core.model.User;
import com.project.finance.core.ports.repository.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Override
    public Optional<User> getUserByEmail(String email) {
        return Optional.empty();
    }
}
