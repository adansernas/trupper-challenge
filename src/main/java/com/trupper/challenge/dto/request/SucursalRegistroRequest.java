package com.trupper.challenge.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class SucursalRegistroRequest {

    @JsonProperty("nombre")
    @Size(min = 1, max = 50, message = "El nombre de la sucursal debe contener entre {min} y {max} caracteres")
    private String nombre;

}
