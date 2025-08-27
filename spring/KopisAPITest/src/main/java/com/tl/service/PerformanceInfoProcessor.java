package com.tl.service;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.nio.charset.StandardCharsets;

import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.tl.dto.PerformanceListDto;
import com.tl.dto.PerformanceRequestDto;

import lombok.extern.log4j.Log4j;

@Log4j
public class PerformanceInfoProcessor {
	private String apiKey = "da8350e1cfc642d49f9486fb19ade562"; // kopis api key
	
	public PerformanceListDto performanceList = new PerformanceListDto(); // 공연 목록 api
	
	public PerformanceInfoProcessor(PerformanceRequestDto prd) {
		setPerformanceList(prd);
	}

	public void setPerformanceList(PerformanceRequestDto prd) {
		String API_URL = String.format( // prd 내의 변수들 모두 적용해서 api url 생성
			    "http://kopis.or.kr/openApi/restful/pblprfr?service=%s&stdate=%s&eddate=%s&cpage=%s&"
			    + "rows=%s&shprfnm=%s&shprfnmfct=%s&shcate=%s&prfplccd=%s&"
			    + "signgucode=%s&signgucodesub=%s&kidstate=%s&prfstate=%s&openrun=%s&afterdate=%s",
			    apiKey, prd.startdate, prd.enddate, prd.cpage, prd.rows,
			    prd.shprfnm, prd.shprfnmfct, prd.shcate, prd.prfplccd, prd.signgucode, 
			    prd.signgucodesub, prd.kidstate, prd.prfstate, prd.openrun, prd.afterdate);

	    RestTemplate restTemplate = new RestTemplate();
	    //한글 깨짐 방지를 위한 UTF-8 교체
	    restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(StandardCharsets.UTF_8));

	    try {
	        String xmlResponse = restTemplate.getForObject(API_URL, String.class);
	        //데이터가 XML데이터기 때문에 xmlmapper 사용
	        XmlMapper xmlMapper = new XmlMapper();
	        performanceList = xmlMapper.readValue(xmlResponse, PerformanceListDto.class);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}
