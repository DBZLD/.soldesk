package lotto;

import java.util.Scanner;

public class Lotto {
	int nPlayerNum[] = new int[6];
	int nComNum[] = new int[6];
	int nComBonusNum;
	int nSame = 0;
	boolean isBonusSame = false;
	
	public void SetPlayerNum() {
		Scanner sc;
		
		for(int i = 0; i < nPlayerNum.length; i++) {
			System.out.println("번호를 입력해주세요 (" + (i+1) + "/6)");
			sc = new Scanner(System.in);
			nPlayerNum[i] = Integer.valueOf(sc.next());		
		}
	}
	public void SetComNum() {
		for(int i = 0; i < nComNum.length; i++) {
			nComNum[i] = (int)(Math.random()*45+1);
			for(int j = 0; j < i; j++) {
				if(nComNum[i] == nComNum[j]) {
					nComNum[i] = (int)(Math.random()*45+1);
					j = 0;
				}
			}
		}
		nComBonusNum = (int)(Math.random()*45+1);
		for(int i = 0; i < nComNum.length; i++) {			
			if(nComBonusNum == nComNum[i]) {
				nComBonusNum = (int)(Math.random()*45+1);
				i = 0;
			}
		}
	}
	public void FindSame() {
		for(int i = 0; i <nPlayerNum.length; i++) {
			if(nPlayerNum[i] == nComBonusNum) {
				isBonusSame = true;
			}
			for(int j = 0; j < nComNum.length; j++) {
				if(nPlayerNum[i] == nComNum[j]) {
					nSame += 1;
				}
			}
		}
	}
	public void PrintPrice() {
		switch(nSame) {
		case 0:
		case 1:
		case 2:
			System.out.println("당첨되지 않았습니다.");
			break;
		case 3:
			System.out.println("5등 당첨");
			break;
		case 4:
			System.out.println("4등 당첨");
			break;
		case 5:
			if(isBonusSame == true) {
				System.out.println("2등 당첨");	
			}
			else {
				System.out.println("3등 당첨");	
			}
			break;
		case 6:
			System.out.println("1등 당첨");
			break;
		}
	}
	public void Run() {
		SetPlayerNum();
		SetComNum();
		FindSame();
		PrintPrice();
	}
	
}
