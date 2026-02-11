package com.trupper.challenge.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class OrdenResponse {

    @JsonProperty("id_orden")
    private Long idOrden;

    @JsonProperty("sucursal")
    private SucursalResponse sucursal;

    @JsonProperty("fecha")
    private LocalDate fecha;

    @JsonProperty("total")
    private BigDecimal total;

    @JsonProperty("productos")
    private List<ProductoResponse> productos;

}
