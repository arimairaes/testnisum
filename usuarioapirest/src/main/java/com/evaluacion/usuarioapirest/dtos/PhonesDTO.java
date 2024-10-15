package com.evaluacion.usuarioapirest.dtos;

import com.evaluacion.usuarioapirest.models.Phones;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhonesDTO  implements Serializable {

    private Long id;
    @Schema(description = "Número de teléfono", example = "1234567890")
    @NotBlank(message = "El número es obligatorio")
    @Pattern(regexp = "\\d{7,10}", message = "El número debe tener entre 7 y 10 dígitos")
    private String number;

    @Schema(description = "Código de ciudad", example = "1")
    @NotBlank(message = "El código de ciudad es obligatorio")
    @Pattern(regexp = "\\d{1,5}", message = "El código de ciudad debe ser numérico y tener hasta 5 dígitos")
    private String citycode;

    @Schema(description = "Código de país", example = "57")
    @NotBlank(message = "El código de país es obligatorio")
    @Pattern(regexp = "\\d{1,5}", message = "El código de país debe ser numérico y tener hasta 5 dígitos")
    private String contrycode;

    public PhonesDTO(Phones phone) {
        this.id = phone.getId();
        this.number = phone.getNumber();
        this.citycode = phone.getCitycode();
        this.contrycode = phone.getContrycode();
    }
}