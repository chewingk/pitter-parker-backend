package com.chewingk.pitter.api.dto;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExitRequestDto {
    private String licensePlate;
}
