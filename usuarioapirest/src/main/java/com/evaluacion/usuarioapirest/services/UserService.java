package com.evaluacion.usuarioapirest.services;


import com.evaluacion.usuarioapirest.models.Phones;
import com.evaluacion.usuarioapirest.utils.JwtUtil;
import com.evaluacion.usuarioapirest.dtos.UsersDTO;
import com.evaluacion.usuarioapirest.models.Users;
import com.evaluacion.usuarioapirest.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public UsersDTO createUser(UsersDTO usersDTO) {
        Optional<Users> existingUser = userRepository.findByEmail(usersDTO.getEmail());
        if (existingUser.isPresent()) {
            throw new RuntimeException("Este correo ya se encuentra registrado");
        }

        Users newUser = new Users();
        newUser.setName(usersDTO.getName());
        newUser.setEmail(usersDTO.getEmail());
        newUser.setActive(true);
        newUser.setCreated(LocalDateTime.now());
        newUser.setModified(LocalDateTime.now());
        newUser.setLastLogin(LocalDateTime.now());
        newUser.setPassword(passwordEncoder.encode(usersDTO.getPassword()));
        newUser.setToken(jwtUtil.generateToken(usersDTO.getEmail()));
        newUser.setPhones(Optional.ofNullable(
                        usersDTO
                                .getPhones())
                .map(list ->
                        list
                                .stream()
                                .map(Phones::new)
                                .collect(Collectors.toList()))
                .orElse(null));

        Users savedUser = userRepository.save(newUser);
        return new UsersDTO(savedUser);
    }

    public String login(String email, String password) {
        Users user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Credenciales inválidas"));

        if (passwordEncoder.matches(password, user.getPassword())&&user.isActive()) {
            user.setLastLogin(LocalDateTime.now());
            userRepository.save(user);
            return user.getToken();
        } else {
            throw new RuntimeException("Credenciales inválidas");
        }
    }

    public UsersDTO getUserById(UUID id) {
        return new UsersDTO(userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado")));
    }

    public List<UsersDTO> getAllUsers() {
        return userRepository.findAll().stream().map(UsersDTO::new).collect(Collectors.toList());
    }

    public UsersDTO updateUser(UUID id, UsersDTO usersDTO) {
        Users user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        user.setName(usersDTO.getName());
        user.setEmail(usersDTO.getEmail());
        if (usersDTO.getPassword() != null) {
            user.setPassword(passwordEncoder.encode(usersDTO.getPassword()));
        }
        user.setModified(LocalDateTime.now());
        if (usersDTO.getPhones() != null) {
            user.getPhones().clear();
            List<Phones> phones = usersDTO.getPhones().stream().map(Phones::new).collect(Collectors.toList());
            user.setPhones(phones);
        }

        Users updatedUser = userRepository.save(user);
        return new UsersDTO(updatedUser);
    }

    public void deleteUser(UUID id) {
        Users user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        user.setActive(false);
        userRepository.save(user);
    }

}