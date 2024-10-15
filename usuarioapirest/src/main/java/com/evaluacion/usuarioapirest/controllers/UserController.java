package com.evaluacion.usuarioapirest.controllers;

import com.evaluacion.usuarioapirest.dtos.LoginDTO;
import com.evaluacion.usuarioapirest.dtos.UsersDTO;
import com.evaluacion.usuarioapirest.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/users")
@Tag(name = "User Management", description = "API para la gestión de usuarios")
@Validated
public class UserController {

    @Autowired
    private UserService userService;

    @Operation(summary = "Registrar un nuevo usuario",
            description = "Registra un nuevo usuario con el nombre, correo, contraseña y teléfonos asociados.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Usuario creado con éxito",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = UsersDTO.class))),
            @ApiResponse(responseCode = "400", description = "Error en la solicitud o correo ya registrado",
                    content = @Content(mediaType = "application/json", schema = @Schema(example = "{\"mensaje\": \"mensaje de error\"}")))
    })
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody UsersDTO usersDTO) {
        try {
            UsersDTO newUser = userService.createUser(usersDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(Map.of("mensaje", e.getMessage()));
        }
    }

    @Operation(summary = "Autenticar usuario",
            description = "Autentica al usuario y devuelve un token JWT.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Autenticación exitosa",
                    content = @Content(mediaType = "application/json", schema = @Schema(example = "{\"token\": \"jwt_token\"}"))),
            @ApiResponse(responseCode = "401", description = "Credenciales inválidas",
                    content = @Content(mediaType = "application/json", schema = @Schema(example = "{\"mensaje\": \"Credenciales inválidas\"}")))
    })
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@Valid @RequestBody LoginDTO loginDTO) {
        try {
            String token = userService.login(loginDTO.getEmail(), loginDTO.getPassword());
            return ResponseEntity.ok(Map.of("token", token));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("mensaje", e.getMessage()));
        }
    }

    @Operation(summary = "Obtener usuario por ID",
            description = "Devuelve los detalles de un usuario dado su ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuario encontrado",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = UsersDTO.class))),
            @ApiResponse(responseCode = "404", description = "Usuario no encontrado",
                    content = @Content(mediaType = "application/json", schema = @Schema(example = "{\"mensaje\": \"Usuario no encontrado\"}")))
    })
    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable UUID id) {
        try {
            UsersDTO user = userService.getUserById(id);
            return ResponseEntity.ok(user);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("mensaje", e.getMessage()));
        }
    }

    @Operation(summary = "Listar todos los usuarios",
            description = "Devuelve una lista de todos los usuarios registrados.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de usuarios",
                    content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = UsersDTO.class))))
    })
    @GetMapping("/")
    public ResponseEntity<?> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @Operation(summary = "Actualizar usuario",
            description = "Actualiza los detalles de un usuario existente.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuario actualizado",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = UsersDTO.class))),
            @ApiResponse(responseCode = "404", description = "Usuario no encontrado",
                    content = @Content(mediaType = "application/json", schema = @Schema(example = "{\"mensaje\": \"Usuario no encontrado\"}")))
    })
    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable UUID id, @Valid @RequestBody UsersDTO usersDTO) {
        try {
            UsersDTO updatedUser = userService.updateUser(id, usersDTO);
            return ResponseEntity.ok(updatedUser);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("mensaje", e.getMessage()));
        }
    }

    @Operation(summary = "Eliminar usuario",
            description = "Elimina un usuario dado su ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuario eliminado",
                    content = @Content(mediaType = "application/json", schema = @Schema(example = "{\"mensaje\": \"Usuario eliminado exitosamente\"}"))),
            @ApiResponse(responseCode = "404", description = "Usuario no encontrado",
                    content = @Content(mediaType = "application/json", schema = @Schema(example = "{\"mensaje\": \"Usuario no encontrado\"}")))
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable UUID id) {
        try {
            userService.deleteUser(id);
            return ResponseEntity.ok(Map.of("mensaje", "Usuario eliminado exitosamente"));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("mensaje", e.getMessage()));
        }
    }
}