package com.all.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;

import javax.naming.spi.DirStateFactory.Result;

import com.all.utill.ConnectionDB;

public class MemberDAO {
	Calendar cal = Calendar.getInstance();
	// ȸ������ �޼ҵ�
	public int insertMember(MemberVO dto) throws Exception {
		Connection connection = ConnectionDB.getInstance().getConnection();

		StringBuilder builder = new StringBuilder();
		builder.append("INSERT INTO MEMBER(");
		builder.append("MEM_ID,");
		builder.append("MEM_NM,");
		builder.append("MEM_PW,");
		builder.append("MEM_REGNO");
		builder.append(") VALUES (");
		builder.append("?,");
		builder.append("?,");
		builder.append("?,");
		builder.append("?");
		builder.append(")");
		PreparedStatement statement = connection.prepareStatement(builder.toString());
		statement.setString(1, dto.getId());
		statement.setString(2, dto.getName());
		statement.setString(3, dto.getPw());
		statement.setString(4, dto.getRegno());

		int executeUpdate = statement.executeUpdate();

		statement.close();
		connection.close();

		return executeUpdate;
	}
	// 15�� �̸� �̿��� �����ϴ� �޼ҵ�
	public boolean chekcingAge(String regno) {

		if (Integer.parseInt(regno.charAt(0) + "") <= 2) {

			String str = regno.charAt(0) + "" + regno.charAt(1);
			int age = Integer.parseInt(str) + 2000;
			int year = cal.get(cal.YEAR);
			int currentAge = year - age;
			if (currentAge < 15) {
				return true;
			}
		}
		return false;
	}
	
	public boolean chekcingExistingMembers() {
		Connection connection = ConnectionDB.getInstance().getConnection();

		return false;

	}
	// 1�� ��й�ȣ�Է°��� 2�� ��й�ȣ�� �Է°��� �������� Ȯ���ϴ� �޼ҵ�
	public boolean checkingPassword(String pw, String pw2) {
		if (pw.equals(pw2)) {
		return false;
		}
		return true;

	}
	// �̹� �����ϴ� ȸ������ Ȯ���ϴ� �޼ҵ�
	public boolean checkingExistingMembers(String name, String regno) throws Exception {
		Connection connection = ConnectionDB.getInstance().getConnection();
		StringBuilder builder = new StringBuilder();
		builder.append("SELECT *");
		builder.append("  FROM MEMBER");
		builder.append(" WHERE MEM_NM = ?");
		builder.append("   AND MEM_REGNO = ?");
		PreparedStatement statement = connection.prepareStatement(builder.toString());
		statement.setString(1, name);
		statement.setString(2, regno);
		ResultSet resultSet = statement.executeQuery();
		if(resultSet.next()) {
			return true;
		} 
			return false;
	}
	// ȸ�����̵� �����ϴ� �޼ҵ�
	public int deletingId(String id) throws Exception {
		Connection connection = ConnectionDB.getInstance().getConnection();
		StringBuilder builder = new StringBuilder();
		builder.append("DELETE FROM");
		builder.append(" MEMBER ");
		builder.append("WHERE ID = ");
		builder.append("?");
		PreparedStatement statement = connection.prepareStatement(builder.toString());
		statement.setString(1, id);
		int executeUpdate = statement.executeUpdate();
		statement.close();
		connection.close();
		return executeUpdate;
		
	}
	


}

