package com.spring.dto.lol;

import java.util.List;

import lombok.Data;

@Data
public class TimeLineInfoDto {
    private String endOfGameResult;
    private long frameInterval;
    private long gameId;
    private List<TimeLineParticipantDto> participants;
    private List<TimeLineFramesDto> frames;

}