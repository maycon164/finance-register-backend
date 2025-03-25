package com.project.finance.core.services;

import com.project.finance.core.dto.AddRegisterDTO;
import com.project.finance.core.ports.repository.RegisterRepository;

public class RegisterService {

    private final RegisterRepository registerRepository;

    public RegisterService(RegisterRepository registerRepository) {
        this.registerRepository = registerRepository;
    }

    public void addRegister(AddRegisterDTO registerDTO) {

        registerRepository.addRegister(registerDTO.spaceId(), registerDTO.register());

    }

}
