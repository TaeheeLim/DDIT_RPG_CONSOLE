package com.all.character;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.all.monsters.MonstersVO;
import com.all.utill.ConnectionDB;

public class CharacterDAO {
	public int insertCharacater(CharacterVO vo) throws Exception {
		Connection connection = ConnectionDB.getInstance().getConnection();
		StringBuilder builder = new StringBuilder();
		builder.append("INSERT INTO CHARACTERS(CHAR_IDX,CHAR_NM,MEM_ID,JOB_NM,FLOOR)");
		builder.append(" VALUES(1, ?, ?, ?, ? )");
		PreparedStatement statement = connection.prepareStatement(builder.toString());
		statement.setString(1, vo.getName());
		statement.setString(2, vo.getMemId());
		statement.setString(3, vo.getJob());
		statement.setInt(4, vo.getFloor());
		int executeUpdate = statement.executeUpdate();
		return executeUpdate;
	}

	public CharacterVO showInfo(CharacterVO vo) throws SQLException {
		Connection connection = ConnectionDB.getInstance().getConnection();
		StringBuilder builder = new StringBuilder();
		builder.append("SELECT ");
		builder.append("CHAR_NM,");
		builder.append("CHAR_HP,");
		builder.append("CHAR_MAX_HP,");
		builder.append("CHAR_MP,");
		builder.append("CHAR_MAX_MP,");
		builder.append("CHAR_LEV,");
		builder.append("CHAR_EXE,");
		builder.append("CHAR_MAX_EXE,");
		builder.append("CHAR_ATT,");
		builder.append("CHAR_DEF,");
		builder.append("CHAR_WEAPON,");
		builder.append("CHAR_ARMOR,");
		builder.append("CHAR_GOLD,");
		builder.append("JOB_NM,");
		builder.append("FLOOR");
		builder.append(" FROM CHARACTERS");
		builder.append(" WHERE CHAR_IDX = ");
		builder.append("?");
		PreparedStatement statement = connection.prepareStatement(builder.toString());
		statement.setInt(1, vo.getIdx());
		ResultSet resultSet = statement.executeQuery();
		if (resultSet.next()) {
			String name = resultSet.getString("CHAR_NM");
			int hp = resultSet.getInt("CHAR_HP");
			int maxHp = resultSet.getInt("CHAR_MAX_HP");
			int mp = resultSet.getInt("CHAR_MP");
			int maxMp = resultSet.getInt("CHAR_MAX_MP");
			int level = resultSet.getInt("CHAR_LEV");
			int exe = resultSet.getInt("CHAR_EXE");
			int maxExe = resultSet.getInt("CHAR_MAX_EXE");
			int attack = resultSet.getInt("CHAR_ATT");
			int defence = resultSet.getInt("CHAR_DEF");
			String weapon = resultSet.getString("CHAR_WEAPON");
			String armor = resultSet.getString("CHAR_ARMOR");
			int gold = resultSet.getInt("CHAR_GOLD");
			String jobName = resultSet.getString("JOB_NM");
			int floor = resultSet.getInt("FLOOR");
			return new CharacterVO(0, name, hp, maxHp, mp, maxMp, level, exe, maxExe, attack, defence, weapon, armor,
					gold, null, jobName, floor);

		}
		return null;
	}
	public int unequipWeapon(int idx) throws Exception {
		Connection connection = ConnectionDB.getInstance().getConnection();
		StringBuilder builder = new StringBuilder();
		builder.append("UPDATE CHARACTER");
		builder.append(" SET");
		builder.append("CHAR_WEAPON = NULL");
		builder.append(" WHERE ");
		builder.append("CHAR_IDX = ?");
		PreparedStatement statement = connection.prepareStatement(builder.toString());
		statement.setInt(1, idx);
		int executeUpdate = statement.executeUpdate();
		connection.close();
		statement.close();
		return executeUpdate;
	}
	
