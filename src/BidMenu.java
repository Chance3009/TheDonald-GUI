import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

@SuppressWarnings("serial")
public class BidMenu extends JPanel {
	
	JLabel label1 = new JLabel();
	JLabel label2 = new JLabel();
	JLabel label3 = new JLabel();
	JLabel label4 = new JLabel();
	
	JLabel bidLabel;
	JLabel bidPlayerLabel;
	
	JButton backButton;
	JButton nextButton;
	JButton confirmButton;
	
	public BidMenu() {
		
		setPreferredSize(new Dimension(1280,720));
		setLayout(null);
		
		JPanel panel1 = createPanel(0, new Color(204, 235, 255), label1, 0);	
		JPanel panel2 = createPanel(320, new Color(102, 194, 255), label2, 1);
		JPanel panel3 = createPanel(640, new Color(0, 153, 255), label3, 2);
		JPanel panel4 = createPanel(960, new Color(0, 107, 179), label4, 3);
		
		JPanel panel5 = new JPanel();
		panel5.setBounds(0,0,1280,170);
		panel5.setBackground(new Color(77, 100, 255));
		panel5.setLayout(null);	
		
		JLabel label5 = new JLabel("Call for Donald");
		label5.setBounds(0, 0, 1280, 70);
		label5.setFont(new Font("Arial", Font.BOLD, 45));
		label5.setHorizontalAlignment(JLabel.CENTER);
		
		JLabel label6 = new JLabel("Highest bid : ");
		label6.setBounds(440, 70, 200, 50);
		label6.setFont(new Font("Arial", Font.BOLD, 30));
		label6.setHorizontalAlignment(JLabel.TRAILING);
		
		JLabel label7 = new JLabel("Player that bid for donald : ");
		label7.setBounds(240, 120, 400, 50);
		label7.setFont(new Font("Arial", Font.BOLD, 30));
		label7.setHorizontalAlignment(JLabel.TRAILING);
		
		bidLabel = new JLabel();
		bidLabel.setBounds(640, 70, 640, 50);
		bidLabel.setFont(new Font("Arial", Font.BOLD, 30));
		
		bidPlayerLabel = new JLabel();
		bidPlayerLabel.setBounds(640, 120, 640, 50);
		bidPlayerLabel.setFont(new Font("Arial", Font.BOLD, 30));
		
		panel5.add(label5);
		panel5.add(label6);
		panel5.add(label7);
		panel5.add(bidLabel);
		panel5.add(bidPlayerLabel);
		
		backButton = new JButton("Back");
		backButton.setBounds(220, 600, 200, 50);
		backButton.setFont(new Font("Arial", Font.PLAIN, 25));
		
		nextButton = new JButton("Next");
		nextButton.setBounds(860, 600, 200, 50);
		nextButton.setFont(new Font("Arial", Font.PLAIN, 25));
		
		confirmButton = new JButton("Confirm");
		confirmButton.setBounds(550, 600, 180, 80);
		confirmButton.setFont(new Font("Arial", Font.BOLD, 30));
		confirmButton.addActionListener((e) -> {
			int response = JOptionPane.showConfirmDialog(null,  "Pressing YES will choose the donald, donald will be chosen randomly if nobody bids", "Choose donald", JOptionPane.YES_NO_OPTION);
			if (response == 0) {
				Game.chooseDonald();
				bidLabel.setText(Game.highestBid + "");
				bidPlayerLabel.setText(Game.donald.toString());
				confirmButton.setEnabled(false);
			}
		});
		
		add(backButton);
		add(nextButton);
		add(confirmButton);
		
		add(panel1);
		add(panel2);
		add(panel3);
		add(panel4);
		add(panel5);
		
	}
	
