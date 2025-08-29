package com.spring.tft;

import com.spring.dto.tft.RankDto;
import com.spring.service.TFTApiProcessor;
import com.spring.util.Common;

import lombok.extern.log4j.Log4j;

@Log4j
public class TFTPlayerRankInfo {
	public String type;		//��ũ Ÿ��
	public String tier;		//��ũ Ƽ��(���̾Ƹ��)
	public String rank;		//��ũ ��(1,2)
	public int point;		//��ũ ����(LP)
	public int win;			//�� ��
	public int lose;		//�� ��
	public String full;		//��ũ �̹���
	public String group;	//��ũ �̹��� ����
	public String imgURL;	//��ũ �̹��� ��ũ

	//rankDto, tap�� �޾ƿͼ� ����, ���� �� �����ϴ� ������ �Լ�
	public TFTPlayerRankInfo(RankDto rankDto, TFTApiProcessor tap) {
		//type�� rankDto.queueType�� �Ҵ�
		type = rankDto.queueType;
		//��ũ Ÿ���� turbo���� ���θ� �Ǵ��ؼ� isTurbo�� �Ҵ�
		boolean isTurbo = Common.TFT_TURBO.equals(type);
		//tier�� ���׿����ڷ� isTurbo�� true�϶� ratedTier��, false�϶� tier�� ���� �Ҵ� 
		tier = isTurbo ? rankDto.ratedTier : rankDto.tier;
		//tier�� ���� ��ũ �������� ���θ� �Ǵ��ؼ� isUnrated�� �Ҵ�
		boolean isUnrated = Common.UNRATED.equals(tier);
		//tier�� ���� ù ���� �빮��,�̿� ���� �ҹ��ڷ� ��ȯ
		tier = tier.substring(0, 1).toUpperCase() + tier.substring(1).toLowerCase();

		//full�� tier�� ���� key���� ��ġ�ϴ� value.image.full ���� �Ҵ�
		full = tap.regalia.tier.get(tier).image.full;
		//group�� tier�� ���� key���� ��ġ�ϴ� value.image.group ���� �Ҵ�
		group = tap.regalia.tier.get(tier).image.group;
		//tap���� ��ȯ�� �̹���URL���� imgURL�� �Ҵ�
		imgURL = tap.getRegaliaImg(full, group);
		
		//isUnrated�� false�϶��� rank, point, win, lose���� �Ҵ���
		if (!isUnrated) {
			//rank�� ���׿����ڷ� isTurbo�� true�϶� ratedRating��, false�϶� rank�� ���� �Ҵ�
			rank = isTurbo ? Integer.toString(rankDto.ratedRating) : rankDto.rank;
			//point�� ���׿����ڷ� isTurbo�� true�϶� 0��, false�϶� leaguePoints�� ���� �Ҵ�
			point = isTurbo ? 0 : rankDto.leaguePoints;
			//win�� rankDto.wins�� ���� �Ҵ�
			win = rankDto.wins;
			//lose�� rankDto.losses�� ���� �Ҵ�
			lose = rankDto.losses;
		}
		//type�� ���� tap���� �������� �Ҵ�
		type = tap.transQueueType(type);
		//tier�� ���� tap���� �������� �Ҵ�
		tier = tap.regalia.tier.get(tier).name;
		//rank�� ���� tap���� ��ȯ���� �Ҵ�
		if (rank != null) {
			rank = tap.transRankNum(rank);
		}
	}
}
