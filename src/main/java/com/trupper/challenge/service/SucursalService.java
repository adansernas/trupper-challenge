package com.trupper.challenge.service;

import com.trupper.challenge.dto.request.SucursalRegistroRequest;
import com.trupper.challenge.dto.response.SucursalResponse;
import com.trupper.challenge.entity.Sucursal;
import com.trupper.challenge.mapper.SucursalMapper;
import com.trupper.challenge.repository.SucursalRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class SucursalService {

    private final SucursalRepository sucursalRepository;
    private final SucursalMapper sucursalMapper;

    @Transactional
    public SucursalResponse registrarSucursal(SucursalRegistroRequest request) {
        Sucursal entity = sucursalMapper.toEntity(request);

        entity = sucursalRepository.save(entity);

        return sucursalMapper.toResponse(entity);
    }

}
