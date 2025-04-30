package com.project.finance.infra.adapters.outbound.repository.jpa.repository;

import com.project.finance.core.model.Space;
import com.project.finance.infra.adapters.outbound.repository.jpa.entity.SpaceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SpaceRepositoryJPA extends JpaRepository<SpaceEntity, Long> {

    @Query("""
            Select space from SpaceEntity space
            where space.user.email = :email
            """)
    List<SpaceEntity> findByEmail(String email);
}
