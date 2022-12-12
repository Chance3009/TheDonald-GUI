import java.util.List;

public class Player {
	
	public String name;
    public int id;
    public int points;
    public int winningCriteria;
    public List<Card> handCard;
    public int bidNum;
    public Player teammate; 
    public Card myCard;
	public boolean isComputer;
	
	public Player(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return this.name;
	}
	
}
