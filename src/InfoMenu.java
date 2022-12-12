import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class InfoMenu extends JPanel {
	 
	JButton backButton;
	JButton nextButton;
	JPanel panel1;
	JPanel panel2;
	
	public InfoMenu() {
		
		setPreferredSize(new Dimension(1280, 720));
		setLayout(null);
		
		JLabel titleLabel = new JLabel("Info");
		titleLabel.setBounds(0, 0, 1280, 150);
		titleLabel.setFont(new Font("Arial", Font.BOLD, 60));
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		
		JLabel label1 = new JLabel("Donald : ");
		label1.setBounds(0, 125, 640, 50);
		label1.setFont(new Font("Arial", Font.BOLD, 40));
		label1.setHorizontalAlignment(JLabel.TRAILING);
		
		JLabel label2 = new JLabel("Donald Color : ");
		label2.setBounds(0, 200, 640, 50);
		label2.setFont(new Font("Arial", Font.BOLD, 40));
		label2.setHorizontalAlignment(JLabel.TRAILING);
		
		backButton = new JButton("Back");
		backButton.setBounds(220, 600, 200, 50);
		backButton.setFont(new Font("Arial", Font.PLAIN, 25));
		
		nextButton = new JButton("Next");
		nextButton.setBounds(860, 600, 200, 50);
		nextButton.setFont(new Font("Arial", Font.PLAIN, 25));
		
		add(titleLabel);
		add(label1);
		add(label2);
		add(backButton);
		add(nextButton);
	}
	
	public JPanel createPanel (int x, Color color, String name, Player[] arr) {
		
		JPanel panel = new JPanel();
		panel.setBounds(640*x, 300, 640, 200);
		panel.setBackground(color);
		panel.setLayout(null);
		
		JLabel label1 = new JLabel(name);
		label1.setBounds(0, 0, 640, 75);
		label1.setFont(new Font("Arial", Font.BOLD, 40));
		label1.setHorizontalAlignment(JLabel.CENTER);
		
		JLabel label2 = new JLabel(Arrays.toString(arr));
		label2.setBounds(0, 75, 640, 75);
		label2.setFont(new Font("Arial", Font.PLAIN, 30));
		label2.setHorizontalAlignment(JLabel.CENTER);
		
		JLabel label3 = new JLabel("Winning Criteria : " + arr[0].winningCriteria);
		label3.setBounds(0, 150, 640, 50);
		label3.setFont(new Font("Arial", Font.PLAIN, 30));
		label3.setHorizontalAlignment(JLabel.CENTER);
		
		panel.add(label1);
		panel.add(label2);
		panel.add(label3);
		
		return panel;
	}
	
	public void set() {
		
		panel1 = createPanel(0, Color.LIGHT_GRAY, "Donald Team", Game.donaldTeam);
		panel2 = createPanel(1, Color.GRAY, "Non Donald Team", Game.nonDonaldTeam);
		
		JLabel donaldLabel = new JLabel(Game.donald.name);
		donaldLabel.setBounds(640, 125, 640, 50);
		donaldLabel.setFont(new Font("Arial", Font.BOLD, 40));
		
		JLabel colorLabel = new JLabel();
		colorLabel.setBounds(640, 200, 640, 50);
		colorLabel.setFont(new Font("Arial", Font.BOLD, 40));
		
		if(Game.isNoDonald) {
			colorLabel.setText("NO DONALD");
		} else {
			colorLabel.setText(Game.donaldColor + "");
		}
		add(panel1);
		add(panel2);
		add(donaldLabel);
		add(colorLabel);
		
	}
	
}
