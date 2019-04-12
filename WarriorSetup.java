package gui;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.border.TitledBorder;

import b.Armor;
import b.Environment;
import b.Opponent;
import b.Warrior;
import b.Weapon;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.GridLayout;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;

@SuppressWarnings("serial")
public class WarriorSetup extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup rdogrpArmor = new ButtonGroup();
	private final ButtonGroup rdogrpWeapon = new ButtonGroup();
	private final ButtonGroup rdogrpOpponent = new ButtonGroup();
	private final ButtonGroup rdogrpEnv = new ButtonGroup();
	private JRadioButton rdoLightArmor;
	private JRadioButton rdoMediumArmor;
	private JRadioButton rdoHeavyArmor;
	private JRadioButton rdoDagger;
	private JRadioButton rdoSword;
	private JRadioButton rdoBattleAxe;
	private JRadioButton rdoThief;
	private JRadioButton rdoViking;
	private JRadioButton rdoMinotaur;
	private JRadioButton rdoArena;
	private JRadioButton rdoSwamp;
	private JRadioButton rdoColosseum;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WarriorSetup frame = new WarriorSetup();
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
	public WarriorSetup() {
		setResizable(false);
		setTitle("Battle System 1.0 - Warrior Setup");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel pnlOptions = new JPanel();
		contentPane.add(pnlOptions);
		pnlOptions.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel pnlArmorSelect = new JPanel();
		pnlOptions.add(pnlArmorSelect);
		pnlArmorSelect.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Armor Selection", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlArmorSelect.setLayout(new BorderLayout(0, 0));
		
		JPanel pnlArmorRadio = new JPanel();
		pnlArmorSelect.add(pnlArmorRadio, BorderLayout.WEST);
		pnlArmorRadio.setLayout(new GridLayout(0, 1, 0, 0));
		
		rdoLightArmor = new JRadioButton("");
		pnlArmorRadio.add(rdoLightArmor);
		rdogrpArmor.add(rdoLightArmor);
		rdoLightArmor.setHorizontalAlignment(SwingConstants.LEFT);
		
		rdoMediumArmor = new JRadioButton("");
		pnlArmorRadio.add(rdoMediumArmor);
		rdogrpArmor.add(rdoMediumArmor);
		
		rdoHeavyArmor = new JRadioButton("");
		pnlArmorRadio.add(rdoHeavyArmor);
		rdogrpArmor.add(rdoHeavyArmor);
		
		JPanel pnlArmorLabel = new JPanel();
		pnlArmorSelect.add(pnlArmorLabel, BorderLayout.CENTER);
		pnlArmorLabel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblLightArmor = new JLabel("Light Armor                +20 DEF -5 SPD");
		pnlArmorLabel.add(lblLightArmor);
		lblLightArmor.setIcon(new ImageIcon(WarriorSetup.class.getResource("/gui/images/light_armor.gif")));
		
		JLabel lblMediumArmor = new JLabel("Medium Armor           +30 DEF -15 SPD");
		pnlArmorLabel.add(lblMediumArmor);
		lblMediumArmor.setIcon(new ImageIcon(WarriorSetup.class.getResource("/gui/images/medium_armor.gif")));
		
		JLabel lblHeavyArmor = new JLabel("Heavy Armor              +40 DEF -25 SPD");
		pnlArmorLabel.add(lblHeavyArmor);
		lblHeavyArmor.setIcon(new ImageIcon(WarriorSetup.class.getResource("/gui/images/heavy_armor.gif")));
		
		JPanel pnlWeaponSelect = new JPanel();
		pnlOptions.add(pnlWeaponSelect);
		pnlWeaponSelect.setBorder(new TitledBorder(null, "Weapon Selection", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlWeaponSelect.setLayout(new BorderLayout(0, 0));
		
		JPanel pnlWeaponRadio = new JPanel();
		pnlWeaponSelect.add(pnlWeaponRadio, BorderLayout.WEST);
		pnlWeaponRadio.setLayout(new GridLayout(0, 1, 0, 0));
		
		rdoDagger = new JRadioButton("");
		pnlWeaponRadio.add(rdoDagger);
		rdogrpWeapon.add(rdoDagger);
		
		rdoSword = new JRadioButton("");
		pnlWeaponRadio.add(rdoSword);
		rdogrpWeapon.add(rdoSword);
		
		rdoBattleAxe = new JRadioButton("");
		pnlWeaponRadio.add(rdoBattleAxe);
		rdogrpWeapon.add(rdoBattleAxe);
		
		JPanel pnlWeaponLabel = new JPanel();
		pnlWeaponSelect.add(pnlWeaponLabel, BorderLayout.CENTER);
		pnlWeaponLabel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblDagger = new JLabel("Dagger                       +20 ATK");
		lblDagger.setIcon(new ImageIcon(WarriorSetup.class.getResource("/gui/images/dagger.gif")));
		pnlWeaponLabel.add(lblDagger);
		
		JLabel lblSword = new JLabel("Sword                         +30 ATK -10 SPD");
		lblSword.setIcon(new ImageIcon(WarriorSetup.class.getResource("/gui/images/sword.gif")));
		pnlWeaponLabel.add(lblSword);
		
		JLabel lblBattleAxe = new JLabel("Battle Axe                  +40 ATK -20 SPD");
		lblBattleAxe.setIcon(new ImageIcon(WarriorSetup.class.getResource("/gui/images/battle_axe.gif")));
		pnlWeaponLabel.add(lblBattleAxe);
		
		JPanel pnlOpponentSelect = new JPanel();
		pnlOptions.add(pnlOpponentSelect);
		pnlOpponentSelect.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Opponent Selection", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlOpponentSelect.setLayout(new BorderLayout(0, 0));
		
		JPanel pnlOpponentRadio = new JPanel();
		pnlOpponentSelect.add(pnlOpponentRadio, BorderLayout.WEST);
		pnlOpponentRadio.setLayout(new GridLayout(0, 1, 0, 0));
		
		rdoThief = new JRadioButton("");
		pnlOpponentRadio.add(rdoThief);
		rdogrpOpponent.add(rdoThief);
		
		rdoViking = new JRadioButton("");
		pnlOpponentRadio.add(rdoViking);
		rdogrpOpponent.add(rdoViking);
		
		rdoMinotaur = new JRadioButton("");
		pnlOpponentRadio.add(rdoMinotaur);
		rdogrpOpponent.add(rdoMinotaur);
		
		JPanel pnlOpponentLabel = new JPanel();
		pnlOpponentSelect.add(pnlOpponentLabel, BorderLayout.CENTER);
		pnlOpponentLabel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblThief = new JLabel("Thief                             HP: 150 ATK: 20 DEF: 20 SPD: 40");
		lblThief.setLabelFor(lblThief);
		lblThief.setIcon(new ImageIcon(WarriorSetup.class.getResource("/gui/images/thief.gif")));
		pnlOpponentLabel.add(lblThief);
		
		JLabel lblViking = new JLabel("Viking                           HP: 250 ATK: 30 DEF: 30 SPD: 30");
		lblViking.setIcon(new ImageIcon(WarriorSetup.class.getResource("/gui/images/viking.gif")));
		pnlOpponentLabel.add(lblViking);
		
		JLabel lblMinotaur = new JLabel("Minotaur                      HP: 350 ATK: 40 DEF: 40 SPD: 20");
		lblMinotaur.setIcon(new ImageIcon(WarriorSetup.class.getResource("/gui/images/minotaur.gif")));
		pnlOpponentLabel.add(lblMinotaur);
		
		JPanel pnlEnvironmentSelect = new JPanel();
		pnlOptions.add(pnlEnvironmentSelect);
		pnlEnvironmentSelect.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Environment Selection", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlEnvironmentSelect.setLayout(new BorderLayout(0, 0));
		
		JPanel pnlEnvRadio = new JPanel();
		pnlEnvironmentSelect.add(pnlEnvRadio, BorderLayout.WEST);
		pnlEnvRadio.setLayout(new GridLayout(0, 1, 0, 0));
		
		rdoArena = new JRadioButton("");
		pnlEnvRadio.add(rdoArena);
		rdogrpEnv.add(rdoArena);
		
		rdoSwamp = new JRadioButton("");
		pnlEnvRadio.add(rdoSwamp);
		rdogrpEnv.add(rdoSwamp);
		
		rdoColosseum = new JRadioButton("");
		pnlEnvRadio.add(rdoColosseum);
		rdogrpEnv.add(rdoColosseum);
		
		JPanel pnlEnvLabel = new JPanel();
		pnlEnvironmentSelect.add(pnlEnvLabel, BorderLayout.CENTER);
		pnlEnvLabel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblArena = new JLabel("Arena            No Penalty");
		lblArena.setIcon(new ImageIcon(WarriorSetup.class.getResource("/gui/images/arena.gif")));
		pnlEnvLabel.add(lblArena);
		
		JLabel lblSwamp = new JLabel("Swamp        Player takes 1 damage every turn, Opponent gains 1 ATK every turn.");
		lblSwamp.setIcon(new ImageIcon(WarriorSetup.class.getResource("/gui/images/swamp.gif")));
		pnlEnvLabel.add(lblSwamp);
		
		JLabel lblColosseum = new JLabel("Colosseum  Players gains 1 ATK every turn, Opponent loses 1 DEF each turn.");
		lblColosseum.setIcon(new ImageIcon(WarriorSetup.class.getResource("/gui/images/colosseum.gif")));
		pnlEnvLabel.add(lblColosseum);
		
		JPanel pnlTitle = new JPanel();
		contentPane.add(pnlTitle, BorderLayout.NORTH);
		
		JLabel lblTitle = new JLabel("Warrior Setup");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 25));
		pnlTitle.add(lblTitle);
		
		JPanel pnlButtons = new JPanel();
		contentPane.add(pnlButtons, BorderLayout.SOUTH);
		pnlButtons.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		JButton btnBegin = new JButton("Begin Battle");
		btnBegin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnBeginActionPerformed(arg0);
			}
		});
		pnlButtons.add(btnBegin);
		
		JButton btnReset = new JButton("Reset Selection");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnResetActionPerformed(e);
			}
		});
		pnlButtons.add(btnReset);
		
		
	}
	// EVENT HANDLERS
	
	// When the user hits Reset Button
	public void btnResetActionPerformed(java.awt.event.ActionEvent evt) {
		this.rdogrpArmor.clearSelection();
		this.rdogrpWeapon.clearSelection();
		this.rdogrpOpponent.clearSelection();
		this.rdogrpEnv.clearSelection();
	}
	
	// WHen the user hits Begin Battle Button
	public void btnBeginActionPerformed(java.awt.event.ActionEvent evt) {
		//for testing
		// JOptionPane.showMessageDialog(this, this.rdogrpArmor.getSelection().toString());
		String armorError="", weaponError="",oppoError="", envError="";
		Warrior w = new Warrior();
		Opponent o = null;
		Environment e = null;
		
		if(this.rdogrpArmor.getSelection() == this.rdoLightArmor.getModel()) {
			w.setArmor(new Armor("Light Armor", 20, 5));
		}
		else if(this.rdogrpArmor.getSelection() == this.rdoMediumArmor.getModel()) {
			w.setArmor(new Armor("Medium Armor", 30, 15));
		}
		else if(this.rdogrpArmor.getSelection() == this.rdoHeavyArmor.getModel()) {
			w.setArmor(new Armor("Heavy Armor", 40, 25));
		}
		else {
			armorError = "Please choose an armor!\n";
		}
		
		if(this.rdogrpWeapon.getSelection() == this.rdoDagger.getModel()) {
			w.setWeapon(new Weapon("Dagger", 20, 0));
		}
		else if(this.rdogrpWeapon.getSelection() == this.rdoSword.getModel()) {
			w.setWeapon(new Weapon("Sword", 30, 10));
		}
		else if(this.rdogrpWeapon.getSelection() == this.rdoBattleAxe.getModel()) {
			w.setWeapon(new Weapon("Battle Axe", 40, 20));
		}
		else {
			weaponError = "Please choose a weapon!\n";
		}
		
		if(this.rdogrpOpponent.getSelection() == this.rdoThief.getModel()) {
			o = new Opponent("Thief",150,20,20,40);
		}
		else if(this.rdogrpOpponent.getSelection() == this.rdoViking.getModel()) {
			o = new Opponent("Viking",250,30,30,30);
		}
		else if(this.rdogrpOpponent.getSelection() == this.rdoMinotaur.getModel()) {
			o = new Opponent("Minotaur",350,40,40,20);
		}
		else {
			oppoError = "Please choose an opponent!\n";
		}
		
		if(this.rdogrpEnv.getSelection() == this.rdoArena.getModel()) {
			e = new Environment("Arena", 0, 0);
		}
		else if(this.rdogrpEnv.getSelection() == this.rdoSwamp.getModel()) {
			e = new Environment("Swamp", 1, 1);
		}
		else if(this.rdogrpEnv.getSelection() == this.rdoColosseum.getModel()) {
			e = new Environment("Colosseum", 1, 1);
		}
		else {
			envError = "Please choose a Battle Area!\n";
		}
		
		if(!armorError.isEmpty() || !weaponError.isEmpty() || !oppoError.isEmpty() || !envError.isEmpty()) {
			JOptionPane.showMessageDialog(this, armorError+weaponError+oppoError+envError, "Warrior Setup Error", 0);
		}
		else {
			BattleSystem newFrm = new BattleSystem(w,e,o);
			newFrm.setVisible(true);
			this.dispose();
		}
		
	}

}
