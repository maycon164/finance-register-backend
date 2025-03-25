package com.project.finance.core.ports.repository;

import com.project.finance.core.dto.RegisterDTO;

public interface RegisterRepository {

    void addRegister(Long spaceId, RegisterDTO registerDTO);


}
