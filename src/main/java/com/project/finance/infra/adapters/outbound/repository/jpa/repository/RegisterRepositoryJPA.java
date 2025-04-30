package com.project.finance.infra.adapters.outbound.repository.jpa.repository;

import com.project.finance.infra.adapters.outbound.repository.jpa.entity.RegisterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegisterRepositoryJPA extends JpaRepository<RegisterEntity, Long> {

    @Query("""
            Select r from RegisterEntity r
            where r.space.id = :spaceId
            """)
    List<RegisterEntity> findBySpaceId(Long spaceId);

}
