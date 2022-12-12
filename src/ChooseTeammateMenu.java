import java.awt.Dimension;
import java.awt.Font;
import java.util.Arrays;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ChooseTeammateMenu extends JPanel {
	
	JLabel donaldLabel;
	JLabel nonDonaldLabel;
	JLabel numLabel;
	JLabel colorLabel;

	JButton button1;
	JButton button2;
	JButton button3;
	JButton button4;
	JButton button5;
	
	JButton backButton;
	JButton nextButton;
	
	boolean isClicked;
	
	public ChooseTeammateMenu() {
		
		setPreferredSize(new Dimension(1280, 720));
		setLayout(null);
		
		JLabel titleLabel = new JLabel("Choose your teammate");
		titleLabel.setBounds(0, 0, 1280, 100);
		titleLabel.setFont(new Font("Arial", Font.BOLD, 45));
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		
		JLabel label1 = new JLabel("Donald Team : ");
		label1.setBounds(0, 100, 640, 50);
		label1.setFont(new Font("Arial", Font.BOLD, 30));;
		label1.setHorizontalAlignment(JLabel.TRAILING);
		
		JLabel label2 = new JLabel("NonDonald Team : ");
		label2.setBounds(0, 150, 640, 50);
		label2.setFont(new Font("Arial", Font.BOLD, 30));
		label2.setHorizontalAlignment(JLabel.TRAILING);
		
		JLabel label3 = new JLabel("Donald Number : ");
		label3.setBounds(0, 200, 640, 50);
		label3.setFont(new Font("Arial", Font.BOLD, 30));
		label3.setHorizontalAlignment(JLabel.TRAILING);
		
		JLabel label4 = new JLabel("Donald Color : ");
		label4.setBounds(0, 250, 640, 50);
		label4.setFont(new Font("Arial", Font.BOLD, 30));
		label4.setHorizontalAlignment(JLabel.TRAILING);
		
		donaldLabel = new JLabel();
		donaldLabel.setBounds(640, 100, 640, 50);
		donaldLabel.setFont(new Font("Arial", Font.BOLD, 30));
		
		nonDonaldLabel = new JLabel();
		nonDonaldLabel.setBounds(640, 150, 640, 50);
		nonDonaldLabel.setFont(new Font("Arial", Font.BOLD, 30));
		
		numLabel = new JLabel();
		numLabel.setBounds(640, 200, 640, 50);
		numLabel.setFont(new Font("Arial", Font.BOLD, 30));
		
		colorLabel = new JLabel();
		colorLabel.setBounds(640, 250, 640, 50);
		colorLabel.setFont(new Font("Arial", Font.BOLD, 30));

		button1 = new JButton();
		button1.setBounds(70, 350, 180, 100);
		button1.setFont(new Font("Arial", Font.PLAIN, 20));
		
		button2 = new JButton();
		button2.setBounds(310, 350, 180, 100);
		button2.setFont(new Font("Arial", Font.PLAIN, 20));
		
		button3 = new JButton();
		button3.setBounds(550, 350, 180, 100);
		button3.setFont(new Font("Arial", Font.PLAIN, 20));
		
		button4 = new JButton();
		button4.setBounds(790, 350, 180, 100);
		button4.setFont(new Font("Arial", Font.PLAIN, 20));
		
		button5 = new JButton("Random");
		button5.setBounds(1030, 350, 180, 100);
		button5.setFont(new Font("Arial", Font.PLAIN, 20));
		
		backButton = new JButton("Back");
		backButton.setBounds(220, 600, 200, 50);
		backButton.setFont(new Font("Arial", Font.PLAIN, 25));
		
		nextButton = new JButton("Next");
		nextButton.setBounds(860, 600, 200, 50);
		nextButton.setFont(new Font("Arial", Font.PLAIN, 25));
		
		add(titleLabel);
		add(label1);
		add(label2);
		add(label3);
		add(label4);
		add(donaldLabel);
		add(nonDonaldLabel);
		add(numLabel);
		add(colorLabel);
		add(button1);
		add(button2);
		add(button3);
		add(button4);
		add(button5);
		add(backButton);
		add(nextButton);
		
	}
	
	public void set() {
		
		switch(Game.donald.id) {
			case 1:
				button1.setEnabled(false);
				break;
			case 2:
				button2.setEnabled(false);
				break;
			case 3:
				button3.setEnabled(false);
				break;
			case 4:
				button4.setEnabled(false);
				break;
		}
		
		numLabel.setText(Game.highestBid + "");
		if (Game.isNoDonald) {
			colorLabel.setText("NO DONALD");
		} else {
			colorLabel.setText(Game.donaldColor + "");
		}
		donaldLabel.setText(Arrays.toString(Game.donaldTeam));
		
		button1.setText(Game.players[0].name);
		button1.addActionListener((e) -> {
			Game.donaldTeam[1] = Game.players[0];
			Game.chooseTeammate();
			donaldLabel.setText(Arrays.toString(Game.donaldTeam));
			nonDonaldLabel.setText(Arrays.toString(Game.nonDonaldTeam));
			isClicked = true;
		});
		
		button2.setText(Game.players[1].name);
		button2.addActionListener((e) -> {
			Game.donaldTeam[1] = Game.players[1];
			Game.chooseTeammate();
			donaldLabel.setText(Arrays.toString(Game.donaldTeam));
			nonDonaldLabel.setText(Arrays.toString(Game.nonDonaldTeam));
			isClicked = true;
		});
		
		button3.setText(Game.players[2].name);
		button3.addActionListener((e) -> {
			Game.donaldTeam[1] = Game.players[2];
			Game.chooseTeammate();
			donaldLabel.setText(Arrays.toString(Game.donaldTeam));
			nonDonaldLabel.setText(Arrays.toString(Game.nonDonaldTeam));
			isClicked = true;
		});
		
		button4.setText(Game.players[3].name);
		button4.addActionListener((e) -> {
			Game.donaldTeam[1] = Game.players[3];
			Game.chooseTeammate();
			donaldLabel.setText(Arrays.toString(Game.donaldTeam));
			nonDonaldLabel.setText(Arrays.toString(Game.nonDonaldTeam));
			isClicked = true;
		});
		
		button5.addActionListener((e) -> {
			Random random = new Random();
			int id = random.nextInt(4)+1;
			while (id == Game.donald.id) {
				id = random.nextInt(4)+1;
			}
			button1.setEnabled(false);
			button2.setEnabled(false);
			button3.setEnabled(false);
			button4.setEnabled(false);
			button5.setEnabled(false);
			Game.donaldTeam[1] = Game.players[id-1];
			Game.chooseTeammate();
			donaldLabel.setText(Arrays.toString(Game.donaldTeam));
			nonDonaldLabel.setText(Arrays.toString(Game.nonDonaldTeam));
			isClicked = true;
		});
	}
	
}
