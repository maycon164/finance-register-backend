package com.project.finance.core.dto;

import com.project.finance.core.model.RegisterType;

import java.time.LocalDate;

public record RegisterDTO (
    String description,
    Long value,
    RegisterType registerType,
    LocalDate registerDate
) { }
