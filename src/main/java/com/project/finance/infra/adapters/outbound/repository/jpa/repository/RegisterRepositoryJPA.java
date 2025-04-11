package com.project.finance.infra.adapters.outbound.repository.jpa.repository;

import com.project.finance.infra.adapters.outbound.repository.jpa.entity.RegisterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterRepositoryJPA extends JpaRepository<RegisterEntity, Long> {
}
