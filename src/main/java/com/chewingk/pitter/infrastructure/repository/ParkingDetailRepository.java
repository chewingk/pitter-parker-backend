package com.chewingk.pitter.infrastructure.repository;

import com.chewingk.pitter.infrastructure.model.mapper.PitterParkerInfraMapper;
import com.chewingk.pitter.infrastructure.model.persistente.ParkingDetailPo;
import com.chewingk.pitter.infrastructure.repository.jpa.ParkingDetailJpaRepository;
import com.chewingk.pitter.service.model.domain.ParkingDetail;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ParkingDetailRepository {
    private final ParkingDetailJpaRepository jpaRepository;
    private final PitterParkerInfraMapper mapper = PitterParkerInfraMapper.INSTANCE;

    public ParkingDetail save(ParkingDetail parkingDetail) {
        ParkingDetailPo parkingDetailPo = mapper.toParkingDetailPo(parkingDetail);

        ParkingDetailPo savedParkingDetailPo = jpaRepository.save(parkingDetailPo);
        return mapper.toParkingDetail(savedParkingDetailPo);
    }
}
