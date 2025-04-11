package com.project.finance.infra.adapters.inbound.controllers;

import com.project.finance.core.model.User;
import com.project.finance.core.services.SpaceService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/space")
public class SpaceController {

    private final SpaceService spaceService;

    public SpaceController(SpaceService spaceService) {
        this.spaceService = spaceService;
    }

    @GetMapping("/verify")
    public void verifyDefaultUserSpace(){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        spaceService.ensureDefaultUserSpace(user);
    }
}
