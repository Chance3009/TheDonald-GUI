import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ChoosePlayerMenu extends JPanel {
	
	JButton backButton;
	JButton nextButton;
	
	public ChoosePlayerMenu() {
		
		setPreferredSize(new Dimension(1280, 720));
		setLayout(null);
		
		JLabel titleLabel = new JLabel("Choose the number of player");
		titleLabel.setBounds(0, 0, 1280, 175);
		titleLabel.setFont(new Font("Arial", Font.BOLD, 60));
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		
		JLabel currentLabel = new JLabel("Current number of player : ");
		currentLabel.setBounds(0, 125, 1280, 100);
		currentLabel.setFont(new Font("Arial", Font.BOLD, 40));
		currentLabel.setHorizontalAlignment(JLabel.CENTER);
				
		JButton p1Button = new JButton("1 Player");
		p1Button.setBounds(190, 250, 350, 100);
		p1Button.setFont(new Font("Arial", Font.PLAIN, 30));
		p1Button.addActionListener((e) -> {
			currentLabel.setText("Current number of player : 1");
			Game.numOfPlayer = 1;
			Game.players[1].isComputer = true;
			Game.players[2].isComputer = true;
			Game.players[3].isComputer = true;
		});
		
		JButton p2Button = new JButton("2 Players");
		p2Button.setBounds(740, 250, 350, 100);
		p2Button.setFont(new Font("Arial", Font.PLAIN, 30));
		p2Button.addActionListener((e) -> {
			currentLabel.setText("Current number of player : 2");
			Game.numOfPlayer = 2;
			Game.players[2].isComputer = true;
			Game.players[3].isComputer = true;
		});
		
		JButton p3Button = new JButton("3 Players");
		p3Button.setBounds(190, 425, 350, 100);
		p3Button.setFont(new Font("Arial", Font.PLAIN, 30));
		p3Button.addActionListener((e) -> {
			currentLabel.setText("Current number of player : 3");
			Game.numOfPlayer = 3;
			Game.players[3].isComputer = true;
		});
		
		JButton p4Button = new JButton("4 Players");
		p4Button.setBounds(740, 425, 350, 100);
		p4Button.setFont(new Font("Arial", Font.PLAIN, 30));
		p4Button.addActionListener((e) -> {currentLabel.setText("Current number of player : 4");
											Game.numOfPlayer = 4;});
		
		backButton = new JButton("Back");
		backButton.setBounds(220, 600, 200, 50);
		backButton.setFont(new Font("Arial", Font.PLAIN, 25));
		
		nextButton = new JButton("Next");
		nextButton.setBounds(860, 600, 200, 50);
		nextButton.setFont(new Font("Arial", Font.PLAIN, 25));
		
		add(p1Button);
		add(p2Button);
		add(p3Button);
		add(p4Button);
		add(backButton);
		add(nextButton);
		
		add(titleLabel);
		add(currentLabel);
		
	}
}
