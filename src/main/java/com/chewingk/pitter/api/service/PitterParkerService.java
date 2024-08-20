package com.chewingk.pitter.api.service;

import com.chewingk.pitter.api.dto.EnterRequestDto;
import com.chewingk.pitter.api.dto.ExitRequestDto;

public interface PitterParkerService {
    long enter(EnterRequestDto requestDto);

    void exit(ExitRequestDto requestDto);
}
