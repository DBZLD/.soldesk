package com.spring.service;

public class Dice {
	
	static public int roll(int n) {
		int r = (int)(Math.random()*n+1);
		return r;
	}
	static public int roll(int min, int max) {
		int n = max - min + 1;
		int r = (int)(Math.random()*n+min);
		return r;
	}
	//100 % �� n Ȯ���� �ɸ��� true ����
	static public boolean percent(int n) {
		boolean b = false;
		int r = roll(1,100);
		if(r <= n) b = true;
		return b;
	}
	//1000 % �� n Ȯ���� �ɸ��� true ����
	static public boolean percent1000(int n) {
		boolean b = false;
		int r = roll(1,1000);
		if(r <= n) b = true;
		return b;
	}
	//10000 % �� n Ȯ���� �ɸ��� true ����
	static public boolean percent10000(int n) {
		boolean b = false;
		int r = roll(1,10000);
		if(r <= n) b = true;
		return b;
	}
}
