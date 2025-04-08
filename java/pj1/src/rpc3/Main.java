package rpc3;

public class Main {
	public static void main(String[] args) {
		Rpc rpc = new Rpc();
		
		while(true) {
			if(rpc.Run() == 1) {
				System.out.println("게임을 종료합니다.");
				break;
			}
		}
		return;
	}
}
