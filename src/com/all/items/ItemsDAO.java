package com.all.items;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.all.utill.ConnectionDB;

public class ItemsDAO {
	//획득 할 수있는 아이템 조회
	public List<ItemsVO> showingItemsInfo(ItemsVO vo) throws Exception{
		Connection connection = ConnectionDB.getInstance().getConnection();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("SELECT * FROM ITEMS");
		List<ItemsVO> list = new ArrayList<>();
		while(resultSet.next()) {
			String itemName = resultSet.getString("ITEM_NM");
			int itemHp = resultSet.getInt("ITEM_HP");
			int itemMp = resultSet.getInt("ITEM_MP");
			int itemAttack = resultSet.getInt("ITEM_ATT");
			int itemDefence = resultSet.getInt("ITEM_DEF");
			list.add(new ItemsVO(itemName, itemHp, itemMp, itemAttack, itemDefence));
		}
		statement.close();
		connection.close();
		resultSet.close();
		return list;
		
	}
	
	
}
