package lottohash;

import java.util.HashSet;
import java.util.Iterator;

public class Main {
	public static void main(String[] args) {
		HashSet<Integer> comHash = new HashSet<Integer>();
		HashSet<Integer> userHash = new HashSet<Integer>();
		HashSet<Integer> sameHash = new HashSet<Integer>();
		Iterator<Integer> printHash;
		int nEnd;

		nEnd = 0;
		while (true) {
			if (nEnd >= 6) {
				break;
			}
			Integer num = (int) (Math.random() * 45 + 1);
			if (!(comHash.contains(num))) {
				comHash.add(num);
				nEnd++;
			}
		}
		nEnd = 0;
		while (true) {
			if (nEnd >= 6) {
				break;
			}
			Integer num = (int) (Math.random() * 45 + 1);
			if (!(userHash.contains(num))) {
				userHash.add(num);
				nEnd++;
			}
		}
		printHash = userHash.iterator();
		while (printHash.hasNext()) {
			sameHash.add(printHash.next());
		}
		sameHash.retainAll(comHash);
		printHash = userHash.iterator();
		System.out.print("유저 번호 : ");
		while (printHash.hasNext()) {
			System.out.print(printHash.next() + " ");
		}
		System.out.println();
		printHash = comHash.iterator();
		System.out.print("당첨 번호 : ");
		while (printHash.hasNext()) {
			System.out.print(printHash.next() + " ");
		}
		System.out.println();
		switch (sameHash.size()) {
		case 0:
		case 1:
		case 2:
			System.out.println("당첨되지 않았습니다.");
			break;
		case 3:
			System.out.println("5등");
			break;
		case 4:
			System.out.println("4등");
			break;
		case 5:
			System.out.println("3등");
			break;
		case 6:
			System.out.println("1등");
			break;
		}
	}
}
