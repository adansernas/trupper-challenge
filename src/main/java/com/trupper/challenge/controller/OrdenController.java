package com.trupper.challenge.controller;

import com.trupper.challenge.dto.request.OrdenRegistroRequest;
import com.trupper.challenge.dto.request.ProductoActualizacionRequest;
import com.trupper.challenge.dto.response.OrdenResponse;
import com.trupper.challenge.dto.response.ProductoResponse;
import com.trupper.challenge.service.OrdenService;
import com.trupper.challenge.service.ProductoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(
    path = "/ordenes",
    consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE
)
public class OrdenController {

    private final OrdenService ordenService;
    private final ProductoService productoService;

    @PostMapping
    public ResponseEntity<OrdenResponse> createOrden(@Valid @RequestBody OrdenRegistroRequest request) {
        OrdenResponse response = ordenService.registrarOrden(request);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{idOrden}")
    public ResponseEntity<OrdenResponse> getOrden(@PathVariable Long idOrden) {
        OrdenResponse response = ordenService.foundById(idOrden);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping("/producto/{idProducto}")
    public ResponseEntity<ProductoResponse> updateProducto(@PathVariable Long idProducto,
                                                        @Valid @RequestBody ProductoActualizacionRequest request) {
        ProductoResponse response = productoService.updateProducto(request);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }


}
