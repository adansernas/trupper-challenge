package com.trupper.challenge.mapper;

import com.trupper.challenge.dto.request.SucursalRegistroRequest;
import com.trupper.challenge.dto.response.SucursalResponse;
import com.trupper.challenge.entity.Sucursal;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SucursalMapper {

    Sucursal toEntity(SucursalRegistroRequest request);
    SucursalResponse toResponse(Sucursal sucursal);

}
