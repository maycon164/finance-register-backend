package com.project.finance.core.services;

import com.project.finance.core.dto.AddRegisterDTO;
import com.project.finance.core.dto.GetRegistersDTO;
import com.project.finance.core.exception.SpaceNotFound;
import com.project.finance.core.model.Register;
import com.project.finance.core.model.Space;
import com.project.finance.core.model.User;
import com.project.finance.core.ports.repository.RegisterRepository;
import com.project.finance.core.ports.repository.SpaceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class RegisterService {

    private final RegisterRepository registerRepository;
    private final SpaceRepository spaceRepository;

    public RegisterService(RegisterRepository registerRepository, SpaceRepository spaceRepository) {
        this.registerRepository = registerRepository;
        this.spaceRepository = spaceRepository;
    }

    public void addRegister(User user, AddRegisterDTO registerDTO) {
        Space space = spaceRepository.findBySpaceId(registerDTO.spaceId()).orElseThrow(SpaceNotFound::new);
        log.info("Adding new register to {} at {}", user.email(), LocalDate.now());
        registerRepository.addRegister(user.email(), space.id(), registerDTO.register());
    }

    public List<Register> getRegisters(User user, GetRegistersDTO getRegistersDTO){
        return registerRepository.getRegister(getDefaultSpaceId(user, getRegistersDTO));
    }

    //TODO: getDefaultSpaceId when user dont send spaceId in DTO; remove
    private GetRegistersDTO getDefaultSpaceId(User user, GetRegistersDTO getRegistersDTO) {;
        return getRegistersDTO.withSpaceId(getDefaultSpace(user).id());
    }
    private Space getDefaultSpace(User user) {
        return this.spaceRepository.findByEmail(user.email()).orElseThrow(() -> new RuntimeException("Default Space not Found"));
    }

}
