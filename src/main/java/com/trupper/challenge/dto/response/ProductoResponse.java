package com.trupper.challenge.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
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
public class ProductoResponse {

    @JsonProperty("id_producto")
    private Long idProducto;

    @JsonProperty("codigo")
    private String codigo;

    @JsonProperty("descripcion")
    private String descripcion;

    @JsonProperty("precio")
    private BigDecimal precio;

}
