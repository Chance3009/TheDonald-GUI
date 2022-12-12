import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ChooseColorMenu extends JPanel {
	
	JLabel donaldLabel;
	JLabel numLabel;
	
	JButton redButton;
	JButton blueButton;
	JButton greenButton;
	JButton yellowButton;
	JButton nullButton;
	
	JButton backButton;
	JButton nextButton;
	
	boolean isClicked;
	
	public ChooseColorMenu() {
		
		setPreferredSize(new Dimension(1280, 720));
		setLayout(null);
		
		JLabel titleLabel = new JLabel("Choose a donald color");
		titleLabel.setBounds(0, 0, 1280, 100);
		titleLabel.setFont(new Font("Arial", Font.BOLD, 45));
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		
		JLabel label1 = new JLabel("Donald : ");
		label1.setBounds(0, 100, 640, 50);
		label1.setFont(new Font("Arial", Font.BOLD, 30));
		label1.setHorizontalAlignment(JLabel.TRAILING);
		
		JLabel label2 = new JLabel("Donald Number : ");
		label2.setBounds(0, 150, 640, 50);
		label2.setFont(new Font("Arial", Font.BOLD, 30));
		label2.setHorizontalAlignment(JLabel.TRAILING);
		
		JLabel label3 = new JLabel("Donald Color : ");
		label3.setBounds(0, 200, 640, 50);
		label3.setFont(new Font("Arial", Font.BOLD, 30));
		label3.setHorizontalAlignment(JLabel.TRAILING);
		
		donaldLabel = new JLabel();
		donaldLabel.setBounds(640, 100, 640, 50);
		donaldLabel.setFont(new Font("Arial", Font.BOLD, 30));
		
		numLabel = new JLabel();
		numLabel.setBounds(640, 150, 640, 50);
		numLabel.setFont(new Font("Arial", Font.BOLD, 30));
		
		JLabel colorLabel = new JLabel();
		colorLabel.setBounds(640, 200, 640, 50);
		colorLabel.setFont(new Font("Arial", Font.BOLD, 30));
		
		ImageIcon red = new ImageIcon(getClass().getClassLoader().getResource("red.png"));
		ImageIcon blue = new ImageIcon(getClass().getClassLoader().getResource("blue.png"));
		ImageIcon green = new ImageIcon(getClass().getClassLoader().getResource("green.png"));
		ImageIcon yellow = new ImageIcon(getClass().getClassLoader().getResource("yellow.png"));
		ImageIcon noDonald = new ImageIcon(getClass().getClassLoader().getResource("null.png"));
		
		ImageIcon redTick = new ImageIcon(getClass().getClassLoader().getResource("redTick.png"));
		ImageIcon blueTick = new ImageIcon(getClass().getClassLoader().getResource("blueTick.png"));
		ImageIcon greenTick = new ImageIcon(getClass().getClassLoader().getResource("greenTick.png"));
		ImageIcon yellowTick = new ImageIcon(getClass().getClassLoader().getResource("yellowTick.png"));
		ImageIcon nullTick = new ImageIcon(getClass().getClassLoader().getResource("nullTick.png"));
		
		redButton = new JButton(red);
		redButton.setBounds(70, 275, 180, 280);
		redButton.setRolloverEnabled(true);
		redButton.setRolloverIcon(new ImageIcon(getClass().getClassLoader().getResource("redClick.png")));
	
		blueButton = new JButton(blue);
		blueButton.setBounds(310, 275, 180, 280);
		blueButton.setRolloverEnabled(true);
		blueButton.setRolloverIcon(new ImageIcon(getClass().getClassLoader().getResource("blueClick.png")));
		
		greenButton = new JButton(green);
		greenButton.setBounds(550, 275, 180, 280);
		greenButton.setRolloverEnabled(true);
		greenButton.setRolloverIcon(new ImageIcon(getClass().getClassLoader().getResource("greenClick.png")));
		
		yellowButton = new JButton(yellow);
		yellowButton.setBounds(790, 275, 180, 280);
		yellowButton.setRolloverEnabled(true);
		yellowButton.setRolloverIcon(new ImageIcon(getClass().getClassLoader().getResource("yellowClick.png")));
		
		nullButton = new JButton(noDonald);
		nullButton.setBounds(1030, 275, 180, 280);
		nullButton.setRolloverEnabled(true);
		nullButton.setRolloverIcon(new ImageIcon(getClass().getClassLoader().getResource("nullClick.png")));
		
		redButton.addActionListener((e) -> {
			redButton.setIcon(redTick);
			blueButton.setIcon(blue);
			greenButton.setIcon(green);
			yellowButton.setIcon(yellow);
			nullButton.setIcon(noDonald);
			colorLabel.setText("RED");
			Game.donaldColor = Card.Color.RED;
			isClicked = true;
		});
		
		blueButton.addActionListener((e) -> {
			redButton.setIcon(red);
			blueButton.setIcon(blueTick);
			greenButton.setIcon(green);
			yellowButton.setIcon(yellow);
			nullButton.setIcon(noDonald);
			colorLabel.setText("BLUE");
			Game.donaldColor = Card.Color.BLUE;
			isClicked = true;
		});
		
		greenButton.addActionListener((e) -> {
			redButton.setIcon(red);
			blueButton.setIcon(blue);
			greenButton.setIcon(greenTick);
			yellowButton.setIcon(yellow);
			nullButton.setIcon(noDonald);
			colorLabel.setText("GREEN");
			Game.donaldColor = Card.Color.GREEN;
			isClicked = true;
		});
		
		yellowButton.addActionListener((e) -> {
			redButton.setIcon(red);
			blueButton.setIcon(blue);
			greenButton.setIcon(green);
			yellowButton.setIcon(yellowTick);
			nullButton.setIcon(noDonald);
			colorLabel.setText("YELLOW");
			Game.donaldColor = Card.Color.YELLOW;
			isClicked = true;
		});
		
		nullButton.addActionListener((e) -> {
			redButton.setIcon(red);
			blueButton.setIcon(blue);
			greenButton.setIcon(green);
			yellowButton.setIcon(yellow);
			nullButton.setIcon(nullTick);
			colorLabel.setText("NO DONALD");
			Game.isNoDonald = true;
			isClicked = true;
		});
		
		
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
		add(donaldLabel);
		add(numLabel);
		add(colorLabel);
		
		add(redButton);
		add(blueButton);
		add(greenButton);
		add(yellowButton);
		add(nullButton);
		
		add(backButton);
		add(nextButton);
		
	}
	
}
