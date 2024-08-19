package com.chewingk.pitter.api.impl;

import com.chewingk.pitter.api.dto.EnterRequestDto;
import com.chewingk.pitter.api.service.PitterParkerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pitter-parker")
public class PitterParkerController {

    private final PitterParkerService pitterParkerService;

    @PostMapping("/enter")
    @ResponseStatus(HttpStatus.CREATED)
    public void enterPitter(@RequestBody EnterRequestDto requestDto) {
        pitterParkerService.enter(requestDto);
    }


}
