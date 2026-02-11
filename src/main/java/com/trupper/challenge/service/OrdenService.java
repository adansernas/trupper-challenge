package com.trupper.challenge.service;

import com.trupper.challenge.dto.request.OrdenRegistroRequest;
import com.trupper.challenge.dto.response.OrdenResponse;
import com.trupper.challenge.entity.Orden;
import com.trupper.challenge.entity.Producto;
import com.trupper.challenge.exception.ResourceNotFoundException;
import com.trupper.challenge.mapper.OrdenMapper;
import com.trupper.challenge.repository.OrdenRepository;
import com.trupper.challenge.repository.ProductoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrdenService {

    private final OrdenRepository ordenRepository;
    private final ProductoRepository productoRepository;
    private final OrdenMapper ordenMapper;

    @Transactional
    public OrdenResponse registrarOrden(OrdenRegistroRequest request) {
        Orden entity = ordenMapper.toEntity(request);

        entity = ordenRepository.save(entity);

        for(Producto producto : entity.getProductos()) {
            producto.setOrden(entity);

            productoRepository.save(producto);
        }

        OrdenResponse response = ordenMapper.toResponse(entity);

        return response;
    }

    @Transactional(readOnly = true)
    public OrdenResponse foundById(Long idOrden){
        Orden entity = ordenRepository.findById(idOrden)
                .orElseThrow(() -> {
                    throw new ResourceNotFoundException("Orden no encontrada");
                });

        return ordenMapper.toResponse(entity);
    }

}
