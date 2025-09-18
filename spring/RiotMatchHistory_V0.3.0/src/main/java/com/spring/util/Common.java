package com.spring.util;

public class Common {
	//상수를 모아놓은 클래스
	public static final String API_KEY = "RGAPI-8a2ebf4b-3fe3-4ddf-95a5-4e767be6bc24"; //라이엇 API 키(API 접속 시 필요)
	public static final String REGIONS = "ko_KR";						//지역(API 접속 시 필요)
	
	public static final Integer MATCH_COUNT = 10;						//API로 가져올 매치 수
	
	public static final String UNITS_URL = "tft-champion";				//이미지URL 종류(유닛)
	public static final String ITEMS_URL = "tft-item";					//이미지URL 종류(아이템)
	public static final String QUEUES_URL = "tft-queues";				//이미지URL 종류(매치 타입)
	public static final String REGALIA_URL = "tft-regalia";				//이미지URL 종류(티어)
	public static final String TACTICIANS_URL = "tft-tactician";		//이미지URL 종류(전설이)
	public static final String TRAITS_URL = "tft-trait";				//이미지URL 종류(특성)
	
	public static final String TFT_RANK = "RANKED_TFT";					//랭크 종류(랭크)
	public static final String TFT_DOUBLE_UP = "RANKED_TFT_DOUBLE_UP";	//랭크 종류(더블 업)
	public static final String TFT_TURBO = "RANKED_TFT_TURBO";			//랭크 종류(초고속 모드)
	public static final String UNRATED = "PROVISIONAL";					//타어 종류(랭크 없음)
	
	public static final String SET15_START = "1753801200";				//TFT 시즌 15 시작 시간	
}
