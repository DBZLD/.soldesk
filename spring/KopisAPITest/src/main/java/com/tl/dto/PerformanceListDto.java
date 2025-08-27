package com.tl.dto;

import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import lombok.Data;

@Data
@JacksonXmlRootElement(localName = "dbs") // 루트 엘리먼트
public class PerformanceListDto {
    
    @JacksonXmlProperty(localName = "db")
    @JacksonXmlElementWrapper(useWrapping = false) // <db>들이 배열로 들어있음
    private List<PerformanceDto> db;
}
