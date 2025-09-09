package com.spring.dto.lol;

import lombok.Data;

@Data
public class MatchTimeLineDto {
    private MetadataTimeLineDto metadata;
    private InfoTimeLineDto info;
}
