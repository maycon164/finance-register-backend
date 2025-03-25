package com.project.finance.core.model;

import java.time.LocalDate;

public record Register (
        Long id,
        Long value,
        RegisterType type,
        LocalDate createdAt
) { }
