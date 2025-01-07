package com.aytugakin.spider.mapper;


import com.aytugakin.spider.entity.Operation;
import com.aytugakin.spider.service.dto.OperationDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface OperationsMapper {
    Operation convertToOperation(OperationDto operationDto);
    OperationDto convertToOperationDto(Operation operation);
}
