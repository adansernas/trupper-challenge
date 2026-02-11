package com.trupper.challenge.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
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
public class SucursalResponse {

    @JsonProperty("id_sucursal")
    private Long idSucursal;

    @JsonProperty("nombre")
    private String nombre;
}
