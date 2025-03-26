package com.project.finance.infra.adapters.outbound.repository;

import com.project.finance.core.model.Space;
import com.project.finance.core.ports.repository.SpaceRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class SpaceRepositoryImpl implements SpaceRepository {

    @Override
    public Optional<Space> getSpaceById(Long spaceId) {
        return Optional.empty();
    }

    @Override
    public Optional<Space> getSpaceByEmail(String email) {
        return Optional.empty();
    }

}
