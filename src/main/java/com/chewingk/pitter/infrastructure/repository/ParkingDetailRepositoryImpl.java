package com.chewingk.pitter.infrastructure.repository;

import com.chewingk.pitter.infrastructure.model.mapper.PitterParkerInfraMapper;
import com.chewingk.pitter.infrastructure.model.persistente.ParkingDetailPo;
import com.chewingk.pitter.infrastructure.repository.jpa.ParkingDetailJpaRepository;
import com.chewingk.pitter.service.model.domain.ParkingDetail;
import com.chewingk.pitter.service.repository.ParkingDetailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@RequiredArgsConstructor
public class ParkingDetailRepositoryImpl implements ParkingDetailRepository {
    private final ParkingDetailJpaRepository jpaRepository;
    private final PitterParkerInfraMapper mapper = PitterParkerInfraMapper.INSTANCE;

    @Override
    public ParkingDetail enter(ParkingDetail parkingDetail) {
        ParkingDetailPo parkingDetailPo = mapper.toParkingDetailPo(parkingDetail);

        ParkingDetailPo savedParkingDetailPo = jpaRepository.save(parkingDetailPo);
        return mapper.toParkingDetail(savedParkingDetailPo);
    }

    @Override
    @Transactional
    public void exit(String licensePlate) {
        jpaRepository.deleteByLicensePlate(licensePlate);
    }
}
