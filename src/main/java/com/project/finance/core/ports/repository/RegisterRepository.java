package com.project.finance.core.ports.repository;

import com.project.finance.core.dto.GetRegistersDTO;
import com.project.finance.core.dto.RegisterDTO;
import com.project.finance.core.model.Register;

import java.util.List;

public interface RegisterRepository {

    void addRegister(String email, Long spaceId, RegisterDTO registerDTO);

    List<Register> getRegister(GetRegistersDTO getRegistersDTO);
}
