import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.*;

@SuppressWarnings("serial")
public class MainPanel extends JPanel {
	
	CardLayout cl = new CardLayout();
	StartMenu startMenu = new StartMenu();
	HelpMenu helpMenu = new HelpMenu();
	ChoosePlayerMenu choosePlayerMenu = new ChoosePlayerMenu();
	SetNameMenu setNameMenu = new SetNameMenu();
	BidMenu bidMenu = new BidMenu();
	ChooseColorMenu chooseColorMenu = new ChooseColorMenu();
	ChooseTeammateMenu chooseTeammateMenu = new ChooseTeammateMenu();
	InfoMenu infoMenu = new InfoMenu();
	
	
	public MainPanel() {
		
		setPreferredSize(new Dimension(1280, 720));
		setLayout(cl);
		
		Game.startGame();
		
		add(startMenu, "Start");
		add(helpMenu, "Help");
		add(choosePlayerMenu, "Choose");
		add(setNameMenu, "SetName");
		add(bidMenu, "Bid");
		add(chooseColorMenu, "Color");
		add(chooseTeammateMenu, "Teammate");
		add(infoMenu, "Info");
		
		
		startMenu.playButton.addActionListener((e) -> cl.show(this, "Choose"));
		startMenu.helpButton.addActionListener((e) -> cl.show(this, "Help"));
		helpMenu.backButton.addActionListener((e) -> cl.show(this, "Start"));
		choosePlayerMenu.backButton.addActionListener((e) -> cl.show(this, "Start"));
		choosePlayerMenu.nextButton.addActionListener((e) -> { 
			if(Game.numOfPlayer == 0) {
				JOptionPane.showMessageDialog(null, "Please choose the number of player", "Error" , JOptionPane.ERROR_MESSAGE);
			} else {
				if(Game.numOfPlayer < 4) {
					setNameMenu.textField4.setText("Computer 4");
					setNameMenu.textField4.setEditable(false);
					if(Game.numOfPlayer < 3) {
						setNameMenu.textField3.setText("Computer 3");
						setNameMenu.textField3.setEditable(false);
						if (Game.numOfPlayer < 2) {
							setNameMenu.textField2.setText("Computer 2");
							setNameMenu.textField2.setEditable(false);
						}
					}
				}
				cl.show(this, "SetName");
			}
		});		
		setNameMenu.backButton.addActionListener((e) -> {
			setNameMenu.textField1.setText("Player 1");
			setNameMenu.textField2.setText("Player 2");
			setNameMenu.textField3.setText("Player 3");
			setNameMenu.textField4.setText("Player 4");
			setNameMenu.textField2.setEditable(true);
			setNameMenu.textField3.setEditable(true);
			setNameMenu.textField4.setEditable(true);
			cl.show(this, "Choose");
		});
		setNameMenu.nextButton.addActionListener((e) -> {
			JOptionPane.showMessageDialog(null,  "Name set successfully");
			Game.players[0].name = setNameMenu.textField1.getText();
			Game.players[1].name = setNameMenu.textField2.getText();
			Game.players[2].name = setNameMenu.textField3.getText();
			Game.players[3].name = setNameMenu.textField4.getText();
			bidMenu.label1.setText(Game.players[0].name);
			bidMenu.label2.setText(Game.players[1].name);
			bidMenu.label3.setText(Game.players[2].name);
			bidMenu.label4.setText(Game.players[3].name);
			cl.show(this, "Bid");
		});
		bidMenu.backButton.addActionListener((e) -> {
			int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to back to previous menu? The progress will not be saved", "Sure mah?", JOptionPane.YES_NO_OPTION);
			if (response == 0) {
				cl.show(this, "SetName");
			} 
		});
		bidMenu.nextButton.addActionListener((e) -> {
			if(bidMenu.confirmButton.isEnabled()) {
				JOptionPane.showMessageDialog(null,  "CONFIRM button must be pressed before you can proceed to the next stage", "Error", JOptionPane.ERROR_MESSAGE);
			} else {
				chooseColorMenu.donaldLabel.setText(Game.donald.name);
				chooseColorMenu.numLabel.setText(Game.highestBid + "");
				cl.show(this,  "Color");
				JOptionPane.showMessageDialog(null,  Game.donald + ", choose a donald color");
			}
		});	
		chooseColorMenu.backButton.addActionListener((e) -> {
			int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to back to previous menu? The progress will not be saved", "You sure ah?", JOptionPane.YES_NO_OPTION);
			if (response == 0) {
				cl.show(this, "Bid");
			} 
		});
		chooseColorMenu.nextButton.addActionListener((e) -> {
			if (chooseColorMenu.isClicked) {
				chooseTeammateMenu.set();			
				cl.show(this, "Teammate");
				JOptionPane.showMessageDialog(null,  Game.donald + ", choose your teammate");
			} else {
				JOptionPane.showMessageDialog(null,  "Choose a donald color before you can proceed to the next stage", "Error", JOptionPane.ERROR_MESSAGE);
			}		
		});
		chooseTeammateMenu.backButton.addActionListener((e) -> {
			int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to back to previous menu? The progress will not be saved", "Double confirm xia?", JOptionPane.YES_NO_OPTION);
			if (response == 0) {
				cl.show(this, "Color");
			} 
		});
		chooseTeammateMenu.nextButton.addActionListener((e) -> {
			if (chooseTeammateMenu.isClicked) {
				infoMenu.set();
				cl.show(this,  "Info");
			} else {
				JOptionPane.showMessageDialog(null,  "Choose your teammate first lah", "Error", JOptionPane.ERROR_MESSAGE);
			}
		});
		infoMenu.backButton.addActionListener((e) -> {
			JOptionPane.showMessageDialog(null, "Not allowed", "Error", JOptionPane.ERROR_MESSAGE);
		});
		
		GameMenu gameMenu = new GameMenu();
		add(gameMenu, "Game");
		
		infoMenu.nextButton.addActionListener((e) -> {
			gameMenu.set();
			cl.show(this,  "Game");
		});
	}

}
