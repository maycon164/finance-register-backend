package com.project.finance.infra.adapters.outbound.repository;

import com.project.finance.core.dto.GetRegistersDTO;
import com.project.finance.core.dto.RegisterDTO;
import com.project.finance.core.model.Register;
import com.project.finance.core.ports.repository.RegisterRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RegisterRepositoryImpl implements RegisterRepository {

    @Override
    public void addRegister(Long spaceId, RegisterDTO registerDTO) {

    }

    @Override
    public List<Register> getRegister(GetRegistersDTO getRegistersDTO) {
        return List.of();
    }

}
