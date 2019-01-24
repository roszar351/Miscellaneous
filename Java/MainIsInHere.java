import java.util.Scanner;

public class MainIsInHere {

	public static void main(String[] args) {		
		
		Scanner s = new Scanner(System.in);
		System.out.println("Input how many times to flip the coin: ");
		int num1 = s.nextInt();
		System.out.println("Input how many times to throw the die: ");
		int num2 = s.nextInt();
		s.close();
		System.out.println(Coin_Flip.flip(num1));
		System.out.println(Dice.throwDie(num2));
		Deck d = new Deck();
		d.fillDeck();
		System.out.println(PickACard.pickRandomCard(d));
	}
}
