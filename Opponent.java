/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package b;


public class Opponent extends Character {

	private String opponent;
	
	private boolean defend;
	private boolean charge;
	private String lastCommand;
	private String AI[];
	
	public Opponent() {
		this.opponent="";
		this.defend=false;
		this.charge=false;
		this.AI=new String[3];
		this.lastCommand="";
	}

	public Opponent(String opponent, int hP, int atk, int def, int spd, String[] aI) {
		
		this.opponent = opponent;
		HP = hP;
		this.atk = atk;
		this.def = def;
		this.spd = spd;
		AI = aI;
		this.defend=false;
		this.charge=false;
		this.lastCommand="";
	}

	public Opponent(String opponent, int hP, int atk, int def, int spd) {
		super(hP, atk, def, spd);
		this.opponent = opponent;
		this.lastCommand="";
		// TODO Auto-generated constructor stub
	}

	public String getOpponent() {
		return opponent;
	}

	public String getLastCommand() {
		return lastCommand;
	}

	public void setLastCommand(String lastCommand) {
		this.lastCommand = lastCommand;
	}

	public void setOpponent(String opponent) {
		this.opponent = opponent;
	}

	public String[] getAI() {
		return AI;
	}

	public void setAI(String[] aI) {
		AI = aI;
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
	
	public String think() {
		
		if(this.opponent.equals("Viking")) {
			if(this.lastCommand.equals("attack"))
			{
				return "defend";
			}
		}
		else if(this.opponent.equals("Minotaur")){
			if(!this.charge) {
				return "charge";
			}
		}
		return "attack";
	}
}

