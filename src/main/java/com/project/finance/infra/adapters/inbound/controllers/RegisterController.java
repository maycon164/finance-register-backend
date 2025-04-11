package com.project.finance.infra.adapters.inbound.controllers;

import com.project.finance.core.dto.AddRegisterDTO;
import com.project.finance.core.dto.GetRegistersDTO;
import com.project.finance.core.model.Register;
import com.project.finance.core.model.User;
import com.project.finance.core.services.RegisterService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registers")
public class RegisterController {

    private final RegisterService registerService;

    public RegisterController(RegisterService registerService) {
        this.registerService = registerService;
    }

    @GetMapping
    public List<Register> getRegisters(@ModelAttribute GetRegistersDTO getRegistersDTO) {
        System.out.println(getRegistersDTO);
        return registerService.getRegisters(getRegistersDTO);
    }

    @PostMapping
    public void addRegister(@RequestBody AddRegisterDTO addRegisterDTO) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        registerService.addRegister(user, addRegisterDTO);
    }
}
