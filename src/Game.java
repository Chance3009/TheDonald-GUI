import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import javax.swing.JOptionPane;

public class Game {
	
	public static int numOfPlayer;
	public static int highestBid;
	public static List<Player> bidPlayer = new ArrayList<>();
	public static Player donald;
	public static Player[] players = {new Player(1), new Player(2), new Player(3), new Player(4)};
	public static Player[] donaldTeam = new Player[2];
	public static Player[] nonDonaldTeam = new Player[2];
	public static Card.Color donaldColor;
	public static boolean isNoDonald;
	public static int round;
	public static Player first;
	public static Card.Color firstColor;
	public static boolean donaldActivation;
	public static Player[] winner;
	
	public static void startGame() {
		Card.newCardDeck();
		Card.shuffle(Card.cards);
		players[0].handCard = new ArrayList<Card>(Card.cards.subList(0, 13));
		players[1].handCard = new ArrayList<Card>(Card.cards.subList(13, 26));
		players[2].handCard = new ArrayList<Card>(Card.cards.subList(26, 39));
		players[3].handCard = new ArrayList<Card>(Card.cards.subList(39, 52));
    	
    	Collections.sort(players[0].handCard);
    	Collections.sort(players[1].handCard);
    	Collections.sort(players[2].handCard);
    	Collections.sort(players[3].handCard);
	}
	
	public static void chooseDonald() {
		Random random = new Random();
		if (bidPlayer.size() == 0) {
			donald = players[random.nextInt(4)];
			Game.highestBid = random.nextInt(6)+1;
			JOptionPane.showMessageDialog(null, "<html> The donald are chosen randomly <br> " + donald.name + ", you will be the donald! <br> The random donald number is " + Game.highestBid + " </html>");
		} else if (bidPlayer.size() == 1){
			donald = bidPlayer.get(0);
			JOptionPane.showMessageDialog(null, donald.name + ", you are the donald!");
		} else {
			donald = bidPlayer.get(random.nextInt(bidPlayer.size()));
			JOptionPane.showMessageDialog(null, "<html> The donald are chosen randomly between " + bidPlayer.size() + " players <br> " + donald.name + ", you will be the donald! </html>");
		}
		donaldTeam[0] = donald;
		first = donald;
	}
	
	public static void chooseTeammate() {
		int i = 0;
		for (Player p : players) {
			if (!Arrays.asList(donaldTeam).contains(p)) {
				if (i == 0) {
					nonDonaldTeam[0] = p;
					i++;
				} else {
					nonDonaldTeam[1] = p;
				}
				
			}
		}
		donaldTeam[0].winningCriteria = 6 + highestBid; 
		donaldTeam[1].winningCriteria = 6 + highestBid; 
		nonDonaldTeam[0].winningCriteria = 8 - highestBid;
		nonDonaldTeam[1].winningCriteria = 8 - highestBid;
	}
	
	public static boolean isValidCard(Player p, int temp) {
	    int validCount = 0;
	    for (Card card : p.handCard) {
	    	if (card.color == firstColor) {
	    			validCount++;
	    		}	
	    	}
	    Card.Color tempColor =  p.handCard.get(temp).color;
	    return (p.id == first.id || validCount == 0 || (validCount > 0 && tempColor == firstColor));
	}
	
	public static void playCard(Player p, int temp) {
		p.myCard = p.handCard.remove(temp);
		if (p.id == first.id) {
			firstColor = p.myCard.color;
		}
		if (p.id == donald.id && p.myCard.color == donaldColor) {
			donaldActivation = true;
		}
		if (donaldActivation && p.myCard.color == donaldColor) {
			p.myCard.tempValue+=26;
		} else if (p.myCard.color == firstColor) {
			p.myCard.tempValue+=13;
		}
	}
	
	public static void calculateScore() {
		List<Integer> cardValue = Arrays.asList(players[0].myCard.tempValue, players[1].myCard.tempValue, players[2].myCard.tempValue, players[3].myCard.tempValue);
		int max = Collections.max(cardValue);				
		int maxIndex = cardValue.indexOf(max);
		first = players[maxIndex];
		first.points++;
	}
	
	public static boolean checkScore() {
		if ((donaldTeam[0].points + donaldTeam[1].points) >= donaldTeam[0].winningCriteria) {
			winner = donaldTeam;
			return true;
		} else if ((nonDonaldTeam[0].points + nonDonaldTeam[1].points) >= Game.nonDonaldTeam[0].winningCriteria) {
			winner = nonDonaldTeam;
			return true;
		}
		return false;
	}
	
}
