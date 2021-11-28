package com.all.items;

public class ItemsVO {
	private String itemName;
	private int itemHp;
	private int itemMp;
	private int itemAttack;
	private int itemDefence;
	
	public ItemsVO(String itemName, int itemHp, int itemMp, int itemAttack, int itemDefence) {
		super();
		this.itemName = itemName;
		this.itemHp = itemHp;
		this.itemMp = itemMp;
		this.itemAttack = itemAttack;
		this.itemDefence = itemDefence;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getItemHp() {
		return itemHp;
	}

	public void setItemHp(int itemHp) {
		this.itemHp = itemHp;
	}

	public int getItemMp() {
		return itemMp;
	}

	public void setItemMp(int itemMp) {
		this.itemMp = itemMp;
	}

	public int getItemAttack() {
		return itemAttack;
	}

	public void setItemAttack(int itemAttack) {
		this.itemAttack = itemAttack;
	}

	public int getItemDefence() {
		return itemDefence;
	}

	public void setItemDefence(int itemDefence) {
		this.itemDefence = itemDefence;
	}
	
	
}
