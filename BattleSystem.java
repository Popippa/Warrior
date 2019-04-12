/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import b.Environment;
import b.Opponent;
import b.Warrior;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.Font;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.SystemColor;
import java.util.ArrayList;

import javax.swing.border.LineBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BattleSystem extends JFrame {

	private JPanel contentPane;
	private JLabel lblEnvIcon;
	private JLabel lblEnvName;
	private JLabel lblOpponentIcon;
	private JLabel lblOpponentName; 
	private JLabel lblArmorIcon;
	private JLabel lblWeaponIcon;
	private JLabel lblArmorInfo;
	private JLabel lblWeaponInfo; 
	private JProgressBar pbarWarriorHP;
	private JProgressBar pbarOpponentHP;
	private JLabel lblWStatATK;
	private JLabel lblWStatDEF;
	private JLabel lblWStatSPD;
	private JLabel lblOStatATK;
	private JLabel lblOStatDEF;
	private JLabel lblOStatSPD;
	private JLabel lblWStrikeFirst;
	private JLabel lblOStrikeFirst;
	private JLabel lblStatus;
	private JLabel lblWDefend;
	private JLabel lblWCharge;
	private JLabel lblODefend;
	private JLabel lblOCharge;
	private JList<String> listOpponent;
	private JList<String> listWarrior;
	private String wComm;
	private String oComm;
	private JScrollPane wScroll = new JScrollPane();
	private JScrollPane oScroll = new JScrollPane();
	private JComboBox<String> cboCommandList;
	private ArrayList<String> wCommList = new ArrayList<>();
	private ArrayList<String> oCommList = new ArrayList<>();
	private int wMaxHP;
	private int oMaxHP;
	private Warrior w;
	private Environment e;
	private Opponent o;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BattleSystem frame = new BattleSystem();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BattleSystem() {
		
		initComponents();
	}
	
	public BattleSystem(Warrior w, Environment e, Opponent o) {
		initComponents();
		this.w=w;
		this.e=e;
		this.o=o;
		
		this.lblEnvIcon.setIcon(new ImageIcon(BattleSystem.class.getResource("/gui/images/"+e.getEnvironment().toLowerCase()+".gif")));
		if(e.getEnvironment().equals("Arena")) {
			this.lblEnvName.setText(this.lblEnvName.getText()+"Arena - No Penalty");
		}
		else if(e.getEnvironment().equals("Swamp")) {
			this.lblEnvName.setText(this.lblEnvName.getText()+"Swamp - Player takes 1 damage every turn, Opponent gains 1 ATK every turn.");
		}
		else {
			this.lblEnvName.setText(this.lblEnvName.getText()+"Colosseum - Players gains 1 ATK every turn, Opponent loses 1 DEF each turn.");
		}
		
		this.lblOpponentIcon.setIcon(new ImageIcon(BattleSystem.class.getResource("/gui/images/"+o.getOpponent().toLowerCase()+".gif")));
		this.lblOpponentName.setText(o.getOpponent());
		
		//JOptionPane.showMessageDialog(this, "/gui/images/"+w.getArmor().getArmorType().toLowerCase().replace(' ', '_')+".gif\n"+w.getArmor().getArmorType());
		this.lblArmorIcon.setIcon(new ImageIcon(BattleSystem.class.getResource("/gui/images/"+w.getArmor().getArmorType().toLowerCase().replace(' ', '_')+".gif")));
		this.lblArmorInfo.setText("Armor: "+this.w.getArmor().getArmorType() + " +" + this.w.getArmor().getDef() + " DEF"
				+ " -" + this.w.getArmor().getSpdPenalty() + " SPD");
		this.lblWeaponInfo.setText("Weapon: "+this.w.getWeapon().getWeaponType() + " +" + this.w.getWeapon().getAtk() + " ATK"
				+ " -" + this.w.getWeapon().getSpdPenalty()+ " SPD");
		
		this.lblWeaponIcon.setIcon(new ImageIcon(BattleSystem.class.getResource("/gui/images/"+w.getWeapon().getWeaponType().toLowerCase().replace(' ', '_')+".gif")));
		
		wMaxHP = this.w.getHP();
		oMaxHP = this.o.getHP();
		
		this.pbarWarriorHP.setString(this.w.getHP()+"/"+wMaxHP);
		this.pbarOpponentHP.setString(this.o.getHP()+"/"+oMaxHP);
		
		this.pbarOpponentHP.setMaximum(oMaxHP);
		this.pbarOpponentHP.setValue((this.o.getHP()));
		
		this.updateStats();
		
		if(this.w.getSpd() > this.o.getSpd()) {
			this.lblWStrikeFirst.setVisible(true);
			this.lblStatus.setText("Warrior strikes first!");
		}
		else {
			this.lblOStrikeFirst.setVisible(true);
			this.lblStatus.setText(this.o.getOpponent()+" strikes first!");
		}
		
		this.applyEnvEffects();
		this.updateStats();
	}
	
	/*
	 *  Change color of the Progress Bar 
	 *  Green - equal or more than 50%
	 *  Yellow - equal or less than 50%
	 *  Red - equal or less than 20%
	*/
	public void changeProgressBarColor(JProgressBar jp) {
		// setForeground(new Color(0, 128, 0)); GREEN
		// setForeground(new Color(255, 204, 0)); YELLOW
		// setForeground(new Color(255, 0, 0)); RED
		if(jp.getValue()<=jp.getMaximum()/2 && jp.getValue()>jp.getMaximum()*.2) {
			jp.setForeground(new Color(255, 204, 0));
		}
		else if(jp.getValue()<=jp.getMaximum()*.2) {
			jp.setForeground(new Color(255, 0, 0));
		}
	}
	
	public void applyEnvEffects(){
		if(e.getEnvironment().equals("Swamp")) {
			w.setHP(w.getHP()-e.getPlayerPenalty());
			o.setAtk(o.getAtk()+e.getOpponentPenalty());
		}
		else if(e.getEnvironment().equals("Colosseum")) {
			w.setAtk(w.getAtk()+e.getPlayerPenalty());
			if(o.getDef() > 0)
				o.setDef(o.getDef()-e.getOpponentPenalty());
		}
	}
	
	public void initComponents() {
		setTitle("Battle System 1.0 - Battle Area");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		setResizable(false);

		
		JPanel pnlBattleSystemInfo = new JPanel();
		FlowLayout flowLayout = (FlowLayout) pnlBattleSystemInfo.getLayout();
		flowLayout.setHgap(15);
		flowLayout.setAlignment(FlowLayout.LEFT);
		contentPane.add(pnlBattleSystemInfo, BorderLayout.NORTH);
		
		lblEnvIcon = new JLabel("");
		pnlBattleSystemInfo.add(lblEnvIcon);
		
		lblEnvName = new JLabel("Environment: ");
		pnlBattleSystemInfo.add(lblEnvName);
		
		JPanel pnlBattleArea = new JPanel();
		contentPane.add(pnlBattleArea, BorderLayout.CENTER);
		pnlBattleArea.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel pnlWarrior = new JPanel();
		pnlWarrior.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlBattleArea.add(pnlWarrior);
		pnlWarrior.setLayout(new BorderLayout(0, 0));
		
		JPanel pnlWarriorTitle = new JPanel();
		pnlWarrior.add(pnlWarriorTitle, BorderLayout.NORTH);
		
		JLabel lblWarriorIcon = new JLabel("");
		lblWarriorIcon.setIcon(new ImageIcon(BattleSystem.class.getResource("/gui/images/warrior.gif")));
		pnlWarriorTitle.add(lblWarriorIcon);
		
		JLabel lblWarriorName = new JLabel("Warrior");
		lblWarriorName.setFont(new Font("Tahoma", Font.BOLD, 16));
		pnlWarriorTitle.add(lblWarriorName);
		
		JPanel pnlWarriorInfo = new JPanel();
		pnlWarrior.add(pnlWarriorInfo, BorderLayout.CENTER);
		pnlWarriorInfo.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		pnlWarriorInfo.add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel pnlWHP = new JPanel();
		panel.add(pnlWHP);
		pnlWHP.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblHP = new JLabel("Health Points: ");
		pnlWHP.add(lblHP);
		
		pbarWarriorHP = new JProgressBar();
		pnlWHP.add(pbarWarriorHP);
		pbarWarriorHP.setForeground(new Color(0, 128, 0));
		pbarWarriorHP.setFont(new Font("Tahoma", Font.BOLD, 11));
		pbarWarriorHP.setStringPainted(true);
		pbarWarriorHP.setValue(100);
		
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panel_2.getLayout();
		flowLayout_3.setVgap(3);
		flowLayout_3.setHgap(15);
		panel.add(panel_2);
		
		lblWStrikeFirst = new JLabel("");
		lblWStrikeFirst.setToolTipText("Strike First");
		lblWStrikeFirst.setIcon(new ImageIcon(BattleSystem.class.getResource("/gui/images/strike_first.gif")));
		panel_2.add(lblWStrikeFirst);
		
		lblWCharge = new JLabel("");
		lblWCharge.setToolTipText("Charge!");
		lblWCharge.setEnabled(false);
		lblWCharge.setIcon(new ImageIcon(BattleSystem.class.getResource("/gui/images/charge.gif")));
		panel_2.add(lblWCharge);
		
		lblWDefend = new JLabel("");
		lblWDefend.setToolTipText("Defend");
		lblWDefend.setEnabled(false);
		lblWDefend.setIcon(new ImageIcon(BattleSystem.class.getResource("/gui/images/defend.gif")));
		panel_2.add(lblWDefend);
		
		lblWStatATK = new JLabel("ATK:");
		panel_2.add(lblWStatATK);
		
		lblWStatDEF = new JLabel("DEF:");
		panel_2.add(lblWStatDEF);
		
		lblWStatSPD = new JLabel("SPD:");
		panel_2.add(lblWStatSPD);
		
		JPanel pnlWArmor = new JPanel();
		panel.add(pnlWArmor);
		FlowLayout flowLayout_4 = (FlowLayout) pnlWArmor.getLayout();
		flowLayout_4.setVgap(10);
		
		lblArmorIcon = new JLabel("");
		pnlWArmor.add(lblArmorIcon);
		
		lblArmorInfo = new JLabel("Armor: ");
		pnlWArmor.add(lblArmorInfo);
		
		JPanel pnlWarriorStats = new JPanel();
		pnlWarriorInfo.add(pnlWarriorStats);
		pnlWarriorStats.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_5 = new JPanel();
		pnlWarriorStats.add(panel_5);
		FlowLayout flowLayout_5 = (FlowLayout) panel_5.getLayout();
		flowLayout_5.setVgap(10);
		
		lblWeaponIcon = new JLabel("");
		panel_5.add(lblWeaponIcon);
		
		lblWeaponInfo = new JLabel("Weapon: ");
		panel_5.add(lblWeaponInfo);
		
		JPanel panel_1 = new JPanel();
		pnlWarriorStats.add(panel_1);
		
		JPanel panel_10 = new JPanel();
		pnlWarriorStats.add(panel_10);
		FlowLayout flowLayout_1 = (FlowLayout) panel_10.getLayout();
		flowLayout_1.setVgap(8);
		
		JLabel lblCommandList = new JLabel("Command List: ");
		panel_10.add(lblCommandList);
		
		cboCommandList = new JComboBox<>();
		panel_10.add(cboCommandList);
		cboCommandList.setModel(new DefaultComboBoxModel<>(new String[] {"Choose..                          ", "Attack", "Defend", "Charge"}));
		
		JPanel pnlWCommands = new JPanel();
		pnlWarriorInfo.add(pnlWCommands);
		pnlWCommands.setLayout(new GridLayout(0, 1, 0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new TitledBorder(null, "Command History", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlWCommands.add(scrollPane);
		
		
		JPanel pnlOpponent = new JPanel();
		pnlOpponent.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlBattleArea.add(pnlOpponent);
		pnlOpponent.setLayout(new BorderLayout(0, 0));
		
		JPanel pnlOpponentTitle = new JPanel();
		pnlOpponent.add(pnlOpponentTitle, BorderLayout.NORTH);
		
		lblOpponentIcon = new JLabel("");
		lblOpponentIcon.setIcon(new ImageIcon(BattleSystem.class.getResource("/gui/images/thief.gif")));
		pnlOpponentTitle.add(lblOpponentIcon);
		
		lblOpponentName = new JLabel("Opponent");
		lblOpponentName.setFont(new Font("Tahoma", Font.BOLD, 16));
		pnlOpponentTitle.add(lblOpponentName);
		
		JPanel pnlOpponentInfo = new JPanel();
		pnlOpponent.add(pnlOpponentInfo, BorderLayout.CENTER);
		pnlOpponentInfo.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_7 = new JPanel();
		pnlOpponentInfo.add(panel_7);
		panel_7.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_6 = new JPanel();
		panel_7.add(panel_6);
		
		JLabel lblOHP = new JLabel("Health Points: ");
		panel_6.add(lblOHP);
		
		pbarOpponentHP = new JProgressBar();
		panel_6.add(pbarOpponentHP);
		pbarOpponentHP.setForeground(new Color(0, 128, 0));
		pbarOpponentHP.setFont(new Font("Tahoma", Font.BOLD, 11));
		pbarOpponentHP.setStringPainted(true);
		pbarOpponentHP.setValue(100);
		
		JPanel pnlOpponentStats = new JPanel();
		panel_7.add(pnlOpponentStats);
		FlowLayout flowLayout_2 = (FlowLayout) pnlOpponentStats.getLayout();
		flowLayout_2.setVgap(3);
		flowLayout_2.setHgap(15);
		
		lblOStrikeFirst = new JLabel("");
		lblOStrikeFirst.setToolTipText("Strike First");
		lblOStrikeFirst.setIcon(new ImageIcon(BattleSystem.class.getResource("/gui/images/strike_first.gif")));
		pnlOpponentStats.add(lblOStrikeFirst);
		
		lblOCharge = new JLabel("");
		lblOCharge.setToolTipText("Charge!");
		lblOCharge.setEnabled(false);
		lblOCharge.setIcon(new ImageIcon(BattleSystem.class.getResource("/gui/images/charge.gif")));
		pnlOpponentStats.add(lblOCharge);
		
		lblODefend = new JLabel("");
		lblODefend.setToolTipText("Defend");
		lblODefend.setEnabled(false);
		lblODefend.setIcon(new ImageIcon(BattleSystem.class.getResource("/gui/images/defend.gif")));
		pnlOpponentStats.add(lblODefend);
		
		lblOStatATK = new JLabel("ATK:");
		pnlOpponentStats.add(lblOStatATK);
		
		lblOStatDEF = new JLabel("DEF:");
		pnlOpponentStats.add(lblOStatDEF);
		
		lblOStatSPD = new JLabel("SPD:");
		pnlOpponentStats.add(lblOStatSPD);
		
		JPanel panel_3 = new JPanel();
		panel_7.add(panel_3);
		
		JPanel panel_8 = new JPanel();
		pnlOpponentInfo.add(panel_8);
		
		listOpponent = new JList<>();
		
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setViewportBorder(new TitledBorder(null, "Command History", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlOpponentInfo.add(scrollPane_1);
		scrollPane_1.setViewportView(listOpponent);
		
		
		
		//this.oScroll.setViewportView(listOpponent);
		
		JPanel pnlEast = new JPanel();
		contentPane.add(pnlEast, BorderLayout.EAST);
		
		JPanel pnlWest = new JPanel();
		contentPane.add(pnlWest, BorderLayout.WEST);
		
		JPanel pnlSouth = new JPanel();
		contentPane.add(pnlSouth, BorderLayout.SOUTH);
		pnlSouth.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_12 = new JPanel();
		FlowLayout flowLayout_6 = (FlowLayout) panel_12.getLayout();
		flowLayout_6.setAlignment(FlowLayout.LEFT);
		pnlSouth.add(panel_12);
		
		lblStatus = new JLabel("New label");
		lblStatus.setForeground(Color.BLACK);
		lblStatus.setFont(new Font("Dialog", Font.BOLD, 14));
		panel_12.add(lblStatus);
		
		JPanel panel_4 = new JPanel();
		FlowLayout flowLayout_7 = (FlowLayout) panel_4.getLayout();
		flowLayout_7.setAlignment(FlowLayout.RIGHT);
		pnlSouth.add(panel_4);
		
		JButton btnStartBattle = new JButton("Start Battle Round");
		btnStartBattle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnStartBattleActionPerformed(arg0);
			}
		});
		panel_4.add(btnStartBattle);
		
		this.lblWStrikeFirst.setVisible(false);
		this.lblOStrikeFirst.setVisible(false);
		
		listWarrior = new JList<>();
		//pnlWCommands.add(listWarrior);
		scrollPane.setViewportView(listWarrior);
	}
	
	public void btnStartBattleActionPerformed(ActionEvent evt) {
		String comm = this.cboCommandList.getSelectedItem().toString();
		String ocomm = this.o.think();
		this.o.setLastCommand(ocomm);
		
		if(!comm.equalsIgnoreCase("Choose..                          ")) {
			if(comm.equalsIgnoreCase("charge") && this.w.isCharge()) {
				this.lblStatus.setForeground(Color.RED);
				this.lblStatus.setText("You cannot charge twice.");
			}
			else {
				if(comm.equalsIgnoreCase("defend")) {
					this.w.setDefend(true);
					this.lblWDefend.setEnabled(true);
				}
				else {
					this.lblWDefend.setEnabled(false);
				}
				if(ocomm.equalsIgnoreCase("defend")) {
					this.o.setDefend(true);
					this.lblODefend.setEnabled(true);
				}
				else {
					this.lblODefend.setEnabled(false);
				}
				
				if(this.lblWStrikeFirst.isVisible()) {
					warriorBattleSystem();
					opponentBattleSystem(ocomm);
				}
				else {
					opponentBattleSystem(ocomm);
					warriorBattleSystem();
				}
				this.wCommList.add(wComm);
				this.oCommList.add(oComm);
				
				this.applyEnvEffects();
				this.updateStats();
				this.w.setDefend(false);
				this.o.setDefend(false);
				
				this.lblStatus.setText(this.wComm + this.oComm);
				
				if(w.getHP()<1) {
					JOptionPane.showMessageDialog(this,"Warrior got knocked out!\n\t"+o.getOpponent()+" wins!");
					this.dispose();
					WarriorSetup newFrm = new WarriorSetup();
					newFrm.setVisible(true);
				}
				else if(o.getHP()<1){
					JOptionPane.showMessageDialog(this,o.getOpponent()+" got knocked out!\n\tWarrior wins!");
					this.dispose();
					WarriorSetup newFrm = new WarriorSetup();
					newFrm.setVisible(true);
				}
			}
		}
		else {
			this.lblStatus.setForeground(Color.RED);
			this.lblStatus.setText("Please choose a command.");
		}
	}
	
	public void warriorBattleSystem() {
		
		String comm = this.cboCommandList.getSelectedItem().toString().toLowerCase();
		int dmg = 0;
		int x = this.w.isCharge() ? 3 : 1;
		this.lblStatus.setForeground(Color.BLACK);
		
		switch(comm) {
		
			case "attack":
				dmg = (this.w.getAtk() * x) > o.getDef() ? this.w.getAtk() * x - o.getDef() : 0;
				if(this.o.isDefend()) {
					dmg/=2;
				}	
				this.w.setCharge(false);
				this.lblWCharge.setEnabled(false);
				
				o.setHP(o.getHP()>dmg ? o.getHP()-dmg :0);
				this.wComm = "Warrior used Attack! ";
				break;
				
			case "defend":
				this.wComm = "Warrior used Defend! ";
				break;
				
			case "charge":
				this.w.setCharge(true);
				this.lblWCharge.setEnabled(true);
				this.wComm = "Warrior used Charge! ";
				break;
		}
		
	}
	public void opponentBattleSystem(String comm) {
		int dmg = 0;
		
		int x = this.o.isCharge() ? 3 : 1;
		this.lblStatus.setForeground(Color.BLACK);
		
		switch(comm) {
		
			case "attack":
				dmg = (this.o.getAtk() * x) > this.w.getDef() ? (this.o.getAtk() * x) - this.w.getDef() : 0;
				if(this.w.isDefend()) {
					dmg/=2;
				}	
				this.o.setCharge(false);
				this.lblOCharge.setEnabled(false);
				
				w.setHP(w.getHP()>dmg ? w.getHP()-dmg : 0);
				
				this.oComm = this.o.getOpponent()+" used Attack! ";
				break;
			case "defend":
				this.oComm = this.o.getOpponent()+" used Defend! ";
				break;
				
			case "charge":
				this.o.setCharge(true);
				this.lblOCharge.setEnabled(true);
				this.oComm = this.o.getOpponent()+" used Charge! ";
				break;
		}
	}
	
	public void updateStats() {
		if(w.getHP()<0)
			w.setHP(0);
		this.lblWStatATK.setText("ATK: "+ this.w.getAtk());
		this.lblWStatDEF.setText("DEF: "+ this.w.getDef());
		this.lblWStatSPD.setText("SPD: "+ this.w.getSpd());
		
		this.lblOStatATK.setText("ATK: "+ this.o.getAtk());
		this.lblOStatDEF.setText("DEF: "+ this.o.getDef());
		this.lblOStatSPD.setText("SPD: "+ this.o.getSpd());
		
		this.pbarWarriorHP.setString(this.w.getHP()+"/"+wMaxHP);
		this.pbarOpponentHP.setString(this.o.getHP()+"/"+oMaxHP);
		
		this.pbarWarriorHP.setValue((this.w.getHP()));
		this.pbarOpponentHP.setValue((this.o.getHP()));
		
		this.changeProgressBarColor(this.pbarWarriorHP);
		this.changeProgressBarColor(this.pbarOpponentHP);
		
		DefaultListModel<String> dlm = new DefaultListModel<>();
		for(String s: this.wCommList) {
			dlm.addElement(s);
		}
		this.listWarrior.setModel(dlm);
		
		DefaultListModel<String> dlm2 = new DefaultListModel<>();
		for(String s: this.oCommList) {
			dlm2.addElement(s);
		}
		this.listOpponent.setModel(dlm2);
	}

}
