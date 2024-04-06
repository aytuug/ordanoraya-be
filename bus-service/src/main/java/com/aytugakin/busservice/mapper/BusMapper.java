package com.aytugakin.busservice.mapper;

import com.aytugakin.busservice.controller.dto.TravelBusResponse;
import com.aytugakin.busservice.entity.Bus;
import com.aytugakin.busservice.service.dto.BusDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface BusMapper {
    List<BusDto> convertToDto(List<Bus> buses);
    BusDto convertToOptionalDto(Bus bus);
    TravelBusResponse convertToTravelResponse(BusDto busDto);
}
