package com.trupper.challenge.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class ProductoActualizacionRequest {

    @JsonProperty("id_producto")
    private Long idProducto;

    @JsonProperty("descripcion")
    @Size(min = 1, max = 200, message = "La descripcion del producto debe contener entre {min} y {max} caracteres")
    private String descripcion;

    @JsonProperty("precio")
    private BigDecimal precio;

}
