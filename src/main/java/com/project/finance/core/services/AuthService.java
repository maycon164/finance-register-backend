package com.project.finance.core.services;

import com.project.finance.core.dto.LoginDTO;
import com.project.finance.core.dto.RegisterUserDTO;
import com.project.finance.core.dto.TokenDTO;
import com.project.finance.core.exception.UserNotFound;
import com.project.finance.core.model.User;
import com.project.finance.core.ports.contracts.TokenService;
import com.project.finance.core.ports.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final TokenService tokenService;
    private final SpaceService spaceService;

    public AuthService(
            UserRepository userRepository,
            TokenService tokenService,
            SpaceService spaceService
    ) {
        this.userRepository = userRepository;
        this.tokenService = tokenService;
        this.spaceService = spaceService;
    }

    public TokenDTO login(LoginDTO loginDTO) {
        User user = userRepository.getUserByEmail(loginDTO.email()).orElseThrow(UserNotFound::new);
        spaceService.ensureDefaultUserSpace(user);
        return new TokenDTO(tokenService.generateToken(user));
    }

    public void createUser(RegisterUserDTO registerUserDTO) {
        userRepository.addUser(registerUserDTO);
    }

}
