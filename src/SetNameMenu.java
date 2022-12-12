import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class SetNameMenu extends JPanel {
	
	JButton backButton;
	JButton nextButton;
	
	JTextField textField1;
	JTextField textField2;
	JTextField textField3;
	JTextField textField4;
	
	JButton p1Button;
	JButton p2Button;
	JButton p3Button;
	JButton p4Button;
	
	public SetNameMenu() {
		
		setPreferredSize(new Dimension(1280, 720));
		setLayout(null);
		
		JLabel titleLabel = new JLabel("Enter your name");
		titleLabel.setBounds(0, 0, 1280, 150);
		titleLabel.setFont(new Font("Arial", Font.BOLD, 60));
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		
		JLabel label1 = new JLabel("Player 1");
		label1.setBounds(100, 150, 200, 100);
		label1.setFont(new Font("Arial", Font.PLAIN, 30));
		
		JLabel label2 = new JLabel("Player 2");
		label2.setBounds(100, 250, 200, 100);
		label2.setFont(new Font("Arial", Font.PLAIN, 30));
		
		JLabel label3 = new JLabel("Player 3");
		label3.setBounds(100, 350, 200, 100);
		label3.setFont(new Font("Arial", Font.PLAIN, 30));
		
		JLabel label4 = new JLabel("Player 4");
		label4.setBounds(100, 450, 200, 100);
		label4.setFont(new Font("Arial", Font.PLAIN, 30));
		
		textField1 = new JTextField("Player 1");
		textField1.setBounds(275, 165, 900, 70);
		textField1.setFont(new Font("Arial", Font.PLAIN, 30));
		
		textField2 = new JTextField("Player 2");
		textField2.setBounds(275, 265, 900, 70);
		textField2.setFont(new Font("Arial", Font.PLAIN, 30));
		
		textField3 = new JTextField("Player 3");
		textField3.setBounds(275, 365, 900, 70);
		textField3.setFont(new Font("Arial", Font.PLAIN, 30));
		
		textField4 = new JTextField("Player 4");
		textField4.setBounds(275, 465, 900, 70);
		textField4.setFont(new Font("Arial", Font.PLAIN, 30));
		
		backButton = new JButton("Back");
		backButton.setBounds(220, 600, 200, 50);
		backButton.setFont(new Font("Arial", Font.PLAIN, 25));
		
		nextButton = new JButton("Next");
		nextButton.setBounds(860, 600, 200, 50);
		nextButton.setFont(new Font("Arial", Font.PLAIN, 25));

		add(backButton);
		add(nextButton);
		add(titleLabel);
		add(label1);
		add(label2);
		add(label3);
		add(label4);
		add(textField1);
		add(textField2);
		add(textField3);
		add(textField4);
		
	}

}
