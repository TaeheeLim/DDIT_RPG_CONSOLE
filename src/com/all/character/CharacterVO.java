package com.all.character;

public class CharacterVO {
	private int idx;
	private String name;
	private int hp;
	private int maxHp;
	private int mp;
	private int maxMp;
	private int level;
	private int exe;
	private int maxExe;
	private int attack;
	private int defence;
	private String weapon;
	private String armor;
	private int gold;
	private String memId;
	private String job;
	private int floor;
	
	
	public CharacterVO(String name, String memId, String job, int floor) {
		super();
		this.name = name;
		this.memId = memId;
		this.job = job;
		this.floor = floor;
	}
	public CharacterVO(int idx, String name, int hp, int maxHp, int mp, int maxMp, int level, int exe, int maxExe,
			int attack, int defence, String weapon, String armor, int gold, String memId, String job, int floor) {
		super();
		this.idx = idx;
		this.name = name;
		this.hp = hp;
		this.maxHp = maxHp;
		this.mp = mp;
		this.maxMp = maxMp;
		this.level = level;
		this.exe = exe;
		this.maxExe = maxExe;
		this.attack = attack;
		this.defence = defence;
		this.weapon = weapon;
		this.armor = armor;
		this.gold = gold;
		this.memId = memId;
		this.job = job;
		this.floor = floor;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getMaxHp() {
		return maxHp;
	}
	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
	}
	public int getMp() {
		return mp;
	}
	public void setMp(int mp) {
		this.mp = mp;
	}
	public int getMaxMp() {
		return maxMp;
	}
	public void setMaxMp(int maxMp) {
		this.maxMp = maxMp;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getExe() {
		return exe;
	}
	public void setExe(int exe) {
		this.exe = exe;
	}
	public int getMaxExe() {
		return maxExe;
	}
	public void setMaxExe(int maxExe) {
		this.maxExe = maxExe;
	}
	public int getAttack() {
		return attack;
	}
	public void setAttack(int attack) {
		this.attack = attack;
	}
	public int getDefence() {
		return defence;
	}
	public void setDefence(int defence) {
		this.defence = defence;
	}
	public String getWeapon() {
		return weapon;
	}
	public void setWeapon(String weapon) {
		this.weapon = weapon;
	}
	public String getArmor() {
		return armor;
	}
	public void setArmor(String armor) {
		this.armor = armor;
	}
	public int getGold() {
		return gold;
	}
	public void setGold(int gold) {
		this.gold = gold;
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int getFloor() {
		return floor;
	}
	public void setFloor(int floor) {
		this.floor = floor;
	}
	

	
	

}
