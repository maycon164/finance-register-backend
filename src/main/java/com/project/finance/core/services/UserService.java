package com.project.finance.core.services;

import com.project.finance.core.dto.UserInfoDTO;
import com.project.finance.core.exception.SpaceNotFound;
import com.project.finance.core.exception.UserNotFound;
import com.project.finance.core.model.Space;
import com.project.finance.core.model.User;
import com.project.finance.core.ports.repository.SpaceRepository;
import com.project.finance.core.ports.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;
    private SpaceRepository spaceRepository;

    public UserService(
            UserRepository userRepository,
            SpaceRepository spaceRepository
    ) {
        this.userRepository = userRepository;
        this.spaceRepository = spaceRepository;
    }

    public UserInfoDTO getUserInfo(String email) {
        Space space = spaceRepository.getSpaceByEmail(email).orElseThrow(SpaceNotFound::new);
        User user = userRepository.getUserByEmail(email).orElseThrow(UserNotFound::new);
        return new UserInfoDTO(user, space);
    }

}
