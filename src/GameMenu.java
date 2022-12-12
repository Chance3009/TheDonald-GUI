import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Arrays;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;

@SuppressWarnings("serial")
public class GameMenu extends JPanel implements ActionListener {

	CardLayout cl = new CardLayout();
	JPanel container = new JPanel(cl);

	JButton[] buttonGroup = new JButton[13];

	JLabel label = new JLabel();
	JLabel titleLabel = new JLabel();
	JLabel nameLabel = new JLabel();

	JLabel labelDP = new JLabel();
	JLabel labelDC = new JLabel();
	JLabel labelDA = new JLabel("Donald Activation : FALSE");
	JLabel labelPoint = new JLabel();

	JLabel labelp1 = new JLabel();
	JLabel labelp2 = new JLabel();
	JLabel labelp3 = new JLabel();
	JLabel labelp4 = new JLabel();

	JLabel card1 = createLabel(1, 150);
	JLabel card2 = createLabel(3, 150);
	JLabel card3 = createLabel(5, 150);
	JLabel card4 = createLabel(7, 150);

	JLabel[] labelGroup = { card1, card2, card3, card4 };

	JTextArea textArea = new JTextArea();

	ImageIcon blank = new ImageIcon(getClass().getClassLoader().getResource("Image/blank.png"));

	int id;
	int num;
	int turn;

