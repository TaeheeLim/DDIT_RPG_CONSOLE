package com.all.market;

public class MarketVO {
	private int marketIdx;
	private String marketTitle;
	private String marketContents;
	private int marketPrice;
	private String marketState;
	private int characterIdx;
	private String itemName;
	private int itemCo;
	public MarketVO(int marketIdx, String marketTitle, String marketContents, int marketPrice, String marketState,
			int characterIdx, String itemName, int itemCo) {
		super();
		this.marketIdx = marketIdx;
		this.marketTitle = marketTitle;
		this.marketContents = marketContents;
		this.marketPrice = marketPrice;
		this.marketState = marketState;
		this.characterIdx = characterIdx;
		this.itemName = itemName;
		this.itemCo = itemCo;
		
	}
	public int getMarketIdx() {
		return marketIdx;
	}
	public void setMarketIdx(int marketIdx) {
		this.marketIdx = marketIdx;
	}
	public String getMarketTitle() {
		return marketTitle;
	}
	public void setMarketTitle(String marketTitle) {
		this.marketTitle = marketTitle;
	}
	public String getMarketContents() {
		return marketContents;
	}
	public void setMarketContents(String marketContents) {
		this.marketContents = marketContents;
	}
	public int getMarketPrice() {
		return marketPrice;
	}
	public void setMarketPrice(int marketPrice) {
		this.marketPrice = marketPrice;
	}
	public String getMarketState() {
		return marketState;
	}
	public void setMarketState(String marketState) {
		this.marketState = marketState;
	}
	public int getCharacterIdx() {
		return characterIdx;
	}
	public void setCharacterIdx(int characterIdx) {
		this.characterIdx = characterIdx;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getItemCo() {
		return itemCo;
	}
	public void setItemCo(int itemCo) {
		this.itemCo = itemCo;
	}
	
	
	
}
