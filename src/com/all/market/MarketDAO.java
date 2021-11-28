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
	//자유시장에 판매글을 올리는 메소드
	public int postingNotice(MarketVO vo) throws Exception {
		Connection connection = ConnectionDB.getInstance().getConnection();
		StringBuilder builder = new StringBuilder();
		builder.append("INSERT INTO MARKET");
		builder.append(" (MARKET_IDX, MARKET_TITLE, MARKET_CONTENTS,");
		builder.append("MARKET_PRICE, MARKET_STATE, CHAR_IDX)");
		builder.append(" VALUES ");
		builder.append("(1, ?, ?, ?, ?, ?, ?)"); //MARKET_IDX는 시퀀스를 이용하여 1씩 증가
		PreparedStatement statement = connection.prepareStatement(builder.toString());
		statement.setString(1, vo.getMarketTitle());
		statement.setString(2, vo.getMarketContents());
		statement.setInt(3, vo.getMarketPrice());
		statement.setString(4, vo.getMarketState()); //MARKET_STATE는 0과 1로 구성되어 있고 0 은 판매종료, 1 은 현재 판매중인 상태.
		statement.setInt(5, vo.getCharacterIdx());
		statement.setInt(6, vo.getItemCo());
		int executeUpdate = statement.executeUpdate();
		return executeUpdate;
		
	}
	// 자유시장에 게시되어있는 글을 조회하는 메소드
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
			String marketState = resultSet.getString("MARKET_STATE");  //MARKET_STATE는 0과 1로 구성되어 있고 0 은 판매종료, 1 은 현재 판매중인 상태.
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
	
	// 거래완료시 게시글의 MARKET_STATE를 0으로 변경하는 메소드
	// 구매자 골드 차감
	// 판매자: 골드 상승, 
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
