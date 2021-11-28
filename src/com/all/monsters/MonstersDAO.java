package com.all.monsters;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.all.character.CharacterVO;
import com.all.utill.ConnectionDB;

public class MonstersDAO {
	// ���� ���� ��� �޼ҵ�
	public List<MonstersVO> showMonstersInfo() throws Exception {
		Connection connection = ConnectionDB.getInstance().getConnection();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("SELECT * FROM MONSTERS");
		List<MonstersVO> list = new ArrayList<>();

		while (resultSet.next()) {
			String monsterName = resultSet.getString("MON_NM");
			int monsterHp = resultSet.getInt("MON_HP");
			int monsterAttack = resultSet.getInt("MON_ATT");
			int monsterDefence = resultSet.getInt("MON_DEF");
			int monsterGold = resultSet.getInt("MON_GOLD");
			int monsterLevel = resultSet.getInt("MON_LEV");
			String itemName = resultSet.getString("ITEM_NM");
			list.add(new MonstersVO(monsterName, monsterHp, monsterAttack, monsterDefence, monsterGold, monsterLevel,
					itemName));
		}
		return list;
	}

	// ���Ͱ� ���ϴ� �������� ���� ���ݷ��� 1.2���� �޼ҵ�
	public double monsterAttack(MonstersVO vo) {
		double monsterDamage = vo.getMonsterAttack() * 1.2;
		return monsterDamage;

	}
	
	
	// ������ ��ȯ �޼ҵ�
	public String monstersDroppingItem(MonstersVO vo) {
		String item = vo.getItemName();
		return item;
	}
	// ���Ͱ� ĳ���ͷ� ���� �޴� ���ظ� ��ȯ�ϴ� �޼ҵ�
	public MonstersVO monstersBeingAttacked(MonstersVO vo, int damage) {
	
		int monstersArmor = (vo.getMonsterDefence() * vo.getMonsterLevel()) / 10 ;
		int gettingDamage = (int) (damage - monstersArmor);
		gettingDamage = gettingDamage <= 0 ? 1 : gettingDamage;
		int monsterCurrentHp = vo.getMonsterHp();
		monsterCurrentHp = monsterCurrentHp < gettingDamage ? monsterCurrentHp - monsterCurrentHp : monsterCurrentHp - gettingDamage;
		vo.setMonsterHp(monsterCurrentHp);
		return vo;

	}
	
}
