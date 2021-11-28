package com.all.character;

public class Singleton {
	//���� private �ʵ�
	private static Singleton singleton = new Singleton();
	
	private Singleton() {
		
	}
	
	static Singleton getInstance() {
		return singleton;
		
	}
}
