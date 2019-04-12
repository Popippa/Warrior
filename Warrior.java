/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package b;


public class Warrior extends Character{
	
	private Armor armor; // Linked to Armor Class (Association)
	private Weapon weapon; // linked to Weapon Class (Association)
	private boolean defend;
	private boolean charge;
	private String lastCommand;
	
	public Warrior() {
		// HP, atk, def, and spd were inherited from Character class
		this.HP=100;
		this.atk=1;
		this.def=1;
		this.spd=50;
		this.armor=null;
		this.weapon=null;
		this.defend=false;
		this.charge=false;
		this.lastCommand="";
	}
	
	public Warrior(Armor armor, Weapon weapon) {
		//super();//calling its parent class
		this();
		this.armor = armor;
		this.weapon = weapon;
		this.def += armor.getDef();
		this.spd -= armor.getSpdPenalty();
		this.atk += weapon.getAtk();
		this.spd -= weapon.getSpdPenalty();
		this.lastCommand="";
	}

	public Armor getArmor() {
		return armor;
	}
	
	// Sets the armor type and updates the stats
	public void setArmor(Armor armor) {		
		this.armor = armor;
		this.def += armor.getDef();
		this.spd -= armor.getSpdPenalty();
	}

	public Weapon getWeapon() {
		return weapon;
	}
	
	// Sets the weapon type and updates the stats
	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
		this.atk += weapon.getAtk();
		this.spd -= weapon.getSpdPenalty();
	}

	public boolean isDefend() {
		return defend;
	}

	public void setDefend(boolean defend) {
		this.defend = defend;
	}

	public boolean isCharge() {
		return charge;
	}

	public void setCharge(boolean charge) {
		this.charge = charge;
	}

	public String getLastCommand() {
		return lastCommand;
	}

	public void setLastCommand(String lastCommand) {
		this.lastCommand = lastCommand;
	}
	
	

}

