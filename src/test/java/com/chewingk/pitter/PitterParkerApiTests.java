package com.chewingk.pitter;

import com.chewingk.pitter.api.dto.EnterRequestDto;
import com.chewingk.pitter.api.dto.ExitRequestDto;
import com.chewingk.pitter.infrastructure.model.persistente.ParkingDetailPo;
import com.chewingk.pitter.infrastructure.repository.jpa.ParkingDetailJpaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.time.Instant;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("test")
@ContextConfiguration
@SpringBootTest
@AutoConfigureMockMvc
class PitterParkerApiTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ParkingDetailJpaRepository parkingDetailJpaRepository;

    private ObjectMapper objectMapper;

    public PitterParkerApiTests() {
        objectMapper = new ObjectMapper();
    }

    @BeforeEach
    public void setup() {
        parkingDetailJpaRepository.deleteAll();
    }

    @Test
    public void should_get_201_and_save_entry_detail_when_enter_park_given_valid_request() throws Exception {
        EnterRequestDto requestDto = EnterRequestDto.builder()
                                       .licensePlate("粤A00001")
                                       .build();

        ResultActions resultActions = mockMvc.perform(post("/pitter-parker/enter")
                                                          .accept(MediaType.APPLICATION_JSON)
                                                          .contentType(MediaType.APPLICATION_JSON)
                                                          .content(objectMapper.writeValueAsString(requestDto)));

        List<ParkingDetailPo> parkingDetailPos = parkingDetailJpaRepository.findAll();
        ParkingDetailPo savedParkingDetailPo = parkingDetailPos.get(0);
        resultActions
            .andExpect(status().is(201))
            .andExpect(jsonPath("$.entryTime").value(savedParkingDetailPo.getEntryTime().toEpochMilli()));
        assertThat(savedParkingDetailPo.getLicensePlate()).isEqualTo("粤A00001");
    }

    @Test
    public void should_get_200_and_delete_parking_detail_when_exit_park_given_valid_request() throws Exception {
        parkingDetailJpaRepository.save(ParkingDetailPo.builder()
                                            .licensePlate("粤A00002")
                                            .entryTime(Instant.now())
                                            .build());
        ExitRequestDto exitRequestDto = ExitRequestDto.builder()
                                      .licensePlate("粤A00002")
                                      .build();

        ResultActions resultActions = mockMvc.perform(post("/pitter-parker/exit")
                                                          .accept(MediaType.APPLICATION_JSON)
                                                          .contentType(MediaType.APPLICATION_JSON)
                                                          .content(objectMapper.writeValueAsString(exitRequestDto)));

        resultActions.andExpect(status().is(200));
        assertThat(parkingDetailJpaRepository.count()).isEqualTo(0);
    }
}
