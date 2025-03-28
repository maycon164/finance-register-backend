package com.project.finance.infra.adapters.outbound.repository.jpa.repository;

import com.project.finance.core.model.User;
import com.project.finance.infra.adapters.outbound.repository.jpa.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositoryJpa extends JpaRepository<UserEntity, Long> {

    @Query("""
            select u from UserEntity u
            where u.email = :email
            """)
    UserEntity findByEmail(String email);
}
