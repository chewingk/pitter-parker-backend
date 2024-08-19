package com.chewingk.pitter.service.impl;

import com.chewingk.pitter.api.dto.EnterRequestDto;
import com.chewingk.pitter.api.service.PitterParkerService;
import org.springframework.stereotype.Service;

@Service
public class PitterParkerServiceImpl implements PitterParkerService {
    @Override
    public void enter(EnterRequestDto requestDto) {
        // record plate
        // current time
        // save to db
        // return
    }
}