	public static void main(String[] args) {
		Game.startGame();
		Game.donald = Game.players[1];
		Game.first = Game.donald;
		Game.highestBid = 6;
		Game.donaldColor = Card.Color.BLUE;
		Game.players[0].name = "Player 1";
		Game.players[1].name = "Player 2";
		Game.players[2].name = "Player 3";
		Game.players[3].name = "Player 4";
		Game.donaldTeam[0] = Game.players[1];
		Game.donaldTeam[1] = Game.players[3];
		Game.chooseTeammate();

		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new GameMenu());
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}


	public GameMenu() {

		setPreferredSize(new Dimension(1280, 720));
		setLayout(null);

		for (int i = 0; i < 13; i++) {
			buttonGroup[i] = createButton(i);
		}

		titleLabel.setFont(new Font("Ink Free", Font.BOLD, 40));
		titleLabel.setBounds(490, 0, 300, 80);
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		titleLabel.setOpaque(true);
		titleLabel.setBackground(Color.ORANGE);

		labelp1.setBounds(85, 300, 150, 40);
		labelp1.setOpaque(true);
		labelp1.setBackground(Color.CYAN);
		labelp1.setHorizontalAlignment(JLabel.CENTER);

		labelp2.setBounds(277, 300, 150, 40);
		labelp2.setOpaque(true);
		labelp2.setBackground(Color.CYAN);
		labelp2.setHorizontalAlignment(JLabel.CENTER);

		labelp3.setBounds(469, 300, 150, 40);
		labelp3.setOpaque(true);
		labelp3.setBackground(Color.CYAN);
		labelp3.setHorizontalAlignment(JLabel.CENTER);

		labelp4.setBounds(661, 300, 150, 40);
		labelp4.setOpaque(true);
		labelp4.setBackground(Color.CYAN);
		labelp4.setHorizontalAlignment(JLabel.CENTER);

		JButton pauseButton = new JButton(new ImageIcon(getClass().getClassLoader().getResource("pause.png")));
		pauseButton.setBounds(20, 20, 60, 60);

//******************************************************************************************************************************

		JPanel infoPanel = new JPanel(null);
		infoPanel.setBounds(900, 0, 380, 440);
		infoPanel.setBackground(Color.GRAY);

		JLabel label1 = new JLabel("<html>Donald <br> Team </html>");
		label1.setBounds(0, 0, 100, 80);
		label1.setOpaque(true);
		label1.setBackground(new Color(255, 179, 179));
		label1.setFont(new Font("Arial", Font.PLAIN, 20));
		label1.setHorizontalAlignment(JLabel.CENTER);

		JLabel label11 = new JLabel(" Player 2");
		label11.setBounds(100, 0, 280, 40);
		label11.setOpaque(true);
		label11.setBackground(new Color(255, 255, 179));
		label11.setFont(new Font("Arial", Font.PLAIN, 20));

		JLabel label12 = new JLabel(" Player 4");
		label12.setBounds(100, 40, 280, 40);
		label12.setOpaque(true);
		label12.setBackground(new Color(255, 236, 179));
		label12.setFont(new Font("Arial", Font.PLAIN, 20));

		JLabel label2 = new JLabel("<html>Non <br> Donald <br> Team </html>");
		label2.setBounds(0, 80, 100, 80);
		label2.setOpaque(true);
		label2.setBackground(new Color(179, 255, 255));
		label2.setFont(new Font("Arial", Font.PLAIN, 20));
		label2.setHorizontalAlignment(JLabel.CENTER);

		JLabel label21 = new JLabel(" Player 1");
		label21.setBounds(100, 80, 280, 40);
		label21.setOpaque(true);
		label21.setBackground(new Color(230, 255, 204));
		label21.setFont(new Font("Arial", Font.PLAIN, 20));

		JLabel label22 = new JLabel(" Player 3");
		label22.setBounds(100, 120, 280, 40);
		label22.setOpaque(true);
		label22.setBackground(new Color(179, 255, 179));
		label22.setFont(new Font("Arial", Font.PLAIN, 20));

		labelDP.setBounds(0, 160, 380, 40);
		labelDP.setOpaque(true);
		labelDP.setBackground(new Color(179, 198, 255));
		labelDP.setFont(new Font("Arial", Font.PLAIN, 20));

		labelDC.setBounds(0, 200, 380, 40);
		labelDC.setOpaque(true);
		labelDC.setBackground(new Color(198, 179, 255));
		labelDC.setFont(new Font("Arial", Font.PLAIN, 20));

		labelDA.setBounds(0, 240, 380, 40);
		labelDA.setOpaque(true);
		labelDA.setBackground(new Color(236, 179, 255));
		labelDA.setFont(new Font("Arial", Font.PLAIN, 20));

		labelPoint.setBounds(0, 280, 380, 40);
		labelPoint.setOpaque(true);
		labelPoint.setBackground(new Color(255, 179, 236));
		labelPoint.setFont(new Font("Arial", Font.PLAIN, 20));

		textArea.setLineWrap(true);
		textArea.setFont(new Font("Consolas", Font.PLAIN, 20));
		textArea.setWrapStyleWord(true);
		textArea.setEditable(false);
		textArea.setBackground(new Color(255, 204, 204));
		textArea.setMargin(new Insets(10, 10, 10, 10));

		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(0, 320, 380, 120);

		infoPanel.add(label1);
		infoPanel.add(label2);
		infoPanel.add(labelDP);
		infoPanel.add(labelDC);
		infoPanel.add(labelDA);
		infoPanel.add(labelPoint);
		infoPanel.add(label11);
		infoPanel.add(label12);
		infoPanel.add(label21);
		infoPanel.add(label22);
		infoPanel.add(scrollPane);

//******************************************************************************************************************************

		JPanel handCardPanel = new JPanel(null);
		handCardPanel.setBounds(0, 440, 1280, 280);
		handCardPanel.setBackground(Color.LIGHT_GRAY);

		handCardPanel.add(nameLabel);
		for (JButton b : buttonGroup) {
			b.addActionListener(this);
			handCardPanel.add(b);
		}

		nameLabel.setBounds(0, 0, 400, 70);
		nameLabel.setOpaque(true);
		nameLabel.setBackground(Color.GREEN);
		nameLabel.setFont(new Font("Ink Free", Font.BOLD, 30));
		nameLabel.setHorizontalAlignment(JLabel.CENTER);

		JPanel blankCardPanel = tempPanel();
		container.setBounds(0, 440, 1280, 280);
		container.add(handCardPanel, "Card");
		container.add(blankCardPanel, "No");

//******************************************************************************************************************************

		add(pauseButton);
		add(titleLabel);
		add(labelp1);
		add(labelp2);
		add(labelp3);
		add(labelp4);
		add(card1);
		add(card2);
		add(card3);
		add(card4);
		add(infoPanel);
		add(container);
	}

	public JButton createButton(int x) {
		JButton button = new JButton();
		button.setOpaque(true);
		button.setBackground(Color.RED);
		button.setBounds(96 * x + 19, 100, 90, 140);
		return button;
	}

	public JLabel createLabel(int x, int y) {
		JLabel label = new JLabel();
		label.setOpaque(true);
		label.setBackground(Color.RED);
		label.setBounds(96 * x + 19, y, 90, 140);
		return label;
	}

	public JPanel tempPanel() {
		JPanel panel = new JPanel(null);
		panel.setBounds(0, 440, 1280, 280);
		panel.setBackground(Color.LIGHT_GRAY);

		label.setBounds(0, 0, 400, 70);
		label.setOpaque(true);
		label.setBackground(Color.GREEN);

		JButton next = new JButton("Switch to next player");
		next.setBounds(480, 25, 800, 50);
		next.addActionListener((e) -> {
			if (num % 4 == 0) {
				Game.calculateScore();
				textArea.append(Game.first + " get a point!\n\n****************************\n");
				if (Game.checkScore()) {
					showWinner();
				} else {
					newRound();
				}
			} else {
				newTurn(Game.players[id % 4]);
			}
		});

		panel.add(label);
		panel.add(next);

		for (int i = 0; i < 13; i++) {
			JButton button = createButton(i);
			button.setIcon(blank);
			button.setEnabled(false);
			panel.add(button);
		}
		return panel;
	}

	public void newTurn(Player p) {
		nameLabel.setText(p.name);
		labelPoint.setText("Current point (Winning criteria) : " + p.points + " (" + p.winningCriteria + ")");
		for (int i = 0; i < 13; i++) {
			if (i < p.handCard.size()) {
				buttonGroup[i].setEnabled(true);
				buttonGroup[i].setIcon(p.handCard.get(i).image);
			} else {
				buttonGroup[i].setIcon(blank);
				buttonGroup[i].setEnabled(false);
			}
		}
		cl.first(container);
	}

	public void newRound() {
		cl.last(container);
		id = Game.first.id - 1;
		Game.round++;
		titleLabel.setText("Round " + Game.round);
		textArea.append("ROUND " + Game.round + "\n");
		textArea.setCaretPosition(textArea.getDocument().getLength());
		card1.setIcon(blank);
		card2.setIcon(blank);
		card3.setIcon(blank);
		card4.setIcon(blank);
		JOptionPane.showMessageDialog(null, "Round " + Game.round, "", -1);
		newTurn(Game.first);

	}

	public void showWinner() {

		textArea.append("Congrats!\n" + Game.winner[0] + " and " + Game.winner[1] + " win the game!");
		textArea.setCaretPosition(textArea.getDocument().getLength());

		JPanel panel = new JPanel(null);
		panel.setPreferredSize(new Dimension(800, 450));

		JLabel label = new JLabel(
				"<html>Congrats!<br>" + Game.winner[0] + " and " + Game.winner[1] + " win the game!</html>");
		label.setBounds(200, 0, 600, 200);
		label.setFont(new Font("Qarmic sans", Font.BOLD, 20));
		label.setHorizontalAlignment(JLabel.CENTER);

		ImageIcon win = new ImageIcon(getClass().getClassLoader().getResource("winner.png"));

		JLabel winLabel = new JLabel(win);
		winLabel.setBounds(0, 0, 250, 200);

		Border black = BorderFactory.createLineBorder(Color.BLACK);

		JLabel labelD = new JLabel("Donald Team");
		labelD.setBounds(0, 200, 400, 50);
		labelD.setBorder(black);
		labelD.setHorizontalAlignment(JLabel.CENTER);
		labelD.setFont(new Font("Qarmic sans", Font.PLAIN, 20));
		JLabel labelD11 = new JLabel(Game.donaldTeam[0].name);
		labelD11.setBounds(0, 250, 200, 50);
		labelD11.setBorder(black);
		labelD11.setHorizontalAlignment(JLabel.CENTER);
		labelD11.setFont(new Font("Qarmic sans", Font.PLAIN, 20));
		JLabel labelD12 = new JLabel(Game.donaldTeam[1].name);
		labelD12.setBounds(200, 250, 200, 50);
		labelD12.setBorder(black);
		labelD12.setHorizontalAlignment(JLabel.CENTER);
		labelD12.setFont(new Font("Qarmic sans", Font.PLAIN, 20));
		JLabel labelD21 = new JLabel(Game.donaldTeam[0].points + "");
		labelD21.setBounds(0, 300, 200, 50);
		labelD21.setBorder(black);
		labelD21.setHorizontalAlignment(JLabel.CENTER);
		labelD21.setFont(new Font("Qarmic sans", Font.PLAIN, 20));
		JLabel labelD22 = new JLabel(Game.donaldTeam[1].points + "");
		labelD22.setBounds(200, 300, 200, 50);
		labelD22.setBorder(black);
		labelD22.setHorizontalAlignment(JLabel.CENTER);
		labelD22.setFont(new Font("Qarmic sans", Font.PLAIN, 20));
		JLabel labelD3 = new JLabel((Game.donaldTeam[0].points + Game.donaldTeam[1].points) + "("
				+ Game.donaldTeam[0].winningCriteria + ")");
		labelD3.setBounds(0, 350, 400, 50);
		labelD3.setBorder(black);
		labelD3.setHorizontalAlignment(JLabel.CENTER);
		labelD3.setFont(new Font("Qarmic sans", Font.PLAIN, 20));
		JLabel labelD41 = new JLabel();
		labelD41.setBounds(0, 400, 200, 50);
		labelD41.setBorder(black);
		labelD41.setHorizontalAlignment(JLabel.CENTER);
		labelD41.setFont(new Font("Segoe Print", Font.PLAIN, 30));
		JLabel labelD42 = new JLabel();
		labelD42.setBounds(200, 400, 200, 50);
		labelD42.setBorder(black);
		labelD42.setHorizontalAlignment(JLabel.CENTER);
		labelD42.setFont(new Font("Segoe Print", Font.PLAIN, 30));

		JLabel labelN = new JLabel("Non Donald Team");
		labelN.setBounds(400, 200, 400, 50);
		labelN.setBorder(black);
		labelN.setHorizontalAlignment(JLabel.CENTER);
		labelN.setFont(new Font("Qarmic sans", Font.PLAIN, 20));
		JLabel labelN11 = new JLabel(Game.nonDonaldTeam[0].name);
		labelN11.setBounds(400, 250, 200, 50);
		labelN11.setBorder(black);
		labelN11.setHorizontalAlignment(JLabel.CENTER);
		labelN11.setFont(new Font("Qarmic sans", Font.PLAIN, 20));
		JLabel labelN12 = new JLabel(Game.nonDonaldTeam[1].name);
		labelN12.setBounds(600, 250, 200, 50);
		labelN12.setBorder(black);
		labelN12.setHorizontalAlignment(JLabel.CENTER);
		labelN12.setFont(new Font("Qarmic sans", Font.PLAIN, 20));
		JLabel labelN21 = new JLabel(Game.nonDonaldTeam[0].points + "");
		labelN21.setBounds(400, 300, 200, 50);
		labelN21.setBorder(black);
		labelN21.setHorizontalAlignment(JLabel.CENTER);
		labelN21.setFont(new Font("Qarmic sans", Font.PLAIN, 20));
		JLabel labelN22 = new JLabel(Game.nonDonaldTeam[1].points + "");
		labelN22.setBounds(600, 300, 200, 50);
		labelN22.setBorder(black);
		labelN22.setHorizontalAlignment(JLabel.CENTER);
		labelN22.setFont(new Font("Qarmic sans", Font.PLAIN, 20));
		JLabel labelN3 = new JLabel((Game.nonDonaldTeam[0].points + Game.nonDonaldTeam[1].points) + "("
				+ Game.nonDonaldTeam[0].winningCriteria + ")");
		labelN3.setBounds(400, 350, 400, 50);
		labelN3.setBorder(black);
		labelN3.setHorizontalAlignment(JLabel.CENTER);
		labelN3.setFont(new Font("Qarmic sans", Font.PLAIN, 20));
		JLabel labelN41 = new JLabel();
		labelN41.setBounds(400, 400, 200, 50);
		labelN41.setBorder(black);
		labelN41.setHorizontalAlignment(JLabel.CENTER);
		labelN41.setFont(new Font("Segoe Print", Font.PLAIN, 30));
		JLabel labelN42 = new JLabel();
		labelN42.setBounds(600, 400, 200, 50);
		labelN42.setBorder(black);
		labelN42.setHorizontalAlignment(JLabel.CENTER);
		labelN42.setFont(new Font("Segoe Print", Font.PLAIN, 30));

		if (Game.winner[0].id == Game.donaldTeam[0].id) {
			labelD41.setText("WIN!");
			labelD42.setText("WIN!");
		} else {
			labelN41.setText("WIN!");
			labelN42.setText("WIN!");
		}

		panel.add(label);
		panel.add(winLabel);
		panel.add(labelD);
		panel.add(labelD11);
		panel.add(labelD12);
		panel.add(labelD21);
		panel.add(labelD22);
		panel.add(labelD3);
		panel.add(labelD41);
		panel.add(labelD42);
		panel.add(labelN);
		panel.add(labelN11);
		panel.add(labelN12);
		panel.add(labelN21);
		panel.add(labelN22);
		panel.add(labelN3);
		panel.add(labelN41);
		panel.add(labelN42);

		JOptionPane.showMessageDialog(null, panel, "", -1);

	}

	public void set() {
		labelp1.setText(Game.players[0].name);
		labelp2.setText(Game.players[1].name);
		labelp3.setText(Game.players[2].name);
		labelp4.setText(Game.players[3].name);
		labelDP.setText("Donald : " + Game.donald.name);
		if (Game.isNoDonald) {
			labelDC.setText("Donald Color : NO DONALD");
		} else {
			labelDC.setText("Donald Color : " + Game.donaldColor);
		}

		newRound();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int temp = Arrays.asList(buttonGroup).indexOf(e.getSource());
		if (Game.isValidCard(Game.players[id % 4], temp)) {
			int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to play this card?", "",
					JOptionPane.YES_NO_OPTION, -1, buttonGroup[temp].getIcon());
			if (response == 0) {
				try {
					URL songURL = getClass().getResource("play.wav");
					AudioInputStream input = AudioSystem.getAudioInputStream(songURL);
					Clip clip = AudioSystem.getClip();
					clip.open(input);
					clip.start();
				} catch (Exception e1) {
				}

				boolean a = Game.donaldActivation;
				Game.playCard(Game.players[id % 4], temp);
				labelGroup[id % 4].setIcon(Game.players[id % 4].myCard.image);
				textArea.append(Game.players[id % 4].name + " plays " + Game.players[id % 4].myCard + "\n");
				if (a != Game.donaldActivation) {
					textArea.append(Game.donald.name + " activates the donald!\n");
					textArea.setCaretPosition(textArea.getDocument().getLength());
					labelDA.setText("Donald Activation : TRUE");
				}
				id++;
				num++;
				label.setText(Game.players[id].name);
				labelPoint.setText("");
				cl.last(container);
			}
		} else {
			try {
				URL songURL = getClass().getResource("error.wav");
				AudioInputStream input = AudioSystem.getAudioInputStream(songURL);
				Clip clip = AudioSystem.getClip();
				clip.open(input);
				clip.start();
			} catch (Exception e1) {
			}
		}
	}

}
