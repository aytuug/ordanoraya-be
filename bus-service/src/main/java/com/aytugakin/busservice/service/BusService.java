package com.aytugakin.busservice.service;

import com.aytugakin.busservice.controller.dto.AddBusRequest;
import com.aytugakin.busservice.controller.dto.TravelBusRequest;
import com.aytugakin.busservice.controller.dto.TravelBusResponse;
import com.aytugakin.busservice.entity.Bus;
import com.aytugakin.busservice.exception.ResourceNotFoundException;
import com.aytugakin.busservice.mapper.BusMapper;
import com.aytugakin.busservice.repository.BusRepository;
import com.aytugakin.busservice.service.dto.BusDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BusService {

    private final BusRepository busRepository;
    private final BusMapper busMapper;

    public String scrapingBusData(AddBusRequest addBusRequest) {
        List<Bus> updatedBuses = new ArrayList<>();

        for (BusDto busDto : addBusRequest.busDtoList()) {
            Optional<Bus> optionalBus = busRepository.findByCompanyAndDestinationCodeAndOriginCode(
                    busDto.company(), busDto.destinationCode(), busDto.originCode());

            if (optionalBus.isPresent()) {
                Bus existingBus = optionalBus.get();
                existingBus.setPrice(busDto.price());
                updatedBuses.add(busRepository.save(existingBus));
            } else {
                Bus newBus = Bus.builder()
                        .company(busDto.company())
                        .destination(busDto.destination())
                        .destinationCode(busDto.destinationCode())
                        .origin(busDto.origin())
                        .originCode(busDto.originCode())
                        .price(busDto.price())
                        .build();
                updatedBuses.add(busRepository.save(newBus));
            }
        }

        List<BusDto> updatedBusDtos = busMapper.convertToDto(updatedBuses);
        return String.format("Güncellenen otobüs sayısı: %d", updatedBusDtos.size());
    }

    public TravelBusResponse getCheapestBus(TravelBusRequest travelBusRequest) {
        Bus bus = busRepository.findFirstByDestinationCodeAndOriginCodeOrderByPriceAsc(travelBusRequest.destinationCode()
                , travelBusRequest.originCode());
        if (Objects.nonNull(bus)) {
            BusDto busDto = busMapper.convertToOptionalDto(bus);
            return busMapper.convertToTravelResponse(busDto);
        } else {
            throw new ResourceNotFoundException("Bus not found");
        }
    }
}
