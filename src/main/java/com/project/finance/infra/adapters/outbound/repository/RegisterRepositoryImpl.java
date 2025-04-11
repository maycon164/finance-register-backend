package com.project.finance.infra.adapters.outbound.repository;

import com.project.finance.core.dto.GetRegistersDTO;
import com.project.finance.core.dto.RegisterDTO;
import com.project.finance.core.exception.SpaceNotFound;
import com.project.finance.core.model.Register;
import com.project.finance.core.ports.repository.RegisterRepository;
import com.project.finance.core.ports.repository.SpaceRepository;
import com.project.finance.core.ports.repository.UserRepository;
import com.project.finance.infra.adapters.outbound.repository.jpa.entity.RegisterEntity;
import com.project.finance.infra.adapters.outbound.repository.jpa.entity.SpaceEntity;
import com.project.finance.infra.adapters.outbound.repository.jpa.entity.UserEntity;
import com.project.finance.infra.adapters.outbound.repository.jpa.repository.RegisterRepositoryJPA;
import com.project.finance.infra.adapters.outbound.repository.jpa.repository.SpaceRepositoryJPA;
import com.project.finance.infra.adapters.outbound.repository.jpa.repository.UserRepositoryJpa;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RegisterRepositoryImpl implements RegisterRepository {

    private final RegisterRepositoryJPA registerRepositoryJPA;
    private final SpaceRepositoryJPA spaceRepositoryJPA;
    private final UserRepositoryJpa userRepositoryJpa;

    public RegisterRepositoryImpl(
            RegisterRepositoryJPA registerRepositoryJPA,
            SpaceRepositoryJPA spaceRepositoryJPA,
            UserRepositoryJpa userRepositoryJpa
    ) {
        this.registerRepositoryJPA = registerRepositoryJPA;
        this.spaceRepositoryJPA = spaceRepositoryJPA;
        this.userRepositoryJpa = userRepositoryJpa;
    }

    @Override
    public void addRegister(String email, Long spaceId, RegisterDTO registerDTO) {
        UserEntity user = userRepositoryJpa.findByEmail(email);

        SpaceEntity space = spaceRepositoryJPA.findById(spaceId).orElseThrow(SpaceNotFound::new);

        RegisterEntity register = toRegisterEntity(registerDTO);

        register.setUser(user);
        register.setSpace(space);

        registerRepositoryJPA.save(register);
    }

    @Override
    public List<Register> getRegister(GetRegistersDTO getRegistersDTO) {
        return List.of();
    }

    private RegisterEntity toRegisterEntity(RegisterDTO registerDTO) {
        RegisterEntity registerEntity = new RegisterEntity();
        registerEntity.setDescription(registerDTO.description());
        registerEntity.setType(registerDTO.registerType());
        registerEntity.setRegisterDate(registerDTO.registerDate());
        registerEntity.setAmount(registerDTO.value());
        return registerEntity;
    }

}