	public int unequipArmor(int idx) throws Exception {
		Connection connection = ConnectionDB.getInstance().getConnection();
		StringBuilder builder = new StringBuilder();
		builder.append("UPDATE CHARACTER");
		builder.append(" SET");
		builder.append("CHAR_ARMOR = NULL");
		builder.append(" WHERE ");
		builder.append("CHAR_IDX = ?");
		PreparedStatement statement = connection.prepareStatement(builder.toString());
		statement.setInt(1, idx);
		int executeUpdate = statement.executeUpdate();
		connection.close();
		statement.close();
		return executeUpdate;
	}
	
	public int sendingWeaponToInventory(CharacterVO vo) throws Exception {
		Connection connection = ConnectionDB.getInstance().getConnection();
		StringBuilder builder = new StringBuilder();
		builder.append("INSERT INTO INVENTORY");
		builder.append(" (ITEM_NM) ");
		builder.append("VALUES(?) ");
		builder.append("WHERE CHAR_IDX = ?");
		PreparedStatement statement = connection.prepareStatement(builder.toString());
		statement.setString(1, vo.getWeapon());
		statement.setInt(2, vo.getIdx());
		int executeUpdate = statement.executeUpdate();
		connection.close();
		statement.close();
		
		return executeUpdate;
	}
	
	public int sendingArmorToInventory(CharacterVO vo) throws Exception {
		Connection connection = ConnectionDB.getInstance().getConnection();
		StringBuilder builder = new StringBuilder();
		builder.append("INSERT INTO INVENTORY");
		builder.append(" (ITEM_NM) ");
		builder.append("VALUES(?) ");
		builder.append("WHERE CHAR_IDX = ?");
		PreparedStatement statement = connection.prepareStatement(builder.toString());
		statement.setString(1, vo.getArmor());
		statement.setInt(2, vo.getIdx());
		int executeUpdate = statement.executeUpdate();
		connection.close();
		statement.close();
		
		return executeUpdate;
	}
	
	public CharacterVO charactersBeingAttacked(CharacterVO vo, int damage) {
		int gettingDamage = damage - vo.getDefence();
		gettingDamage = gettingDamage <= 0 ? 1 : gettingDamage;
		int characterCurrentHp = vo.getHp();
		characterCurrentHp = characterCurrentHp < gettingDamage ? characterCurrentHp - characterCurrentHp : characterCurrentHp - gettingDamage;
		vo.setHp(characterCurrentHp);
		return vo;
		
	}
	
