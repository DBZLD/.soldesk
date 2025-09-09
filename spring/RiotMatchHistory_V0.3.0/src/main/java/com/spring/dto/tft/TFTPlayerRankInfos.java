package com.spring.dto.tft;

import com.spring.service.TFTApiProcessor;

public class TFTPlayerRankInfos {
	public TFTPlayerRankInfo rank;		//��ũ ����
	public TFTPlayerRankInfo doubleUp;	//���� �� ����
	public TFTPlayerRankInfo turbo;		//�ʰ�� ��� ����
	
	//rank, doubleUp, turbo, tap�� �޾ƿͼ� ����, ���� �� �����ϴ� ������ �Լ�
	public TFTPlayerRankInfos(TFTRankDto rank, TFTRankDto doubleUp, TFTRankDto turbo, TFTApiProcessor tap) {
		//rank�� ���� rank, tap���� ���� TFTPlayerRankInfo�� �Ҵ�
		this.rank = new TFTPlayerRankInfo(rank, tap);
		//doubleUp�� ���� doubleUp, tap���� ���� TFTPlayerRankInfo�� �Ҵ�
		this.doubleUp = new TFTPlayerRankInfo(doubleUp, tap);
		//turbo�� ���� turbo, tap���� ���� TFTPlayerRankInfo�� �Ҵ�
		this.turbo = new TFTPlayerRankInfo(turbo, tap);
	}
	
	//�⺻ ������
	public TFTPlayerRankInfos() {
	}
}
