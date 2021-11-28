package com.all.member;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		MemberDAO dao = new MemberDAO();

		menu: while (true) {
			System.out.println("---------------------------------------------------------------------");
			System.out.println("1. 로그인     2. 회원가입      3. 아이디 및 패스워드 찾기       4. 프로그램종료");
			System.out.println("---------------------------------------------------------------------");
			System.out.print("메뉴를 선택하세요: ");
			int number = scanner.nextInt();
			switch (number) {
			case 1:
					
			case 2:
				System.out.print("NAME: ");
				String name = scanner.next();
				System.out.print("FIRST SIX DIGITS OF SOCIAL SECURITY NUMBER: ");
				String regno = scanner.next();
				boolean age = dao.chekcingAge(regno);
				if (age) {
					System.out.println("15세 미만입니다.");
					break;
				}
				boolean existingMembers = dao.checkingExistingMembers(name, regno);
				if (existingMembers) {
					System.out.println("이미 존재하는 회원 입니다.");
					break;
				}

				System.out.print("ID: ");
				String id = scanner.next();

				System.out.println("아이디는 8~20글자 사이로 입력해주세요.");

				System.out.println("아이디는 영문자와 숫자를 혼용해서 만들어주세요.");

				System.out.print("PASSWORD: ");
				String pw = scanner.next();
				System.out.print("PASSWORD CHECK: ");
				String pw2 = scanner.next();
				boolean password = dao.checkingPassword(pw, pw2);
				if (password) {
					System.out.println("비밀번호가 일치하지 않습니다.");
					break;
				}

				int executeUpdate = dao.insertMember(new MemberVO(id, name, pw, regno));
				if (executeUpdate > 0) {
					System.out.println("회원가입이 완료 되었습니다.");
				} else {
					System.out.println("회원가입에 실패했습니다.");
				}
				break;
			case 3:
			case 4:
				System.out.println("EXIT GAME");
				break menu;
			}
		}
		scanner.close();
	}

}


						
