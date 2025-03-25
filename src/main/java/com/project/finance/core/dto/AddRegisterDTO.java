package com.project.finance.core.dto;

import com.project.finance.core.model.Register;

public record AddRegisterDTO(
        Long spaceId,
        RegisterDTO register
) { }
