package com.project.finance.core.model;

import java.util.List;

public record Space (
        Long id,
        User owner,
        List<User> members
){}
