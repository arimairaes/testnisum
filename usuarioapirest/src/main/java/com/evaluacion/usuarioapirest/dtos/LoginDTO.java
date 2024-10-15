package com.evaluacion.usuarioapirest.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginDTO {

    @Schema(description = "Correo electrónico", example = "juan@rodriguez.org")
    @NotBlank(message = "El correo es obligatorio")
    @Email(message = "El correo no tiene un formato válido")
    private String email;

    @Schema(description = "Contraseña del usuario", example = "Hunter2!")
    @NotBlank(message = "La contraseña es obligatoria")
    private String password;
}
