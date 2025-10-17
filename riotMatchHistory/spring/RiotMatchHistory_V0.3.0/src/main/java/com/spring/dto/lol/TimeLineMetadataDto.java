package com.spring.dto.lol;

import java.util.List;

import lombok.Data;

@Data
public class TimeLineMetadataDto {
    private String dataVersion;
    private String matchId;
    private List<String> participants;
}
