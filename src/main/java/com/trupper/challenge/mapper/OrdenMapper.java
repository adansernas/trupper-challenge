package com.trupper.challenge.mapper;

import com.trupper.challenge.dto.request.OrdenRegistroRequest;
import com.trupper.challenge.dto.response.OrdenResponse;
import com.trupper.challenge.entity.Orden;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrdenMapper {

    Orden toEntity(OrdenRegistroRequest ordenRegistroRequest);
    OrdenResponse toResponse(Orden orden);

}
