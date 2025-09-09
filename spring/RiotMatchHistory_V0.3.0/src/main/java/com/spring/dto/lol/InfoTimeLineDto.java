package com.spring.dto.lol;

import java.util.List;

import lombok.Data;

@Data
class InfoTimeLineDto {
    private String endOfGameResult;
    private long frameInterval;
    private long gameId;
    private List<ParticipantTimeLineDto> participants;
    private List<FramesTimeLineDto> frames;

}