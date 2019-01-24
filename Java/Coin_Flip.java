public class Coin_Flip {
	
	public static void flip() {
		int rand = (int)(Math.random() * 2);
		String result = "";
		if(rand == 0) {
			result = "Heads";
		}else {
			result = "Tails";
		}
		System.out.println("Result: " + result);
	}
	
	public static String flip(int n) {
		String result = "";
		int hot = 0, heads = 0, tails = 0;
		for(int i = 0; i < n; i++) {
			hot = (int) (Math.random() * 2);
			if(hot == 0) {
				heads++;
			}else {
				tails++;
			}
		}
		result += "For " + n + " throw(s), the result is: " + "\n" + heads + " Heads and " + tails + " Tails" + "\n\n";
		return result;
	}
}
