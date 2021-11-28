package com.all.character;

public class Singleton {
	//정적 private 필드
	private static Singleton singleton = new Singleton();
	
	private Singleton() {
		
	}
	
	static Singleton getInstance() {
		return singleton;
		
	}
}
