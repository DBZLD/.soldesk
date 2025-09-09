package com.spring.dto.lol;

import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
class FramesTimeLineDto {
    private List<EventsTimeLineDto> events;
    private Map<String, ParticipantFrameDto> participantFrames;
    private int timestamp;
}