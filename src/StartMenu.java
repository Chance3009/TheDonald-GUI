import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class StartMenu extends JPanel {
	
	JButton playButton;
	JButton helpButton; 
	
	public StartMenu() {
		
		setPreferredSize(new Dimension(1280,720));
		setLayout(null);
		
		JLabel titleLabel = new JLabel("THE DONALD");
		titleLabel.setBounds(0, 0, 1280, 250);
		titleLabel.setFont(new Font("Arial", Font.BOLD, 100));
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
			
		playButton = new JButton("Play");
		playButton.setBounds(490, 250, 300, 100);
		playButton.setFont(new Font("Arial", Font.PLAIN, 40));
		playButton.setFocusable(false);
		playButton.setHorizontalAlignment(JButton.CENTER);
		
		helpButton = new JButton("Help");
		helpButton.setBounds(490, 400, 300, 100);
		helpButton.setFont(new Font("Arial", Font.PLAIN, 40));
		helpButton.setFocusable(false);
		
		JButton quitButton = new JButton("Quit");
		quitButton.setBounds(490, 550, 300, 100);
		quitButton.setFont(new Font("Arial", Font.PLAIN, 40));
		quitButton.setFocusable(false);
		quitButton.addActionListener((e) -> System.exit(0));
		
		add(titleLabel);
		add(playButton);
		add(helpButton);
		add(quitButton);
		
	}
}
