/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package b;

public class Weapon {

	private String weaponType;
	private int atk;
	private int spdPenalty;
	
	public Weapon() {
		this.weaponType="";
		this.atk=0;
		this.spdPenalty=0;
	}
	
	public Weapon(String weaponType, int atk, int spdPenalty) {
		this.weaponType=weaponType;
		this.atk=atk;
		this.spdPenalty=spdPenalty;
	}

	public String getWeaponType() {
		return weaponType;
	}

	public void setWeaponType(String weaponType) {
		this.weaponType = weaponType;
	}

	public int getAtk() {
		return atk;
	}

	public void setAtk(int atk) {
		this.atk = atk;
	}

	public int getSpdPenalty() {
		return spdPenalty;
	}

	public void setSpdPenalty(int spdPenalty) {
		this.spdPenalty = spdPenalty;
	}
}
