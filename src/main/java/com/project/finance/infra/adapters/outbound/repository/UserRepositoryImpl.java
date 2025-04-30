package com.project.finance.infra.adapters.outbound.repository;

import com.project.finance.core.dto.RegisterUserDTO;
import com.project.finance.core.model.User;
import com.project.finance.core.ports.repository.UserRepository;
import com.project.finance.infra.adapters.outbound.repository.jpa.entity.UserEntity;
import com.project.finance.infra.adapters.outbound.repository.jpa.repository.UserRepositoryJpa;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserRepositoryImpl implements UserRepository {

    private final UserRepositoryJpa userRepositoryJpa;

    public UserRepositoryImpl(UserRepositoryJpa userRepositoryJpa) {
        this.userRepositoryJpa = userRepositoryJpa;
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return Optional.ofNullable(userRepositoryJpa.findByEmail(email)).map(this::toUser);
    }

    @Override
    public void addUser(RegisterUserDTO registerUserDTO) {
        this.userRepositoryJpa.save(toUserEntity(registerUserDTO));
    }

    private User toUser(UserEntity userEntity) {
        return new User(userEntity.getId(), userEntity.getName(), userEntity.getEmail());
    }

    private UserEntity toUserEntity(RegisterUserDTO registerUserDTO) {
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(registerUserDTO.email());
        return userEntity;
    }

}
