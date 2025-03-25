package com.project.finance.core.services;

import com.project.finance.core.dto.AddRegisterDTO;
import com.project.finance.core.dto.RegisterDTO;
import com.project.finance.core.exception.SpaceNotFound;
import com.project.finance.core.model.RegisterType;
import com.project.finance.core.model.Space;
import com.project.finance.core.ports.repository.RegisterRepository;
import com.project.finance.core.ports.repository.SpaceRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

public class RegisterServiceTest {

    RegisterService registerService;

    @Mock
    RegisterRepository registerRepository;

    @Mock
    SpaceRepository spaceRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        registerService = new RegisterService(registerRepository, spaceRepository);
    }

    @Test
    public void givenAddRegisterDTO_thenAdd() {
        RegisterDTO registerDTO = new RegisterDTO(100L, RegisterType.INCOME);
        AddRegisterDTO addRegisterDTO = new AddRegisterDTO(1L, registerDTO);
        Space space = new Space(1L, null, List.of());

        Mockito.when(spaceRepository.getSpaceById(1L)).thenReturn(Optional.of(space));

        registerService.addRegister(addRegisterDTO);

        Mockito.verify(registerRepository).addRegister(1L, registerDTO);
    }

    @Test
    public void givenAddRegisterDTO_thenThrowSpaceNotFound() {
        RegisterDTO registerDTO = new RegisterDTO(100L, RegisterType.INCOME);
        AddRegisterDTO addRegisterDTO = new AddRegisterDTO(1L, registerDTO);

        Mockito.when(spaceRepository.getSpaceById(1L)).thenReturn(Optional.empty());

        Assertions.assertThrows(SpaceNotFound.class, () -> {
            registerService.addRegister(addRegisterDTO);
        });
    }

}
