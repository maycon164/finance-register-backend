package com.project.finance.infra.adapters.outbound.repository.jpa.repository;

import com.project.finance.infra.adapters.outbound.repository.jpa.entity.SpaceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpaceRepositoryJPA extends JpaRepository<SpaceEntity, Long> {

}
