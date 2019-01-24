public class PickACard {
	
	public static Card pickRandomCard(Deck d) {
		if(d.getDeck().size() == 0) {
			return null;
		}
		int rand = (int) (Math.random() * d.getNumOfCards());
		return d.getDeck().get(rand);
	}
}
