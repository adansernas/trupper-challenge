package com.trupper.challenge.mapper;

import com.trupper.challenge.dto.request.ProductoActualizacionRequest;
import com.trupper.challenge.dto.response.ProductoResponse;
import com.trupper.challenge.entity.Producto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProductoMapper {

    ProductoResponse toResponse(Producto producto);
    Producto updateEntity(@MappingTarget Producto producto, ProductoActualizacionRequest request);


}
