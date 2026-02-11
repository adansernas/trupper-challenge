package com.trupper.challenge.controller;

import com.trupper.challenge.dto.request.SucursalRegistroRequest;
import com.trupper.challenge.dto.response.SucursalResponse;
import com.trupper.challenge.service.SucursalService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(
    path = "/sucursales",
    consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE
)
public class SucursalController {

    private final SucursalService sucursalService;

    @PostMapping
    public ResponseEntity<SucursalResponse> crearSucursal(@Valid @RequestBody SucursalRegistroRequest request){
        SucursalResponse response = sucursalService.registrarSucursal(request);

        return ResponseEntity.ok(response);
    }

}
