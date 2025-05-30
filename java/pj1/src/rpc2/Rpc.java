package rpc2;

import java.util.Scanner;

public class Rpc {
	int nPlayerRpc;
	String stPlayerRpc;
	int nComRpc;
	String stComRpc;
	
	public void SetComRpc() {	
		nComRpc = (int)(Math.random() * 3);
		
		if(nComRpc == 0) {
			stComRpc = "가위";
		}
		else if(nComRpc == 1){
			stComRpc = "바위";
		}
		else if(nComRpc == 2){
			stComRpc = "보";
		}
	}
	public void SetPlayerRpc() {
		System.out.println("가위, 바위, 보 중에 하나를 입력해주세요");
		Scanner sc = new Scanner(System.in);
		stPlayerRpc = sc.next();
		
		if(stPlayerRpc.equals("가위")){
			nPlayerRpc = 0;
		}
		else if(stPlayerRpc.equals("바위")){
			nPlayerRpc = 1;
		}
		else if(stPlayerRpc.equals("보")){
			nPlayerRpc = 2;
		}
		else {
			nPlayerRpc = 10;
		}
	}
	public void PlayRpc() {
		if(nPlayerRpc == 10) {
			System.out.println("잘못된 값을 입력했습니다.");
			return;
		}
		switch(nPlayerRpc-nComRpc) {
		case 0:
			System.out.println("플레이어 : " + stPlayerRpc + " 컴퓨터 : " + stComRpc + " 비겼습니다.");
			break;
		case 1:
		case -2:
			System.out.println("플레이어 : " + stPlayerRpc + " 컴퓨터 : " + stComRpc + " 이겼습니다.");
			break;
		case -1:
		case 2:
			System.out.println("플레이어 : " + stPlayerRpc + " 컴퓨터 : " + stComRpc + " 졌습니다.");
			break;		
		}
	}
	public void Run() {
		SetPlayerRpc();
		SetComRpc();
		PlayRpc();
	}
}
