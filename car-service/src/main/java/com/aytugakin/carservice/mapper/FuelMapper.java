package com.aytugakin.carservice.mapper;

import com.aytugakin.carservice.entity.Fuel;
import com.aytugakin.carservice.service.dto.FuelDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface FuelMapper {
    List<FuelDto> convertToDto(List<Fuel> buses);
}
