package com.spring.dto.lol;

import lombok.Data;

@Data
public class MatchTimeLineDto {
    private TimeLineMetadataDto metadata;
    private TimeLineInfoDto info;
}
