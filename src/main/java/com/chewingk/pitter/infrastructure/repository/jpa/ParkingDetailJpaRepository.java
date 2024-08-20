package com.chewingk.pitter.infrastructure.repository.jpa;

import com.chewingk.pitter.infrastructure.model.persistente.ParkingDetailPo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingDetailJpaRepository extends JpaRepository<ParkingDetailPo, Integer> {

    void deleteByLicensePlate(String licensePlate);
}
