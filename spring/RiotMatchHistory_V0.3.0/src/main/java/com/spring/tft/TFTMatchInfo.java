package com.spring.tft;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.spring.dto.tft.MatchDto;
import com.spring.dto.tft.Participant;
import com.spring.service.TFTApiProcessor;

public class TFTMatchInfo {
	public String gameVersion;			//���� ����
	public String matchId;				//��ġ ���̵�
	public String gameDatetime;			//���� ����
	public String gamePassedtime;		//���� ����ð�
	public String queueType;			//ť Ÿ��
	public Integer myIndex;				//�÷��̾�(���� ����) �ε���
	public ArrayList<TFTMatchPlayerInfo> playerInfos = new ArrayList<>(); //��ġ�� �÷��̾� ����
	
	//matchDto, myPuuid�� �޾ƿͼ� ����, ������ �� �����ϴ� ������ �Լ�
	public TFTMatchInfo(MatchDto matchDto, String myPuuid) {
		//'Version N.N' ���¸� ã�� ���� ���Խ� pattern ����
		Pattern pattern = Pattern.compile("Version (\\d+\\.\\d+)");
		//matchDto.info.game_version���� pattern�� ��ġ�ϴ� �κ��� ã������ Matcher ����
		Matcher matcher = pattern.matcher(matchDto.info.game_version);
		//��ġ�ϴ� �κ� �ڿ� '.1'�� �ٿ� gameVersion�� �Ҵ�
		if(matcher.find()) {
			gameVersion = matcher.group(1) + ".1";
		}
		//�� �������� TFTApiProcessor ����
		TFTApiProcessor tap = new TFTApiProcessor(gameVersion);
		
		//matchId�� matchDto.metadata.match_id �Ҵ�
		matchId = matchDto.metadata.match_id;
		//gameDatetime�� tap���� ��ȯ�� gameDatetime �Ҵ�
		gameDatetime = tap.transGameDatetime(matchDto.info.game_datetime);
		//gamePassedtime�� tap���� ��ȯ�� gamePassedtime �Ҵ�
		gamePassedtime = tap.transGamePassedtime(matchDto.info.game_datetime);
		//queueType�� tap���� ��ȯ�� queueType �Ҵ�
		queueType = tap.transQueueType(matchDto.info.queue_id);

		//matchDto.info.participants�� ��� ���鼭 participant ����
		for (Participant part : matchDto.info.participants) {
			//������ participant�� queueType, tap�� �Ű��������� TFTMatchPlayerInfo�� playerInfos�� �߰�
			playerInfos.add(new TFTMatchPlayerInfo(part, queueType, tap));
		}
		//playerInfos�� ���� �� ��� ������ ����
		playerInfos.sort(Comparator.comparingInt(pIfno -> pIfno.placement));
		for(int i = 0; i < playerInfos.size(); i++) {
			//�÷��̾��� index�� myIndex�� �Ҵ�
			if(playerInfos.get(i).playerPuuid.equals(myPuuid)) {
				myIndex = i;
				break;
			}
		}
	}
}
