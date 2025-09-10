package com.spring.dto.lol;

import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
public class TimeLineFramesDto {
    private List<TimeLineEventsDto> events;
    private Map<String, TimeLineParticipantFrameDto> participantFrames;
    private int timestamp;
}