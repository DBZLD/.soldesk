package com.spring.dto.lol;

import lombok.Data;

@Data
class EventsTimeLineDto {
    private long timestamp;
    private long realTimestamp;
    private String type;
}