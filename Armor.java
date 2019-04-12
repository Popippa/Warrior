/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package b;


public class Armor {
	
	private String armorType;
	private int def;
	private int spdPenalty;
	
	// Constructor
	public Armor() { 
		// initialize class attributes
		this.armorType="";
		this.def=0;
		this.spdPenalty=0;
	}
	
	public Armor(String armorType, int def, int spdPenalty) {
		this.armorType = armorType;
		this.def = def;
		this.spdPenalty = spdPenalty;
	}

	public String getArmorType() {
		return armorType;
	}

	public void setArmorType(String armorType) {
		this.armorType = armorType;
	}

	public int getDef() {
		return def;
	}

	public void setDef(int def) {
		this.def = def;
	}

	public int getSpdPenalty() {
		return spdPenalty;
	}

	public void setSpdPenalty(int spdPenalty) {
		this.spdPenalty = spdPenalty;
	}

}