	// 캐릭터 레벨업
	// 1 레벨업 할 때마다 체력 30% 증가, 마나 20% 증가, 공격력 10% 증가, 방어력 10% 증가, 경험치 30프로 증가
	// 1레벨 때 경험치 통 100. 30%씩 증가 하니까 2레벨 떄 130 -> 3레벨 때 169
	public int charactersLevelup(CharacterVO vo) throws Exception {
		Connection connection = ConnectionDB.getInstance().getConnection();
		StringBuilder builder = new StringBuilder();
		builder.append("UPDATE CHARACTER ");
		builder.append("SET ");
		builder.append("CHAR_LEV = ? ");
		builder.append("CHAR_HP = ? ");
		builder.append("CHAR_MP = ? ");
		builder.append("CHAR_MAX_HP = ? ");
		builder.append("CHAR_MAX_MP - ? ");
		builder.append("CHAR_ATT = ? ");
		builder.append("CHAR_DEF = ? ");
		builder.append("CHAR_MAX_EXE = ? ");
		builder.append("CHAR_EXE = ? ");
		builder.append("WHERE CHAR_IDX = ?");
		PreparedStatement statement = connection.prepareStatement(builder.toString());
		int level = vo.getLevel();
		int maxHp = (int) (vo.getMaxHp() * 1.3);
		int maxMp = (int) (vo.getMaxMp() * 1.3);
		statement.setInt(1, level++); //레벨
		statement.setInt(2, maxHp);
		statement.setInt(3, maxMp);
		statement.setInt(4, (int) (vo.getMaxHp() * 1.3)); //MAX HP
		statement.setInt(5, (int) (vo.getMaxMp() * 1.2)); //MAX MP
		statement.setInt(6, (int) (vo.getAttack() * 1.1)); //ATT
		statement.setInt(7, (int) (vo.getDefence() * 1.1)); //DEF
		statement.setInt(8, (int) (vo.getMaxExe() * 1.3)); //MAX EXE
		statement.setInt(9, 0);
		statement.setInt(10, vo.getIdx());
		int executeUpdate = statement.executeUpdate();
		
		statement.close();
		connection.close();
		return executeUpdate;
		//현재 누적된 경험치를 보여준다
	}
	// 레벨이 5가되면 전사,도적,마법사로 전직할 수 있는 선택권이 생긴다.
	// 전사: 체력의 1.3배, 마나의 1배, 공격력의 1배, 방어력의 1,3배
	// 도적: 체력의 1.3배, 마나의 1배, 공격력의 1.3배, 방어력의 1배
	// 마법사: 체력의 1배, 마나의 1.3배, 공격력의 1.3배, 방어력의 1배
		public int changingJobToWarrior(CharacterVO vo, String job) throws Exception {
		Connection connection = ConnectionDB.getInstance().getConnection();
		int maxHp;
		int maxMp;
		int attack;
		int defence;
		if(job.equals("전사")) {
		maxHp = (int) (vo.getMaxHp() * 1.3);
		defence = (int) (vo.getDefence() * 1.3);
		} else if(job.equals("도적")) {
			maxHp = (int) (vo.getMaxHp() * 1.3);
			attack = (int) (vo.getAttack() * 1.3);
		} else if(job.equals("마법사")) {
			maxMp = (int) (vo.getMaxMp() * 1.3);
			attack = (int) (vo.getAttack() * 1.3);
		}
		StringBuilder builder = new StringBuilder();
		builder.append("UPDATE CHARACTER ");
		builder.append("SET ");
		builder.append("CHAR_MAX_HP = ? ");
		builder.append("CHAR_DEF = ? ");
		builder.append("JOB_NM = ? ");
		builder.append("WHERE CHAR_LEV = 5 ");
		builder.append("AND CHAR_ID X = ?");
		PreparedStatement statement = connection.prepareStatement(builder.toString());
		statement.setInt(1, (int) (vo.getMaxHp() * 1.3));
		statement.setInt(2, (int) (vo.getDefence() * 1.3));
		statement.setString(3, "전사");
		statement.setInt(4, vo.getIdx());
		int executeUpdate = statement.executeUpdate();
		return executeUpdate;
			
		}
		
		public int changingJobToMage(CharacterVO vo) throws Exception {
			Connection connection = ConnectionDB.getInstance().getConnection();
			StringBuilder builder = new StringBuilder();
			builder.append("UPDATE CHARACTER ");
			builder.append("SET ");
			builder.append("CHAR_MAX_MP = ? ");
			builder.append("CHAR_ATT = ? ");
			builder.append("JOB_NM = ? ");
			builder.append("WHERE CHAR_LEV = 5 ");
			builder.append("AND CHAR_IDX = ?");
			PreparedStatement statement = connection.prepareStatement(builder.toString());
			statement.setInt(1, (int) (vo.getMaxMp() * 1.3));
			statement.setInt(2, (int) (vo.getAttack() * 1.3));
			statement.setString(3, "마법사");
			statement.setInt(4, vo.getIdx());
			int executeUpdate = statement.executeUpdate();
			return executeUpdate;
				
			}
		
		public int changingJobToTheif(CharacterVO vo) throws Exception {
			Connection connection = ConnectionDB.getInstance().getConnection();
			StringBuilder builder = new StringBuilder();
			builder.append("UPDATE CHARACTER ");
			builder.append("SET ");
			builder.append("CHAR_MAX_HP = ? ");
			builder.append("CHAR_ATT = ? ");
			builder.append("JOB_NM = ? ");
			builder.append("WHERE CHAR_LEV = 5 ");
			builder.append("AND CHAR_IDX = ?");
			PreparedStatement statement = connection.prepareStatement(builder.toString());
			statement.setInt(1, (int) (vo.getMaxHp() * 1.3));
			statement.setInt(2, (int) (vo.getAttack() * 1.3));
			statement.setString(3, "도적");
			statement.setInt(4, vo.getIdx());
			int executeUpdate = statement.executeUpdate();
			return executeUpdate;
				
			}
		
		

}
