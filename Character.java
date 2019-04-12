/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package b;


public class Character {
	
	protected int HP;
	protected int atk;
	protected int def;
	protected int spd;
	
	public Character() {
		HP = 0;
		this.atk = 0;
		this.def = 0;
		this.spd = 0;
		
	}

	public Character(int hP, int atk, int def, int spd) {
		HP = hP;
		this.atk = atk;
		this.def = def;
		this.spd = spd;
	}

	public int getHP() {
		return HP;
	}

	public void setHP(int hP) {
		HP = hP;
	}

	public int getAtk() {
		return atk;
	}

	public void setAtk(int atk) {
		this.atk = atk;
	}

	public int getDef() {
		return def;
	}

	public void setDef(int def) {
		this.def = def;
	}

	public int getSpd() {
		return spd;
	}

	public void setSpd(int spd) {
		this.spd = spd;
	}
	
	
	
	
	
	

}
