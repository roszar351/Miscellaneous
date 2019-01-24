public class Dice {
	
	public static String throwDie(int n) {
		String result = "";
		int random = 0;
		int one = 0, two = 0, three = 0, four = 0, five = 0, six = 0;
		for(int i = 0; i < n; i++) {
			random = (int) (Math.random() * 6 + 1);
			if(random == 1) {
				one++;
			}else if(random == 2) {
				two++;
			}else if(random == 3) {
				three++;
			}else if(random == 4) {
				four++;
			}else if(random == 5) {
				five++;
			}else {
				six++;
			}
		}
		result += "Dice was thrown " + n + " times, the result is: " + "\n1's: " + one + "\n2's: " + two + "\n3's: " + three + "\n4's: " + four + "\n5's: " + five + "\n6's: " + six + "\n\n";
		return result;
	}
}
