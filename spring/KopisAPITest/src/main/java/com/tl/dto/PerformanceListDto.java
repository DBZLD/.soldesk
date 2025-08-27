package com.tl.dto;

import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import lombok.Data;

@Data
@JacksonXmlRootElement(localName = "dbs") // ��Ʈ ������Ʈ
public class PerformanceListDto {
    
    @JacksonXmlProperty(localName = "db")
    @JacksonXmlElementWrapper(useWrapping = false) // <db>���� �迭�� �������
    private List<PerformanceDto> db;
}
