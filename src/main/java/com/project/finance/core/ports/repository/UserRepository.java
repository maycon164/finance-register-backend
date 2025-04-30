package com.project.finance.core.ports.repository;

import com.project.finance.core.dto.RegisterUserDTO;
import com.project.finance.core.model.User;

import java.util.Optional;

public interface UserRepository {

    Optional<User> getUserByEmail(String email);

    void addUser(RegisterUserDTO registerUserDTO);
}
