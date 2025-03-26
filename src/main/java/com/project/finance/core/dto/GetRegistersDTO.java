package com.project.finance.core.dto;

import java.time.LocalDate;

public record GetRegistersDTO(
        Long spaceId,
        LocalDate day
) { }
