package com.project.finance.infra.adapters.inbound.controllers;

import com.project.finance.core.dto.LoginDTO;
import com.project.finance.core.dto.TokenDTO;
import com.project.finance.core.services.AuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping("/hello")
    public String hello() {
        return "bye, world";
    }

    @PostMapping("/login")
    public TokenDTO makeLogin(@RequestBody LoginDTO loginDTO) {
        return authService.login(loginDTO);
    }

}
