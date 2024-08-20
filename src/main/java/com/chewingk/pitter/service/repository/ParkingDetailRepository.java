package com.chewingk.pitter.service.repository;

import com.chewingk.pitter.service.model.domain.ParkingDetail;

public interface ParkingDetailRepository {
    ParkingDetail enter(ParkingDetail parkingDetail);

    void exit(String licensePlate);
}
