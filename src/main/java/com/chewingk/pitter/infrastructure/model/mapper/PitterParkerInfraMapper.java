package com.chewingk.pitter.infrastructure.model.mapper;

import com.chewingk.pitter.infrastructure.model.persistente.ParkingDetailPo;
import com.chewingk.pitter.service.model.domain.ParkingDetail;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PitterParkerInfraMapper {
    PitterParkerInfraMapper INSTANCE = Mappers.getMapper(PitterParkerInfraMapper.class);

    public ParkingDetailPo toParkingDetailPo(ParkingDetail parkingDetail);

    public ParkingDetail toParkingDetail(ParkingDetailPo savedParkingDetailPo);
}
