package com.chewingk.pitter.api.service;

import com.chewingk.pitter.api.dto.EnterRequestDto;

public interface PitterParkerService {
    long enter(EnterRequestDto requestDto);
}
