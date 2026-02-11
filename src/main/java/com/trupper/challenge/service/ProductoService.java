package com.trupper.challenge.service;

import com.trupper.challenge.dto.request.ProductoActualizacionRequest;
import com.trupper.challenge.dto.response.ProductoResponse;
import com.trupper.challenge.entity.Producto;
import com.trupper.challenge.exception.ResourceNotFoundException;
import com.trupper.challenge.mapper.ProductoMapper;
import com.trupper.challenge.repository.ProductoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductoService {

    private final ProductoRepository productoRepository;
    private final ProductoMapper productoMapper;

    @Transactional
    public ProductoResponse updateProducto(ProductoActualizacionRequest request){
        Producto producto = productoRepository.findById(request.getIdProducto())
                .orElseThrow(() -> {
                    throw new ResourceNotFoundException("Producto no encontrado");
                });

        productoMapper.updateEntity(producto, request);

        producto = productoRepository.save(producto);

        return productoMapper.toResponse(producto);
    }

}
