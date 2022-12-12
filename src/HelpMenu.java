import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.io.InputStreamReader;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


@SuppressWarnings("serial")
public class HelpMenu extends JPanel {
	
	JButton backButton;
	
	public HelpMenu() {
		
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setFont(new Font("Candara", Font.PLAIN, 20));
		textArea.setWrapStyleWord(true);
		textArea.setEditable(false);
		textArea.setForeground(new Color(249,211,26));
		textArea.setBackground(new Color(41,40,38));
		textArea.setMargin(new Insets(10,10,10,10));
		
		try {
			InputStreamReader reader =  new InputStreamReader(getClass().getResourceAsStream("GameRule.txt"));
			textArea.read(reader, "GameRule");
			reader.close();
		}
		catch (Exception e){
		}	

		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setPreferredSize(new Dimension(1280, 720));
		setPreferredSize(new Dimension(1280, 720));
		add(scrollPane);
		
		backButton = new JButton("Back");
		backButton.setBounds(1000, 720, 200, 50);
		backButton.setFont(new Font("Arial", Font.PLAIN, 25));
		backButton.setBackground(Color.LIGHT_GRAY);
		backButton.setFocusable(false);
		textArea.add(backButton);
		
	}
}
