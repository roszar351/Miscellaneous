import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.UIManager;

/**
 * @author Damian Skrzypek
 * <dd> 09/02/2018 </dd>
 */
public class MemoryGame
{
	static final char[] c = {'R', 'B', 'G', 'Y'};
	static final JDialog dialog = new JDialog();
	static boolean gameOver;
	static ArrayList<Character> ans = new ArrayList<>();
	static ArrayList<Character> guess = new ArrayList<>();
	static int score;
	static int dif = 3;
	static String secret = "";
	
	public static void main(String[] args)
	{
		UIManager.put("OptionPane.minimumSize",new Dimension(350,100));
		UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 18));
		UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 16));
		run();
	}
	
	public static void run()
	{
		gameOver = false;
		score = 0;
		dif = 3;
		start();
		while(!gameOver)
		{
			answer(dif);
			dif++;
			inputForGuess();
			checkGuess();
		}	
		JOptionPane.showMessageDialog(null, "You finished playing with score of: " + score);
		run();
	}
		
	public static void start()
	{
		int c;
		c = JOptionPane.showConfirmDialog(null, "Do you want to play?", "Elo320", JOptionPane.YES_NO_OPTION);
		if(c != 0)
			System.exit(0);
	}
	
	public static void answer(int d)
	{
		ans.clear();
		for(int i = 0; i < d; i++)
		{
			ans.add(c[((int) (Math.random() * 4))]);
		}
		JOptionPane optionPane = new JOptionPane("Remember these:\n" + ans, JOptionPane.INFORMATION_MESSAGE,
								 JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null);
		dialog.setSize(350, 150);
		dialog.setLocationRelativeTo(null);
		dialog.setTitle("Hello there");
		dialog.setModal(true);
		dialog.setContentPane(optionPane);
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.pack();

		@SuppressWarnings("serial")
		Timer timer = new Timer(5000, new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				dialog.dispose();
			}
		});
		timer.setRepeats(false);//the timer should only go off once
		//start timer to close JDialog as dialog modal we must start the timer before its visible
		timer.start();
		dialog.setVisible(true);
	}
	
	public static void inputForGuess()
	{
		guess.clear();
		String g = "";
		g = JOptionPane.showInputDialog(null, "Input the pattern(not case sensitive)");
		if(g == null) System.exit(0);
		secret = g;
		g = g.replaceAll("[^RBGYrgby]", "");
		g = g.toUpperCase();
		for(int i = 0; i < g.length(); i++)
			guess.add(g.charAt(i));
		
	}
	
	public static void checkGuess()
	{
		if(secret.equalsIgnoreCase("pierdol sie pawel"))
		{
			JOptionPane.showMessageDialog(null, "Cheater!");
			score += 20;
		}
		else if(secret.equalsIgnoreCase("eoghan"))
		{
			JOptionPane.showMessageDialog(null, "You lose! :(");
			score = -9999999;
			gameOver = true;
		}
		else if(secret.equalsIgnoreCase("damian is the best"))
		{
			JOptionPane.showMessageDialog(null, "You are right, but u still lose :(");
			score = 0;
			gameOver = true;
		}
		else if(secret.equalsIgnoreCase("This game sucks"))
		{
			JOptionPane.showMessageDialog(null, "Okay then ;(....");
			gameOver = true;
		}
		else
		{
			if(ans.size() != guess.size())
				gameOver = true;
			else
				for(int i = 0; i < ans.size(); i++)
					if(ans.get(i) != guess.get(i)) gameOver = true;
			if(!gameOver)
			{
				JOptionPane.showMessageDialog(null, "Good job!");
				score++;
			}
		}
	}
}