package com.all.member;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		MemberDAO dao = new MemberDAO();

		menu: while (true) {
			System.out.println("---------------------------------------------------------------------");
			System.out.println("1. �α���     2. ȸ������      3. ���̵� �� �н����� ã��       4. ���α׷�����");
			System.out.println("---------------------------------------------------------------------");
			System.out.print("�޴��� �����ϼ���: ");
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
					System.out.println("15�� �̸��Դϴ�.");
					break;
				}
				boolean existingMembers = dao.checkingExistingMembers(name, regno);
				if (existingMembers) {
					System.out.println("�̹� �����ϴ� ȸ�� �Դϴ�.");
					break;
				}

				System.out.print("ID: ");
				String id = scanner.next();

				System.out.println("���̵�� 8~20���� ���̷� �Է����ּ���.");

				System.out.println("���̵�� �����ڿ� ���ڸ� ȥ���ؼ� ������ּ���.");

				System.out.print("PASSWORD: ");
				String pw = scanner.next();
				System.out.print("PASSWORD CHECK: ");
				String pw2 = scanner.next();
				boolean password = dao.checkingPassword(pw, pw2);
				if (password) {
					System.out.println("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
					break;
				}

				int executeUpdate = dao.insertMember(new MemberVO(id, name, pw, regno));
				if (executeUpdate > 0) {
					System.out.println("ȸ�������� �Ϸ� �Ǿ����ϴ�.");
				} else {
					System.out.println("ȸ�����Կ� �����߽��ϴ�.");
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


						
