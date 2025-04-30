package com.project.finance.core.services;

import com.project.finance.core.dto.AddRegisterDTO;
import com.project.finance.core.dto.RegisterDTO;
import com.project.finance.core.exception.SpaceNotFound;
import com.project.finance.core.model.RegisterType;
import com.project.finance.core.model.Space;
import com.project.finance.core.model.User;
import com.project.finance.core.ports.repository.RegisterRepository;
import com.project.finance.core.ports.repository.SpaceRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
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
        RegisterDTO registerDTO = getRegisterDTO();

        AddRegisterDTO addRegisterDTO = new AddRegisterDTO(1L, registerDTO);
        Space space = new Space(1L, "",null, List.of());

        Mockito.when(spaceRepository.findBySpaceId(1L)).thenReturn(Optional.of(space));

        registerService.addRegister(getUser(), addRegisterDTO);

        Mockito.verify(registerRepository).addRegister(getUser().email(), 1L, registerDTO);
    }

    @Test
    public void givenAddRegisterDTO_thenThrowSpaceNotFound() {

        AddRegisterDTO addRegisterDTO = new AddRegisterDTO(1L, getRegisterDTO());

        Mockito.when(spaceRepository.findBySpaceId(1L)).thenReturn(Optional.empty());

        Assertions.assertThrows(SpaceNotFound.class, ()-> {
            registerService.addRegister(getUser(), addRegisterDTO);
        });
    }

    public RegisterDTO getRegisterDTO() {
        RegisterDTO registerDTO = new RegisterDTO("Just a test", 100L, RegisterType.INCOME, LocalDate.now());
        return registerDTO;
    }

    public User getUser() {
        User user = new User(1L, "test", "test@email.com");
        return user;
    }

}