	public JPanel createPanel(int x, Color color, JLabel label, int index) {
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(x, 170, 320, 550);
		panel.setBackground(color); 
		
		label.setOpaque(true); 
		label.setBackground(new Color(0, 150, 200));
		label.setBounds(0, 0, 320, 70);
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setFont(new Font("Arial", Font.PLAIN, 30));
		
		JLabel askLabel = new JLabel("<html>Do you want to <br> call for donald</html>");
		askLabel.setBounds(0, 70, 320, 200);
		askLabel.setFont(new Font("Arial", Font.PLAIN, 30));
		askLabel.setHorizontalAlignment(JLabel.CENTER);
		
		JButton yesButton = new JButton("Yes");
		yesButton.setBounds(30, 270, 100, 50);
		yesButton.setFont(new Font("Arial", Font.PLAIN, 20));
		
		JButton noButton = new JButton("No");
		noButton.setBounds(190, 270, 100, 50);
		noButton.setFont(new Font("Arial", Font.PLAIN, 20));
		
		JRadioButton b1 = new JRadioButton("1");
		b1.setBounds(10, 70, 300, 50);
		b1.setHorizontalAlignment(JRadioButton.CENTER);
		b1.setFont(new Font("Arial", Font.PLAIN, 30));
		b1.setVisible(false);
		
		JRadioButton b2 = new JRadioButton("2");
		b2.setBounds(10, 120, 300, 50);
		b2.setHorizontalAlignment(JRadioButton.CENTER);
		b2.setFont(new Font("Arial", Font.PLAIN, 30));
		b2.setVisible(false);
		
		JRadioButton b3 = new JRadioButton("3");
		b3.setBounds(10, 170, 300, 50);
		b3.setHorizontalAlignment(JRadioButton.CENTER);
		b3.setFont(new Font("Arial", Font.PLAIN, 30));
		b3.setVisible(false);
		
		JRadioButton b4 = new JRadioButton("4");
		b4.setBounds(10, 220, 300, 50);
		b4.setHorizontalAlignment(JRadioButton.CENTER);
		b4.setFont(new Font("Arial", Font.PLAIN, 30));
		b4.setVisible(false);
		
		JRadioButton b5 = new JRadioButton("5");
		b5.setBounds(10, 270, 300, 50);
		b5.setHorizontalAlignment(JRadioButton.CENTER);
		b5.setFont(new Font("Arial", Font.PLAIN, 30));
		b5.setVisible(false);
		
		JRadioButton b6 = new JRadioButton("6");
		b6.setBounds(10, 320, 300, 50);
		b6.setHorizontalAlignment(JRadioButton.CENTER);
		b6.setFont(new Font("Arial", Font.PLAIN, 30));
		b6.setVisible(false);
		
		ButtonGroup group = new ButtonGroup();
		
		JButton bidButton = new JButton("Bid");
		bidButton.setBounds(60, 380, 60, 40);
		bidButton.setVisible(false);
		bidButton.addActionListener((e) -> {
			if (b1.isSelected()) {
				if (Game.highestBid > 1) {
					JOptionPane.showMessageDialog(null, "Please bid a number greater than equal to the highest bid", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					Game.players[index].bidNum = 1;
					Game.highestBid = 1;
					if (!Game.bidPlayer.contains(Game.players[index])) {
						Game.bidPlayer.add(Game.players[index]);
					}					
					for (Player player : Game.players) {
						if (player.bidNum < 1 && Game.bidPlayer.contains(player)) {
							Game.bidPlayer.remove(player);
						}
					}
				}
			} 
			if (b2.isSelected()) {
				if (Game.highestBid > 2) {
					JOptionPane.showMessageDialog(null, "Please bid a number greater than equal to the highest bid", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					Game.players[index].bidNum = 2;
					Game.highestBid = 2;
					if (!Game.bidPlayer.contains(Game.players[index])) {
						Game.bidPlayer.add(Game.players[index]);
					}
					for (Player player : Game.players) {
						if (player.bidNum < 2 && Game.bidPlayer.contains(player)) {
							Game.bidPlayer.remove(player);
						}
					}
				}
			} 
			if (b3.isSelected()) {
				if (Game.highestBid > 3) {
					JOptionPane.showMessageDialog(null, "Please bid a number greater than equal to the highest bid", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					Game.players[index].bidNum = 3;
					Game.highestBid = 3;
					if (!Game.bidPlayer.contains(Game.players[index])) {
						Game.bidPlayer.add(Game.players[index]);
					}
					for (Player player : Game.players) {
						if (player.bidNum < 3 && Game.bidPlayer.contains(player)) {
							Game.bidPlayer.remove(player);
						}
					}
				}
			} 
			if (b4.isSelected()) {
				if (Game.highestBid > 4) {
					JOptionPane.showMessageDialog(null, "Please bid a number greater than equal to the highest bid", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					Game.players[index].bidNum = 4;
					Game.highestBid = 4;
					if (!Game.bidPlayer.contains(Game.players[index])) {
						Game.bidPlayer.add(Game.players[index]);
					}
					for (Player player : Game.players) {
						if (player.bidNum < 4 && Game.bidPlayer.contains(player)) {
							Game.bidPlayer.remove(player);
						}
					}
				}
			} 
			if (b5.isSelected()) {
				if (Game.highestBid > 5) {
					JOptionPane.showMessageDialog(null, "Please bid a number greater than equal to the highest bid", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					Game.players[index].bidNum = 5;
					Game.highestBid = 5;
					if (!Game.bidPlayer.contains(Game.players[index])) {
						Game.bidPlayer.add(Game.players[index]);
					}
					for (Player player : Game.players) {
						if (player.bidNum < 5 && Game.bidPlayer.contains(player)) {
							Game.bidPlayer.remove(player);
						}
					}
				}
			} 
			if (b6.isSelected()) {
				Game.players[index].bidNum = 6;
				Game.highestBid = 6;
				if (!Game.bidPlayer.contains(Game.players[index])) {
					Game.bidPlayer.add(Game.players[index]);
				}
				for (Player player : Game.players) {
					if (player.bidNum < 6 && Game.bidPlayer.contains(player)) {
						Game.bidPlayer.remove(player);
					}
				}
			}
			
			if (Game.highestBid > 1) {
				b1.setEnabled(false);
				if (Game.highestBid > 2) {
					b2.setEnabled(false);
					if (Game.highestBid > 3) {
						b3.setEnabled(false);
						if (Game.highestBid > 4) {
							b4.setEnabled(false);
							if (Game.highestBid > 5) {
								b5.setEnabled(false);
							}
						}
					}
				}
			}
			
			bidLabel.setText(Game.highestBid + "");
			bidPlayerLabel.setText(Game.bidPlayer.toString());
			
		});
		
		JButton quitButton = new JButton("Quit");
		quitButton.setBounds(200, 380, 60, 40);
		quitButton.setVisible(false);
		quitButton.addActionListener((e) -> {
			if (Game.bidPlayer.contains(Game.players[index]) && Game.bidPlayer.size() == 1) {
				JOptionPane.showMessageDialog(null,  "You can't quit. You are the only player that bid the highest bid", "Error", JOptionPane.ERROR_MESSAGE);
			} else {
				Game.bidPlayer.remove(Game.players[index]);
				bidPlayerLabel.setText(Game.bidPlayer.toString());
				bidButton.setVisible(false);
				quitButton.setVisible(false);
				panel.remove(quitButton);
				panel.remove(bidButton);
				b1.setEnabled(false);
				b2.setEnabled(false);
				b3.setEnabled(false);
				b4.setEnabled(false);
				b5.setEnabled(false);
				b6.setEnabled(false);
				label.setBackground(Color.RED);
			}
			
		});
		
		group.add(b1);
		group.add(b2);
		group.add(b3);
		group.add(b4);
		group.add(b5);
		group.add(b6);
		
		panel.add(label);
		panel.add(askLabel);
		panel.add(yesButton);
		panel.add(noButton);
		
		panel.add(b1);
		panel.add(b2);
		panel.add(b3);
		panel.add(b4);
		panel.add(b5);
		panel.add(b6);
		panel.add(bidButton);
		panel.add(quitButton);
		
		yesButton.addActionListener((e) -> {
			
			askLabel.setVisible(false);
			yesButton.setVisible(false);
			noButton.setVisible(false);
			
			panel.remove(askLabel);
			panel.remove(yesButton);
			panel.remove(noButton);
			
			b1.setVisible(true);
			b2.setVisible(true);
			b3.setVisible(true);
			b4.setVisible(true);
			b5.setVisible(true);
			b6.setVisible(true);
			bidButton.setVisible(true);
			quitButton.setVisible(true);
			
			label.setBackground(Color.GREEN);
			
		});
				
		noButton.addActionListener((e) -> {
			
			yesButton.setVisible(false);
			noButton.setVisible(false);
			panel.remove(yesButton);
			panel.remove(noButton);
			askLabel.setBounds(0, 100, 320, 299);
			askLabel.setIcon(new ImageIcon(getClass().getClassLoader().getResource("wait.png")));
			label.setBackground(Color.RED);
			
		});
		
		return panel;
		
	}
	
}
