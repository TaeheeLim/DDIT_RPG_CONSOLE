package com.all.character;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		CharacterDAO dao = new CharacterDAO();
		
		menu: while(true) {
			System.out.println("----------------------------------------");
			System.out.println("1. 캐릭터 생성    2. 캐릭터 선택   3. 캐릭터 삭제 ");
			System.out.println("----------------------------------------");
			System.out.print("메뉴를 선택하세요: ");
			int menuNum = scanner.nextInt();
			switch(menuNum) {
			case 1:
				System.out.println("캐릭터 이름: ");
				String name = scanner.next();
				int executeUpdate = dao.insertCharacater(new CharacterVO(name,"", "모험가", 10));
				if (executeUpdate > 0) {
					System.out.println("캐릭터가 생성 되었습니다.");
				} else {
					System.out.println("캐릭터 생성에 실패했습니다.");
				}
				
			case 2:
				
			}
		}

	}

}
