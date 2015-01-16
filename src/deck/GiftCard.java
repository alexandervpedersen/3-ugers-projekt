package deck;
import entity.Player;

public class GiftCard extends RecieveCard {
	private Player[] playerlist;

	public GiftCard(String message, int bonus, Player[] playerlist) {
		super(message, bonus);
		this.playerlist = playerlist;
	}
	
	public void drawCard(Player player) {
		for (int i=0; i < playerlist.length; i++) {
			boolean t = player.equals(playerlist[i]);
			if (!t) {
				if (player.account.getScore()<playerlist[i].account.getScore()){
					player.setStatus(true);
					player.account.setScore(0);
				}		
				else
				playerlist[i].account.addPoints(-bonus);
			}
		}
		player.account.addPoints(bonus*(playerlist.length-1));
	}
}
