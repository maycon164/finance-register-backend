package com.project.finance.core.dto;

import com.project.finance.core.model.Space;
import com.project.finance.core.model.User;

public record UserInfoDTO(
        User user,
        Space space
) { }
