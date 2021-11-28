package com.all.job;

public class JobVO {
	private String jobName;
	private int jobHp;
	private int jobMp;
	private int attack;
	private int defence;
	
	public JobVO(String jobName, int jobHp, int jobMp, int attack, int defence) {
		this.jobName = jobName;
		this.jobHp = jobHp;
		this.jobMp = jobMp;
		this.attack = attack;
		this.defence = defence;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public int getJobHp() {
		return jobHp;
	}

	public void setJobHp(int jobHp) {
		this.jobHp = jobHp;
	}

	public int getJobMp() {
		return jobMp;
	}

	public void setJobMp(int jobMp) {
		this.jobMp = jobMp;
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
	
	
	
	

}
