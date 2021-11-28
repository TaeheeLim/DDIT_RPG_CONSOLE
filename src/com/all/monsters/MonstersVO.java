package com.all.monsters;

public class MonstersVO {
	private String monsterName;
	private int monsterHp;
	private int monsterAttack;
	private int monsterDefence;
	private int monsterGold;
	private int monsterLevel;
	private String itemName;
	
	public MonstersVO(String monsterName, int monsterHp, int monsterAttack, int monsterDefence, int monsterGold,
			int monsterLevel, String itemName) {
		super();
		this.monsterName = monsterName;
		this.monsterHp = monsterHp;
		this.monsterAttack = monsterAttack;
		this.monsterDefence = monsterDefence;
		this.monsterGold = monsterGold;
		this.monsterLevel = monsterLevel;
		this.itemName = itemName;
	}
	public String getMonsterName() {
		return monsterName;
	}
	public void setMonsterName(String monsterName) {
		this.monsterName = monsterName;
	}
	public int getMonsterHp() {
		return monsterHp;
	}
	public void setMonsterHp(int monsterHp) {
		this.monsterHp = monsterHp;
	}
	public int getMonsterAttack() {
		return monsterAttack;
	}
	public void setMonsterAttack(int monsterAttack) {
		this.monsterAttack = monsterAttack;
	}
	public int getMonsterDefence() {
		return monsterDefence;
	}
	public void setMonsterDefence(int monsterDefence) {
		this.monsterDefence = monsterDefence;
	}
	public int getMonsterGold() {
		return monsterGold;
	}
	public void setMonsterGold(int monsterGold) {
		this.monsterGold = monsterGold;
	}
	public int getMonsterLevel() {
		return monsterLevel;
	}
	public void setMonsterLevel(int monsterLevel) {
		this.monsterLevel = monsterLevel;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
	

}
