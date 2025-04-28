package com.project.finance.infra.adapters.mapper;

import com.project.finance.core.model.User;
import com.project.finance.infra.adapters.outbound.repository.jpa.entity.UserEntity;

public class UserMapper {

    public static User toUser(UserEntity userEntity) {
        return new User(
                userEntity.getId(),
                userEntity.getName(),
                userEntity.getEmail()
        );
    }

}
