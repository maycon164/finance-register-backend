package com.project.finance.core.services;

import com.project.finance.core.dto.AddRegisterDTO;
import com.project.finance.core.dto.GetRegistersDTO;
import com.project.finance.core.exception.SpaceNotFound;
import com.project.finance.core.model.Register;
import com.project.finance.core.model.Space;
import com.project.finance.core.ports.repository.RegisterRepository;
import com.project.finance.core.ports.repository.SpaceRepository;

import java.util.List;

public class RegisterService {

    private final RegisterRepository registerRepository;
    private final SpaceRepository spaceRepository;

    public RegisterService(RegisterRepository registerRepository, SpaceRepository spaceRepository) {
        this.registerRepository = registerRepository;
        this.spaceRepository = spaceRepository;
    }

    public void addRegister(AddRegisterDTO registerDTO) {
        Space space = spaceRepository.getSpaceById(registerDTO.spaceId()).orElseThrow(SpaceNotFound::new);
        registerRepository.addRegister(space.id(), registerDTO.register());
    }

    public List<Register> getRegisters(GetRegistersDTO getRegistersDTO){
        return registerRepository.getRegister(getRegistersDTO);
    }

}
