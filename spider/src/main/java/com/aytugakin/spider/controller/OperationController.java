package com.aytugakin.spider.controller;


import com.aytugakin.spider.controller.dto.OperationRequest;
import com.aytugakin.spider.controller.dto.OperationResponse;
import com.aytugakin.spider.service.OperationService;
import com.aytugakin.spider.service.dto.OperationDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/operation")
public class OperationController {

    private final OperationService operationService;

    @PostMapping("/addOperation")
    public ResponseEntity<OperationDto> addOperation(@RequestBody OperationRequest operationRequest) {
        return ResponseEntity.ok(operationService.addOperation(operationRequest));
    }

    @GetMapping("/{operationCode}")
    public ResponseEntity<OperationResponse> getOperationByOperationCode(@PathVariable String operationCode){
        return ResponseEntity.ok(operationService.getOperationByOperationCode(operationCode));
    }

}
