/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package b;


public class Environment {
	
	private String environment;
	private int playerPenalty;
	private int opponentPenalty;
	
	public Environment(){
		this.environment= "";
		this.playerPenalty= 0;
		this.opponentPenalty= 0;
	}
	
	public Environment(String environment, int playerPenalty, int opponentPenalty) {

		this.environment = environment;
		this.playerPenalty = playerPenalty;
		this.opponentPenalty = opponentPenalty;
	}
	
	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	public int getPlayerPenalty() {
		return playerPenalty;
	}

	public void setPlayerPenalty(int playerPenalty) {
		this.playerPenalty = playerPenalty;
	}

	public int getOpponentPenalty() {
		return opponentPenalty;
	}

	public void setOpponentPenalty(int opponentPenalty) {
		this.opponentPenalty = opponentPenalty;
	}
	
	
	
	
	
}
