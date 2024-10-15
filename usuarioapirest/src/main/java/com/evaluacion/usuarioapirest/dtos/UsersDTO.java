package com.evaluacion.usuarioapirest.dtos;



import com.evaluacion.usuarioapirest.annotations.ValidPassword;
import com.evaluacion.usuarioapirest.models.Phones;
import com.evaluacion.usuarioapirest.models.Users;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsersDTO implements Serializable {
    @Schema(description = "ID del usuario", example = "e5e5d2f0-8459-4f93-b5d1-b90d0456f936")
    private UUID id;

    @Schema(description = "Nombre completo del usuario", example = "Juan Rodriguez")
    @NotBlank(message = "El nombre es obligatorio")
    private String name;

    @Schema(description = "Correo electrónico del usuario", example = "juan@rodriguez.org")
    @Email(message = "El formato del correo es incorrecto")
    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$", message = "El correo debe seguir un formato válido")
    @NotBlank(message = "El correo es obligatorio")
    private String email;

    @Schema(description = "Contraseña del usuario", example = "hunter2")
    @NotBlank(message = "La contraseña es obligatoria")
    @ValidPassword
    private String password;

    @Schema(description = "Indica si el usuario está activo", example = "true")
    private boolean isActive;

    @Schema(description = "Fecha de creación del usuario", example = "2024-01-01")
    private LocalDateTime created;

    @Schema(description = "Fecha de la última modificación", example = "2024-01-10")
    private LocalDateTime modified;

    @Schema(description = "Último ingreso del usuario", example = "2024-01-15")
    private LocalDateTime lastLogin;

    @Schema(description = "Token de acceso del usuario", example = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...")
    private String token;

    @Schema(description = "Lista de teléfonos asociados al usuario")
    private List<PhonesDTO> phones;
    public UsersDTO(Users user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.isActive = user.isActive();
        this.created = user.getCreated();
        this.modified = user.getModified();
        this.lastLogin = user.getLastLogin();
        this.token = user.getToken();

        this.phones = Optional.ofNullable(
                        user
                                .getPhones())
                .map(list ->
                        list
                                .stream()
                                .map(PhonesDTO::new)
                                .collect(Collectors.toList()))
                .orElse(null);
    }
}
