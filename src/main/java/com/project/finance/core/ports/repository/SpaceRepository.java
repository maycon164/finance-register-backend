package com.project.finance.core.ports.repository;

import com.project.finance.core.dto.SpaceDTO;
import com.project.finance.core.model.Space;

import java.util.Optional;

public interface SpaceRepository {

   Optional<Space> getSpaceById(Long spaceId);
   Optional<Space> getSpaceByEmail(String email);

   void createSpace(String email, SpaceDTO spaceDTO);
}
