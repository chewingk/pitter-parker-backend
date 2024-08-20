package com.chewingk.pitter.service.model.domain;

import lombok.*;

import java.time.Instant;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ParkingDetail {
    private int id;
    private String licensePlate;
    private Instant entryTime;
}
