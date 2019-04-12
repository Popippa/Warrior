/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c;



public class Main {
	/*
	private static Scanner in;

	// MAIN METHOD ----------------------------------------------------------------
	public static void main(String args[]) {
		
		in = new Scanner(System.in);
		
		// For Testing only
		//Warrior warrior = new Warrior(new Armor("Medium Armor",30,15),new Weapon("Sword",30,10));
		//Opponent opponent = new Opponent("Minotaur",10,40,40,20,new String[] {"Attack","Defend"});
		//Environment env = new Environment("Swamp",1,1);
		
		
		Warrior warrior = new Warrior();
		Opponent opponent = new Opponent();
		Environment env = new Environment();
		
		
		int maxHP = warrior.getHP();
	    int oMaxHP = opponent.getHP(), comm=0;
	    
	    boolean first=true, firstStrike=true, skip=false;
	    
		System.out.println("\n\tWarrior RPG (Beta)\n");
		
		characterSetup(warrior);
		opponentSelection(opponent);
		environmentSelection1(env);
		
		System.out.println("\tBattle Setup Complete.\n\n");
		System.out.println("\n\t----------------------------------------");
		System.out.println("\t\t   - Battle Start -");
		
		System.out.println("\n\tWarrior\t\t- VS -\t\t"+opponent.getOpponent());
		System.out.println("\n\tHP: "+warrior.getHP()+"\t\t\t\tHP: "+opponent.getHP());
		System.out.println("\tAtk: "+warrior.getAtk()+"\t\t\t\tAtk: "+opponent.getAtk());
		System.out.println("\tDef: "+warrior.getDef()+"\t\t\t\tDef: "+opponent.getDef());
		System.out.println("\tSpd: "+warrior.getSpd()+"\t\t\t\tSpd: "+opponent.getSpd());
		
		System.out.println("\n\tEnvironment: "+env.getEnvironment());
		in.nextLine();
		
		first = warrior.getSpd() > opponent.getSpd();
		
		while(true) {
			comm=0;
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");
			System.out.println("\tX Battle System X");
			
			System.out.println("\n\t["+env.getEnvironment()+"]");
			applyEnvEffects(env, warrior, opponent);
			
			
			System.out.println("\n\tWarrior: "+warrior.getHP()+"/"+maxHP);
			System.out.println("\t"+opponent.getOpponent()+": "+opponent.getHP()+"/"+oMaxHP);
			if(!skip) {
				do {
					System.out.println("\n\tBattle Commands:");
					
					System.out.println("\n\t[1] Attack");
					System.out.println("\t[2] Defend");
					System.out.println("\t[3] Charge");
					
					System.out.print("\n\tChoose your command: ");
					String code = in.nextLine();
					
					try {
						comm=Integer.parseInt(code);
					}
					catch(NumberFormatException ex) { comm=0; }
					if(comm > 3 || comm < 1) {
						System.out.println("\n\tInvalid Command Selection. Please input again.");
					}
					
					if(warrior.isCharge() && comm==3) {
						System.out.println("\n\tCharge is still in effect!\n\tYou cannot used charge twice!");
					}
					else if(comm==3 && !warrior.isCharge()){
						skip=true;
					}
				}while(comm > 3 || comm < 1 || (warrior.isCharge() && comm==3));
			}
			else {
				System.out.println("\n\tCharge is in effect!\n\tYou skip this turn!");
				skip=false;
			}
			
			if(firstStrike) {
				System.out.println("\n\t"+(first?"Warrior":opponent.getOpponent())+" strike first!");
				firstStrike=false;
			}
			
			if(first) {
				battleSystemWarrior(warrior, opponent, comm);
				battleSystemOpponent(warrior, opponent);
			}
			else {
				battleSystemOpponent(warrior, opponent);
				battleSystemWarrior(warrior, opponent, comm);
			}
			
			if(warrior.getHP()<1) {
				System.out.println("\n\tWarrior got knocked out!\n\t"+opponent.getOpponent()+" wins!");
				break;
			}
			else if(opponent.getHP()<1){
				System.out.println("\n\t"+opponent.getOpponent()+" got knocked out!\n\tWarrior wins!");
				break;
			}
			
			in.nextLine();
		}
	}
	
	// CHARACTER SETUP ------------------------------------------------------------
	public static void characterSetup(Warrior warrior) {
		
		System.out.println("\n\tCharacter Setup");
		
		armorSelection(warrior);
		weaponSelection(warrior);
	}
	
	// ARMOR SELECTION ------------------------------------------------------------
	public static void armorSelection(Warrior warrior) {
		
		in = new Scanner(System.in);
		Armor armor = null;
		int armorCode=0;
		
		do {
			System.out.println("\n\t- Armor Selection -");
			System.out.println("\t[1] Light Armor");
			System.out.println("\t[2] Medium Armor");
			System.out.println("\t[3] Heavy Armor");
			
			System.out.print("\n\tChoose your armor: ");
			String code=in.nextLine();
			// Checks the input if it's a String
			try {
				armorCode=Integer.parseInt(code);
			}
			catch(NumberFormatException ex) { armorCode=0; }
			
			switch(armorCode) {
				case 1: armor = new Armor("Light Armor", 20, 5);
						break;
				case 2:	armor = new Armor("Medium Armor", 30, 15);
						break;
				case 3: armor = new Armor("Heavy Armor", 40, 25);
						break;
				default: System.out.println("\n\tInvalid Armor Selection. Please input again.");
			}
		}while(armorCode>3 || armorCode<1);
		
		warrior.setArmor(armor);
		System.out.println("\n\t"+warrior.getArmor().getArmorType() + " selected.");
	}
	
	// WEAPON SELECTION -----------------------------------------------------------
	public static void weaponSelection(Warrior warrior) {		
		in = new Scanner(System.in);
		Weapon weapon = null;
		int weaponCode=0;
		
		do {
			System.out.println("\n\t- Weapon Selection -");
			System.out.println("\t[1] Dagger");
			System.out.println("\t[2] Sword");
			System.out.println("\t[3] Battle Axe");
			
			System.out.print("\n\tChoose your weapon: ");
			String code=in.nextLine();
			// Checks the input if it's a String
			try {
				weaponCode=Integer.parseInt(code);
			}
			catch(NumberFormatException ex) { weaponCode=0; }
			
			switch(weaponCode) {
				case 1: weapon = new Weapon("Dagger", 20, 0);
						break;
				case 2:	weapon = new Weapon("Sword", 30, 10);
						break;
				case 3: weapon = new Weapon("Battle Axe", 40, 20);
						break;
				default: System.out.println("\n\tInvalid Weapon Selection. Please input again.");
			}
		}while(weaponCode>3 || weaponCode<1);
		
		warrior.setWeapon(weapon);
		System.out.println("\n\t"+warrior.getWeapon().getWeaponType() + " selected.");
	}
	
	// OPPONENT SELECTION ---------------------------------------------------------
	public static void opponentSelection(Opponent opponent) {
		in = new Scanner(System.in);
		int opponentCode=0;
		
		do {
			System.out.println("\n\t- Opponent Selection -");
			System.out.println("\t[1] Thief");
			System.out.println("\t[2] Viking");
			System.out.println("\t[3] Minotaur");
			
			System.out.print("\n\tChoose your Opponent: ");
			String code=in.nextLine();
			// Checks the input if it's a String
			try {
				opponentCode=Integer.parseInt(code);
			}
			catch(NumberFormatException ex) { opponentCode=0; }
			
			switch(opponentCode) {
				case 1: opponent.setOpponent("Thief");
						opponent.setHP(150);
						opponent.setAtk(20);
						opponent.setDef(20);
						opponent.setSpd(40);
						opponent.setAI(new String[] {"Attack"});
						break;
				case 2:	opponent.setOpponent("Viking");
						opponent.setHP(250);
						opponent.setAtk(30);
						opponent.setDef(30);
						opponent.setSpd(30);
						opponent.setAI(new String[] {"Attack","Defend"});
						break;
				case 3: opponent.setOpponent("Minotaur");
						opponent.setHP(350);
						opponent.setAtk(40);
						opponent.setDef(40);
						opponent.setSpd(20);
						opponent.setAI(new String[] {"Attack","Charge"});
						break;
				default: System.out.println("\n\tInvalid Opponent Selection. Please input again.");
			}
		}while(opponentCode>3 || opponentCode<1);
		
		System.out.println("\n\t"+opponent.getOpponent() + " opponent selected.");

	}
	
	// ENVIRONMENT SELECTION ------------------------------------------------------
	public static void environmentSelection1(Environment env) {
		in = new Scanner(System.in);
		int envCode=0;
		
		do {
			System.out.println("\n\t- Environment Selection -");
			System.out.println("\t[1] Arena");
			System.out.println("\t[2] Swamp");
			System.out.println("\t[3] Colosseum");
			
			System.out.print("\n\tChoose your Environment: ");
			String code=in.nextLine();
			// Checks the input if it's a String
			try {
				envCode=Integer.parseInt(code);
			}
			catch(NumberFormatException ex) { envCode=0; }
			
			switch(envCode) {
				case 1: env.setEnvironment("Arena");
						env.setPlayerPenalty(0);
						env.setOpponentPenalty(0);
						break;
				case 2:	env.setEnvironment("Swamp");
						env.setPlayerPenalty(1);
						env.setOpponentPenalty(1);
						break;
				case 3: env.setEnvironment("Colosseum");
						env.setPlayerPenalty(1);
						env.setOpponentPenalty(1);
						break;
				default: System.out.println("\n\tInvalid Environment Selection. Please input again.");
			}
		}while(envCode>3 || envCode<1);
		
		System.out.println("\n\t"+env.getEnvironment() + " environment selected.");
	}

	// ENVIRONMENT SELECTION ------------------------------------------------------
	public static void environmentSelection(Environment env) {
		in = new Scanner(System.in);
		int envCode=0;
		
		do {
			System.out.println("\n\t- Environment Selection -");
			System.out.println("\t[1] Arena");
			System.out.println("\t[2] Swamp");
			System.out.println("\t[3] Colosseum");
			
			System.out.print("\n\tChoose your Environment: ");
			String code=in.nextLine();
			// Checks the input if it's a String
			try {
				envCode=Integer.parseInt(code);
			}
			catch(NumberFormatException ex) { envCode=0; }
			
			switch(envCode) {
				case 1: env.setEnvironment("Arena");
						env.setPlayerPenalty(0);
						env.setOpponentPenalty(0);
						break;
				case 2:	env.setEnvironment("Swamp");
						env.setPlayerPenalty(1);
						env.setOpponentPenalty(1);
						break;
				case 3: env.setEnvironment("Colosseum");
						env.setPlayerPenalty(1);
						env.setOpponentPenalty(1);
						break;
				default: System.out.println("\n\tInvalid Environment Selection. Please input again.");
			}
		}while(envCode>3 || envCode<1);
		
		System.out.println("\n\t"+env.getEnvironment() + " environment selected.");
	}
	
	// APPLY ENVIRONMENT EFFECTS
	public static void applyEnvEffects(Environment env, Warrior w, Opponent o) {
		
		System.out.println("\tEnvironment bonuses/penalties.");
		if(env.getEnvironment().equals("Swamp")) {
			w.setHP(w.getHP()-env.getPlayerPenalty());
			o.setAtk(o.getAtk()+env.getOpponentPenalty());
			System.out.println("\tWarrior take 1 damage every turn.");
			System.out.println("\t"+o.getOpponent()+" gains 1 attack every turn.");
		}
		else if(env.getEnvironment().equals("Colosseum")) {
			w.setAtk(w.getAtk()+env.getPlayerPenalty());
			o.setDef(o.getDef()-env.getOpponentPenalty());
			System.out.println("\tWarrior gains 1 attack every turn.");
			System.out.println("\t"+o.getOpponent()+" loses 1 defense each turn.");
		}
		else {
			System.out.println("\tNo Environment bonus/penalty.");
		}
	}
	
	// BATTLE SYSTEM WARRIOR
	public static void battleSystemWarrior(Warrior w, Opponent o, int comm) {
			int dmg=0;

			switch(comm) {
				// ATTACK *****
				case 1: dmg = w.getAtk()>o.getDef() ? w.getAtk()-o.getDef() : 0;
						if(w.isCharge()) {
							dmg=w.getAtk *3;
							w.setCharge(false);
						}
						o.setHP(o.getHP()>dmg?o.getHP()-dmg:0);
						System.out.println("\n\tWarrior used Attack!\n\t"+dmg+" damage dealt."
								+ "\n\t"+o.getOpponent()+" remaining HP: "+o.getHP());
						break;
				// DEFEND *****
				case 2:	w.setDefend(true);
						System.out.println("\n\tWarrior used Defend!\n\tIncoming damage will be reduced by 50%.");
						break;
				// CHARGE *****
				case 3: 
						w.setCharge(true);
						System.out.println("\n\tWarrior used Charge!\n\tWarrior will skip a turn.\n\tNext attack damaged ");
						break;				
			}
		
	}
	
	public static void battleSystemOpponent(Warrior w, Opponent o) {
		System.out.println("\n\tOpponent Strike!");
		int dmg=0;
		
		dmg=o.getAtk()>w.getDef() ? o.getAtk()-w.getDef() : 0;
		if(w.isDefend()){
			dmg/=2;
			w.setDefend(false);
		}
		w.setHP(w.getHP()>dmg ? w.getHP()-dmg:0);
		System.out.println("\t"+dmg+" damage dealt."
				+ "\n\tWarrior remaining HP: "+w.getHP());
	}
	

	
	*/
	
}
