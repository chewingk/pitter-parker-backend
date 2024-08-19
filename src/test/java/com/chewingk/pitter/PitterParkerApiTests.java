package com.chewingk.pitter;

import com.chewingk.pitter.api.dto.EnterRequestDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("test")
@ContextConfiguration
@SpringBootTest
@AutoConfigureMockMvc
class PitterParkerApiTests {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper objectMapper;

    public PitterParkerApiTests() {
        objectMapper = new ObjectMapper();
    }

    @Test
    public void should_get_201_status_when_enter_park_given_valid_request() throws Exception {
        EnterRequestDto requestDto = EnterRequestDto.builder()
                                       .licensePlate("粤A00001")
                                       .build();

        mockMvc.perform(post("/pitter-parker/enter")
                            .accept(MediaType.APPLICATION_JSON)
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(requestDto)))
               .andExpect(status().is(201));
    }

}
