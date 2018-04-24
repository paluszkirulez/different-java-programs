import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class test_class extends JFrame{
	private JTextField txtNumberInput;
	private JLabel outField;
	private int theNumber;
	private int Tries;
	
	public void checkGuess() { //method to check user input
		String guessText = txtNumberInput.getText();
		String outMassage = "";
		try { setTries(1);

		// check if the guess is to high or too low
			int Guess = Integer.parseInt(guessText);
			
			if(Guess > theNumber) {
				outMassage = "Number too high, try again; it is your "+Tries+"try";
				
			}
			else if(Guess < theNumber) {
				outMassage = "Number too low, try again; it is your "+Tries+"try";
				
			}
			else {
				outMassage = "Number is correct! New number is generated. It took you "+Tries+" tries";
				newGame();
				setTries(0);
			}
			if(Tries==7) {
				outMassage = "It was your last try, new number is generated";
				outField.setText(outMassage);
				newGame();
				setTries(0);
			}
		}
		catch(Exception e) {
			outMassage = "Input whole number between 0-100";
			outField.setText(outMassage);
		}
		
		
		finally{
			outField.setText(outMassage);
			txtNumberInput.requestFocus();
			txtNumberInput.selectAll();
		}
		
	}
	
	public void newGame() {//create new random number
		
		theNumber = (int)(Math.random()*100+1);
		
	}
	
	public void setTries (int x) {//class for changing tries value
		if(x == 0) {
			Tries = 0;
		}
		else {
			++Tries;
		}
	}
	
	public test_class() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		
		JLabel Top_Title = new JLabel("It's simple guessing game");
		Top_Title.setFont(new Font("Calibri", Font.BOLD, 19));
		Top_Title.setBounds(0, 16, 428, 20);
		Top_Title.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(Top_Title);
		
		JButton btnSubmit = new JButton("Submit answer");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				checkGuess();
			}
		});
		btnSubmit.setFont(new Font("Calibri", Font.PLAIN, 18));
		btnSubmit.setBackground(UIManager.getColor("CheckBox.background"));
		btnSubmit.setBounds(136, 161, 156, 31);
		getContentPane().add(btnSubmit);
		
		outField = new JLabel("Submit your number to get an answer");
		outField.setVerticalAlignment(SwingConstants.TOP);
		outField.setFont(new Font("Calibri", Font.PLAIN, 18));
		outField.setHorizontalAlignment(SwingConstants.CENTER);
		outField.setBounds(0, 221, 428, 58);
		getContentPane().add(outField);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(-8, 75, 445, 39);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel promptText = new JLabel("Gues a number between 1 and 100");
		promptText.setBounds(55, 8, 252, 23);
		panel.add(promptText);
		promptText.setFont(new Font("Calibri", Font.PLAIN, 18));
		promptText.setHorizontalAlignment(SwingConstants.LEFT);
		
		txtNumberInput = new JTextField();
		txtNumberInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});
		txtNumberInput.setBounds(337, 5, 48, 29);
		panel.add(txtNumberInput);
		txtNumberInput.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtNumberInput.setBackground(new Color(245, 245, 220));
		txtNumberInput.setColumns(3);
	}
	public static void main(String[] args) {
		test_class GuessingGame = new test_class();
		GuessingGame.newGame();
		GuessingGame.setSize(new Dimension(430, 430));
		GuessingGame.setVisible(true);
		
	}
}
