package com.project.finance.infra.adapters.inbound.controllers;

import com.project.finance.core.dto.GetRegistersDTO;
import com.project.finance.core.model.Register;
import com.project.finance.core.services.RegisterService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
