package com.evaluacion.usuarioapirest;


import com.evaluacion.usuarioapirest.dtos.UsersDTO;
import com.evaluacion.usuarioapirest.models.Users;
import com.evaluacion.usuarioapirest.repositories.UserRepository;
import com.evaluacion.usuarioapirest.services.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    public void shouldThrowErrorIfEmailExists() {
        Users existingUser = new Users();
        existingUser.setEmail("test@example.com");

        when(userRepository.findByEmail("test@example.com")).thenReturn(Optional.of(existingUser));

        UsersDTO usersDTO = new UsersDTO();
        usersDTO.setEmail("test@example.com");

        assertThrows(RuntimeException.class, () -> {
            userService.createUser(usersDTO);
        });

        verify(userRepository, times(1)).findByEmail("test@example.com");
    }
}