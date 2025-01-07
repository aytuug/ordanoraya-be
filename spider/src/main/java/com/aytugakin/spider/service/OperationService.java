package com.aytugakin.spider.service;

import com.aytugakin.spider.controller.dto.OperationRequest;
import com.aytugakin.spider.controller.dto.OperationResponse;
import com.aytugakin.spider.entity.Operation;
import com.aytugakin.spider.mapper.OperationsMapper;
import com.aytugakin.spider.repository.OperationRepository;
import com.aytugakin.spider.service.dto.OperationDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OperationService {

    private final OperationRepository operationRepository;
    private final OperationsMapper operationsMapper;

    public OperationDto addOperation(OperationRequest operationRequest) {
        Operation operation = operationsMapper.convertToOperation(OperationDto.builder()
                .operationCode(operationRequest.operationCode())
                .callSystem(operationRequest.description()).build());
        operationRepository.save(operation);
        return operationsMapper.convertToOperationDto(operation);
    }

    public OperationResponse getOperationByOperationCode(String operationCode) {
        return operationRepository.findByOperationCode(operationCode)
                .map(operation -> new OperationResponse(1, "Operation found!"))
                .orElse(new OperationResponse(0, "Operation not found!"));
    }
}
