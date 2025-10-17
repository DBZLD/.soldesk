package com.spring.tft;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.spring.dto.tft.MatchDto;
import com.spring.dto.tft.Participant;
import com.spring.service.TFTApiProcessor;

public class TFTMatchInfo {
	public String gameVersion;			//게임 버전
	public String matchId;				//매치 아이디
	public String gameDatetime;			//게임 일자
	public String gamePassedtime;		//게임 경과시간
	public String queueType;			//큐 타입
	public Integer myIndex;				//플레이어(전적 주인) 인덱스
	public ArrayList<TFTMatchPlayerInfo> playerInfos = new ArrayList<>(); //매치의 플레이어 정보
	
	//matchDto, myPuuid를 받아와서 번역, 정리한 후 저장하는 생성자 함수
	public TFTMatchInfo(MatchDto matchDto, String myPuuid) {
		//'Version N.N' 형태를 찾기 위한 정규식 pattern 정의
		Pattern pattern = Pattern.compile("Version (\\d+\\.\\d+)");
		//matchDto.info.game_version에서 pattern과 일치하는 부분을 찾기위해 Matcher 생성
		Matcher matcher = pattern.matcher(matchDto.info.game_version);
		//일치하는 부분 뒤에 '.1'을 붙여 gameVersion에 할당
		if(matcher.find()) {
			gameVersion = matcher.group(1) + ".1";
		}
		//얻어낸 버전으로 TFTApiProcessor 생성
		TFTApiProcessor tap = new TFTApiProcessor(gameVersion);
		
		//matchId에 matchDto.metadata.match_id 할당
		matchId = matchDto.metadata.match_id;
		//gameDatetime에 tap에서 변환한 gameDatetime 할당
		gameDatetime = tap.transGameDatetime(matchDto.info.game_datetime);
		//gamePassedtime에 tap에서 변환한 gamePassedtime 할당
		gamePassedtime = tap.transGamePassedtime(matchDto.info.game_datetime);
		//queueType에 tap에서 변환한 queueType 할당
		queueType = tap.transQueueType(matchDto.info.queue_id);

		//matchDto.info.participants를 모두 돌면서 participant 추출
		for (Participant part : matchDto.info.participants) {
			//추출한 participant와 queueType, tap을 매개변수로한 TFTMatchPlayerInfo를 playerInfos에 추가
			playerInfos.add(new TFTMatchPlayerInfo(part, queueType, tap));
		}
		//playerInfos를 게임 내 등수 순으로 정렬
		playerInfos.sort(Comparator.comparingInt(pIfno -> pIfno.placement));
		for(int i = 0; i < playerInfos.size(); i++) {
			//플레이어의 index를 myIndex에 할당
			if(playerInfos.get(i).playerPuuid.equals(myPuuid)) {
				myIndex = i;
				break;
			}
		}
	}
}
