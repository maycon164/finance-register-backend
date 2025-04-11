package com.project.finance.infra.adapters.outbound.repository;

import com.project.finance.core.dto.SpaceDTO;
import com.project.finance.core.model.Space;
import com.project.finance.core.ports.repository.SpaceRepository;
import com.project.finance.infra.adapters.outbound.repository.jpa.entity.SpaceEntity;
import com.project.finance.infra.adapters.outbound.repository.jpa.entity.UserEntity;
import com.project.finance.infra.adapters.outbound.repository.jpa.repository.SpaceRepositoryJPA;
import com.project.finance.infra.adapters.outbound.repository.jpa.repository.UserRepositoryJpa;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Component
public class SpaceRepositoryImpl implements SpaceRepository {

    private final SpaceRepositoryJPA spaceRepositoryJPA;
    private final UserRepositoryJpa userRepositoryJpa;

    public SpaceRepositoryImpl(SpaceRepositoryJPA spaceRepositoryJPA, UserRepositoryJpa userRepositoryJpa) {
        this.spaceRepositoryJPA = spaceRepositoryJPA;
        this.userRepositoryJpa = userRepositoryJpa;
    }

    @Override
    public Optional<Space> getSpaceById(Long spaceId) {
        return spaceRepositoryJPA.findById(spaceId).map(this::toSpace);
    }

    @Override
    public Optional<Space> getSpaceByEmail(String email) {
        return Optional.empty();
    }

    @Override
    public void createSpace(String email, SpaceDTO spaceDTO) {
        UserEntity user = userRepositoryJpa.findByEmail(email);
        SpaceEntity space = toSpaceEntity(user, spaceDTO);
        spaceRepositoryJPA.save(space);
    }

    private SpaceEntity toSpaceEntity(UserEntity user, SpaceDTO spaceDTO){
        SpaceEntity space = new SpaceEntity();
        space.setName(spaceDTO.name());
        space.setUser(user);
        space.setCreatedAt(LocalDate.now());
        return space;
    }

    private Space toSpace(SpaceEntity space) {
        return new Space(
                space.getId(),
                space.getName(),
                null,
                List.of()
        );
    }
}
