package com.project.finance.core.services;

import com.project.finance.core.dto.AddRegisterDTO;
import com.project.finance.core.dto.RegisterDTO;
import com.project.finance.core.model.RegisterType;
import com.project.finance.core.ports.repository.RegisterRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class RegisterServiceTest {

    RegisterService registerService;

    @Mock
    RegisterRepository registerRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        registerService = new RegisterService(registerRepository);
    }

    @Test
    public void givenAddRegisterDTO_thenAdd() {
        RegisterDTO registerDTO = new RegisterDTO(100L, RegisterType.INCOME);
        AddRegisterDTO addRegisterDTO = new AddRegisterDTO(1L, registerDTO);

        registerService.addRegister(addRegisterDTO);

        Mockito.verify(registerRepository).addRegister(1L, registerDTO);
    }

}
