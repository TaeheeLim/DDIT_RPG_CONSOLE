package com.all.character;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		CharacterDAO dao = new CharacterDAO();
		
		menu: while(true) {
			System.out.println("----------------------------------------");
			System.out.println("1. ĳ���� ����    2. ĳ���� ����   3. ĳ���� ���� ");
			System.out.println("----------------------------------------");
			System.out.print("�޴��� �����ϼ���: ");
			int menuNum = scanner.nextInt();
			switch(menuNum) {
			case 1:
				System.out.println("ĳ���� �̸�: ");
				String name = scanner.next();
				int executeUpdate = dao.insertCharacater(new CharacterVO(name,"", "���谡", 10));
				if (executeUpdate > 0) {
					System.out.println("ĳ���Ͱ� ���� �Ǿ����ϴ�.");
				} else {
					System.out.println("ĳ���� ������ �����߽��ϴ�.");
				}
				
			case 2:
				
			}
		}

	}

}
