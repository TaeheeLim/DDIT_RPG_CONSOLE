package com.all.market;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.all.utill.ConnectionDB;

public class MarketDAO {
	//�������忡 �Ǹű��� �ø��� �޼ҵ�
	public int postingNotice(MarketVO vo) throws Exception {
		Connection connection = ConnectionDB.getInstance().getConnection();
		StringBuilder builder = new StringBuilder();
		builder.append("INSERT INTO MARKET");
		builder.append(" (MARKET_IDX, MARKET_TITLE, MARKET_CONTENTS,");
		builder.append("MARKET_PRICE, MARKET_STATE, CHAR_IDX)");
		builder.append(" VALUES ");
		builder.append("(1, ?, ?, ?, ?, ?, ?)"); //MARKET_IDX�� �������� �̿��Ͽ� 1�� ����
		PreparedStatement statement = connection.prepareStatement(builder.toString());
		statement.setString(1, vo.getMarketTitle());
		statement.setString(2, vo.getMarketContents());
		statement.setInt(3, vo.getMarketPrice());
		statement.setString(4, vo.getMarketState()); //MARKET_STATE�� 0�� 1�� �����Ǿ� �ְ� 0 �� �Ǹ�����, 1 �� ���� �Ǹ����� ����.
		statement.setInt(5, vo.getCharacterIdx());
		statement.setInt(6, vo.getItemCo());
		int executeUpdate = statement.executeUpdate();
		return executeUpdate;
		
	}
	// �������忡 �ԽõǾ��ִ� ���� ��ȸ�ϴ� �޼ҵ�
	public List<MarketVO> shoiwngPostingInfo() throws Exception {
		Connection connection = ConnectionDB.getInstance().getConnection();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("SELECT * FROM MARKET");
		List<MarketVO> list = new ArrayList<>();
		while(resultSet.next()) {
			int marketIdx = resultSet.getInt("MARKET_IDX");
			String marketTitle = resultSet.getString("MARKET_TITLE");
			String marketContents = resultSet.getString("MARKET_CONTENTS");
			int marketPrice = resultSet.getInt("MARKET_PRICE");
			String marketState = resultSet.getString("MARKET_STATE");  //MARKET_STATE�� 0�� 1�� �����Ǿ� �ְ� 0 �� �Ǹ�����, 1 �� ���� �Ǹ����� ����.
			int characterIdx = resultSet.getInt("CHAR_IDX");
			String itemName = resultSet.getString("ITEM_NM");
			int itemCo = resultSet.getInt("ITEM_CO");
			list.add(new MarketVO(marketIdx, marketTitle, marketContents, marketPrice, marketState, characterIdx, itemName, itemCo));
		}
		resultSet.close();
		connection.close();
		statement.close();
		return list;
		
	}
	
	// �ŷ��Ϸ�� �Խñ��� MARKET_STATE�� 0���� �����ϴ� �޼ҵ�
	// ������ ��� ����
	// �Ǹ���: ��� ���, 
	public int purchasingItem(MarketVO vo) throws Exception {
		Connection connection = ConnectionDB.getInstance().getConnection();
		StringBuilder builder = new StringBuilder();
		builder.append("UPDATE MARKET");
		builder.append(" SET ");
		builder.append(" MARKET_STATE = 0 ");
		builder.append("WHERE");
		builder.append(" MAKRET_IDX = ?");
		PreparedStatement statement = connection.prepareStatement(builder.toString());
		statement.setInt(1, vo.getMarketIdx());
		int executeUpdate = statement.executeUpdate();
		return executeUpdate;
		
	}
	
	
}                                                                                           
