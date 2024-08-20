package com.chewingk.pitter.service.impl;

import com.chewingk.pitter.api.dto.EnterRequestDto;
import com.chewingk.pitter.api.service.PitterParkerService;
import com.chewingk.pitter.infrastructure.repository.ParkingDetailRepository;
import com.chewingk.pitter.service.model.domain.ParkingDetail;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class PitterParkerServiceImpl implements PitterParkerService {

    private final ParkingDetailRepository parkingDetailRepository;

    @Override
    public long enter(EnterRequestDto requestDto) {
        // record plate
        // current time
        ParkingDetail parkingDetail = ParkingDetail.builder()
                                  .licensePlate(requestDto.getLicensePlate())
                                  .entryTime(Instant.now())
                                  .build();
        // save to db
        ParkingDetail savedParkingDetail = parkingDetailRepository.save(parkingDetail);
        // return
        return savedParkingDetail.getEntryTime().toEpochMilli();
    }
}
