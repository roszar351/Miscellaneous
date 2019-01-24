import java.awt.Dimension;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

/* Created by Damian Skrzypek 
 * 24/01/2018
 */
public class GuessNumber {
	
	public static void main(String[] args) {
		UIManager.put("OptionPane.minimumSize",new Dimension(350,100));
		run();
	}

	public static int genNumber(int diff) {
		//how many difficulties? easy med hard veryHard >=>=> 4
		// easy 0-100 med 0-500 hard 0-1000
		int rand = 0;
		switch(diff) {
			case 0: rand = 101;
			break;
			case 1: rand = 501;
			break;
			case 2: rand = 1001;
			break;
			case 3: rand = 100001;
			break;
			default: rand = 0;
		}
		return (int) (Math.random() * rand);
	}
	
	public static void run() {
		int temp = 0;
		temp = JOptionPane.showConfirmDialog(null, "Do you want to play a game?",
				"Welcome!!", JOptionPane.YES_NO_OPTION);
		
		if(temp != 0) {;
			JOptionPane.showMessageDialog(null, "Bye!...", "Why u do dis", JOptionPane.PLAIN_MESSAGE);
		}else {
			Object[] difficulties = {"Easy", "Medium", "Hard", "Very Hard"};
			temp = JOptionPane.showOptionDialog(null, "Choose your difficulty", "How hard you want it ( ͡° ͜ʖ ͡°)", JOptionPane.DEFAULT_OPTION,
					JOptionPane.PLAIN_MESSAGE, null, difficulties, difficulties[0]);
			coreMech(temp);
			JOptionPane.showMessageDialog(null, "Good job you did it!", "~(˘▾˘~)  ヾ(⌐■_■)ノ♪   ~(˘▾˘~)", JOptionPane.INFORMATION_MESSAGE);
			run();
		}
	}
	
	public static void coreMech(int t) {
		boolean found = false;
		int[] dif = {100, 500, 1000, 100000};
		String temp = "";
		int num = genNumber(t), guess = -1, range = dif[t];
		System.out.println(num);
		while(!found) {
			do 	{
				guess = 0;
				try {
					guess = Integer.parseInt(JOptionPane.showInputDialog("Guess a number in the range 0 - " + range + " (inclusive)"));
					if(guess < 0 || guess > range) {
						JOptionPane.showMessageDialog(null, "ಠ益ಠ    Make sure value is in range i.e. 0 - " + range);
					}
				}catch(NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Invalid input. Window will be terminated.", "WRONG INPUT", 
							JOptionPane.ERROR_MESSAGE);
					System.exit(0);
				}
			}while(guess < 0 || guess > range);
			if(guess == num) {
				found = true;
			}else {
				temp = higherLower(num, guess);
				JOptionPane.showMessageDialog(null, "Guess " + temp, "┬──┬ ノ( ゜-゜ノ) ¯\\_(ツ)_/¯   (╯°□°）╯︵ ┻━┻",
						JOptionPane.ERROR_MESSAGE);
			}
		}
			
	}
	
	public static String higherLower(int n, int g) {
		int acc = n - g; // if number is 500 and guess is 100, 450, 550 , 600 then acc is 400, 50, -50, -100
		if(acc >= 100) {
			return "much higher";
		}else if(acc <= -100) {
			return "much lower";
		}else if(acc < 100 && acc > 0) {
			return "a bit higher";
		}else if(acc > -100 && acc < 0) {
			return "a bit lower";
		}
		return "Try again";
			
	}
}
