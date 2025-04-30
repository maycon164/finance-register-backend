package com.project.finance.core.services;

import com.project.finance.core.dto.SpaceDTO;
import com.project.finance.core.model.Space;
import com.project.finance.core.model.User;
import com.project.finance.core.ports.repository.SpaceRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Log4j2
@Service
public class SpaceService {

    private final SpaceRepository spaceRepository;

    public SpaceService(SpaceRepository spaceRepository) {
        this.spaceRepository = spaceRepository;
    }

    public void ensureDefaultUserSpace(User user) {
        log.info("Verifying if user {} has a space", user.email());
        Optional<Space> optionalSpace = spaceRepository.findByEmail(user.email());

        if(optionalSpace.isEmpty()) {
            log.info("User does not have a space, creating default space to {}", user.email());
            SpaceDTO space = new SpaceDTO("DefaultSpace");
            spaceRepository.createSpace(user.email(), space);
            log.info("Default space was created to user {}", user.email());
            return;
        }

        return;
    }
}
