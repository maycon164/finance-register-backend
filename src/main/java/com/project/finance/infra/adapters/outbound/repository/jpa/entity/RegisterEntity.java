package com.project.finance.infra.adapters.outbound.repository.jpa.entity;

import com.project.finance.core.model.RegisterType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity(name = "RegisterEntity")
@Table(name = "registers")
@Getter
@Setter
@Data
public class RegisterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String description;

    @Column
    private Long amount;

    @Column
    @Enumerated(EnumType.STRING)
    private RegisterType type;

    @Column
    private LocalDate registerDate;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "space_id")
    private SpaceEntity space;
}
