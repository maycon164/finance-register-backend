package com.project.finance.core.dto;

import com.project.finance.core.model.RegisterType;

public record RegisterDTO (
    Long value,
    RegisterType registerType
) { }
