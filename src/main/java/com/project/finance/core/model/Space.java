package com.project.finance.core.model;

import java.util.List;

public record Space (
        Long id,
        String name,
        User owner,
        List<User> members
){}
