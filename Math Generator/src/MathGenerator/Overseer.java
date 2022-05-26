package MathGenerator;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;


//This class controls the entire math generator program and all its functions.
public class Overseer{

	
	private int numCorrect = 0;
	private int numIncorrect = 0;
	
	
	
	private String name;
	private boolean isRico;
	private boolean startingGame = false;
	private boolean selectedGameModes = false;
	private List<Integer> modes = new ArrayList<Integer>();
	private int numQuestions = 0;
	
	
	//This gets a name from the player and starts the program
    public Overseer() {
		
	
		name = JOptionPane.showInputDialog("Welcome to SpeedyMaths! \nPlease input your name.\nIf you put in the name of a very special individual, \nyou are shown the answer to the expression.");
		isRico = name.equalsIgnoreCase("rico");
		
		getStarted();
		//defeat();
		
		
	}
    
    //This starts the program and runs all the methods in the class to make the game function.
    public void getStarted() {
    	selectedGameModes = false;
    	startingGame = false;
    	while(!startingGame) {
    		MainMenuButtons();
    	}
    	if(modes.isEmpty()) {
    		JOptionPane.showMessageDialog(null, "You did not choose any type of problems, please choose one.");
    		ButtonsButOnlyProblems();
    	}
    	
    	try {
    		numQuestions = Integer.parseInt(JOptionPane.showInputDialog("How many questions would you like to do?"));
    	}catch(Exception e) {
    		JOptionPane.showMessageDialog(null, "That is not a number, so you are going to be doing 10 questions.");
    	}
    	
    	if(numQuestions > 15) {
    		JOptionPane.showMessageDialog(null, "Dang thats alot you smarty pants.");
    	}
    	for(int i = 0; i < numQuestions; i++) {
    		start();
    	}
    	double numC = numCorrect;
		int percent = ((int) ((100 *((numC) / (numCorrect + numIncorrect))) + 0.5));
		String s = "You have done " + numQuestions + " questions, with "  + numCorrect + " correct and " + numIncorrect + " incorrect in total.\nThat is " + percent + "% correct";
		
    	String[] options = { "Exit", "Reset them", "Keep them"};
		int opt = JOptionPane.showOptionDialog(null, s + "\nNow you can do different types of operations or exit the program.\nIf you want to continue with different expressions, would you like to reset how many questions you got correct and incorrect?", "Choose an option below",JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[2]);
		
				
				
				
		if(opt == 1) {
			numCorrect = 0;
			numIncorrect = 0;
		}else if(opt == 0) {
			close();
		}
    	getStarted();
    	
    }

    
    //This shows all the types of problems in button for for the player to choose.
    public void ButtonsButOnlyProblems(){
    	
		String[] options = { "Done", "All Modes", "Roots", "Exponents", "Remainders", "Division", "Multiplication", "Subtraction", "Addition"};
		int opt = JOptionPane.showOptionDialog(null, "Welcome to SpeedyMaths!", "Choose all the types of problems you want to do below:",JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[1]);
		

		if(opt == 0) {
			selectedGameModes = true;
		}else if(opt == 1) {
			modes.add(1);
			modes.add(2);
			modes.add(3);
			modes.add(4);
			modes.add(5);
			modes.add(6);
			modes.add(7);
		}else if(opt == 2) {
			modes.add(1);
		}else if(opt == 3) {
			modes.add(2);
		}else if(opt == 4 ) {
			modes.add(3);
		}else if(opt == 5 ) {
			modes.add(4);
		}else if(opt == 6 ) {
			modes.add(5);
		}else if(opt == 7 ) {
			modes.add(6);
		}else if(opt == 8 ) {
			modes.add(7);
		}
		
    }
    
    //This shows all the options for the player to do in the program.
    public void MainMenuButtons() {
		
		String[] options = {"Close", "Start All Modes", "Select Modes", "Ready to Start", "How to Use"};
		int opt = JOptionPane.showOptionDialog(null, "Welcome to SpeedyMaths!", "Choose all the types of problems you want to do below:",JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[2]);
		
		if(opt == 1) {
			modes.add(1);
			modes.add(2);
			modes.add(3);
			modes.add(4);
			modes.add(5);
			modes.add(6);
			modes.add(7);
			startingGame = true;
		}else if(opt == 2) {
			while(!selectedGameModes)
				
				ButtonsButOnlyProblems();
		}else if(opt == 3) {
			startingGame = true;
		}else if(opt == 4 ) {
			teach();
		}else if(opt == 0 ) {
			close();
		}
		
	}
    
   

    //This gets the given modes the player selected and chooses a random type of problem from it to give to the player.
    public void start() {
    	//for(int i = 0; i < modes.size(); i++)
    	//System.out.println(modes.get(i));
    	int num = 0;
    	boolean isAMode = false;
    	
    	while(!isAMode) {
    		num = (int)(8 * Math.random());
    		for(int i = 0; i < modes.size(); i++) {
    			if(modes.get(i) == num) {
    				isAMode = true;
    			}
    		}
    	}
    	
    	if(num == 1) {
			startRoots();
		}else if(num == 2) {
			startExponents();
		}else if(num == 3 ) {
			startRemainders();
		}else if(num == 4 ) {
			startDivision();
		}else if(num == 5 ) {
			startMultiplication();
		}else if(num == 6 ) {
			startSubtraction();
		}else if(num == 7 ) {
			startAddition();
		}
    	
    }
	
    //This method presents a random addition problem to the player, gets their answer, and sees if they are right.
	public void startAddition(){

		int int1 = (int) (100 * Math.random());
		int int2 = (int) (100 * Math.random());
		
		while(int1 + int2 > 100) {
			int1 = (int) (100 * Math.random());
			int2 = (int) (100 * Math.random());
		}
		
		int answer = int1 + int2;
		
		String input;
		if(isRico) {
			input = JOptionPane.showInputDialog(int1 + " + " + int2 + " = ?\nThe answer is... " + (answer));
		}else {
			input = JOptionPane.showInputDialog(int1 + " + " + int2 + " = ?");
		}
		
		
		String[] options = {"Exit", "Switch Problems", "Do Another"};
		int opt = 0;
		try {
			if(Integer.parseInt(input) == answer){
				//good job
				numCorrect++;
				double numC = numCorrect;
				int percent = ((int) ((100 *((numC) / (numCorrect + numIncorrect))) + 0.5));
				opt = JOptionPane.showOptionDialog(null, "You got it correct!\n" + (int1 + " + " + int2 + " = " + answer) + "\nYou have done " + (numCorrect + numIncorrect) + " questions, with "  + numCorrect + " correct and " + numIncorrect + " incorrect.\nThat is " +  percent + "% correct" + "\nWould you like to do another problem, switch problems, or exit?", "Choose an option below", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[2]);
			
			}else {
				//bad job
				numIncorrect++;
				double numC = numCorrect;
				int percent = ((int) ((100 *((numC) / (numCorrect + numIncorrect))) + 0.5));
				
				opt = JOptionPane.showOptionDialog(null, "You got it incorrect!\n" + (int1 + " + " + int2 + " = " + answer) + "\nYou have done " + (numCorrect + numIncorrect) + " questions, with "  + numCorrect + " correct and " + numIncorrect + " incorrect.\nThat is " +  percent + "% correct" + "\nWould you like to do another problem, switch problems, or exit?", "Choose an option below", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[2]);
				
			}
		}catch(Exception e) {
			//you didnt put in a number idiot
			numIncorrect++;
			double numC = numCorrect;
			int percent = ((int) ((100 *((numC) / (numCorrect + numIncorrect))) + 0.5));
			
			opt = JOptionPane.showOptionDialog(null, "You got it incorrect! You did not even put in a number smh.\n" + (int1 + " + " + int2 + " = " + answer) + "\nYou have done " + (numCorrect + numIncorrect) + " questions, with "  + numCorrect + " correct and " + numIncorrect + " incorrect.\nThat is " +  percent + "% correct" + "\nWould you like to do another problem, switch problems, or exit?", "Choose an option below", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[2]);
			
		}
		
		if(opt == 0) {
			close();
		}else if(opt == 1) {
			getStarted();
		}else if(opt == 2) {
			
		}
		
		
	}
	
	//This method presents a random subtraction problem to the player, gets their answer, and sees if they are right.
	public void startSubtraction(){

		int int1 = (int) (100 * Math.random());
		int int2 = (int) (100 * Math.random());
		
		while(int1 - int2 > 100 || int1 - int2 < 0) {
			int1 = (int) (100 * Math.random());
			int2 = (int) (100 * Math.random());
		}
		
		int answer = int1 - int2;
		
		String input;
		if(isRico) {
			input = JOptionPane.showInputDialog(int1 + " - " + int2 + " = ?\nThe answer is... " + (answer));
		}else {
			input = JOptionPane.showInputDialog(int1 + " - " + int2 + " = ?");
		}
		
		
		String[] options = {"Exit", "Switch Problems", "Do Another"};
		int opt = 0;
		try {
			if(Integer.parseInt(input) == answer){
				//good job
				numCorrect++;
				double numC = numCorrect;
				int percent = ((int) ((100 *((numC) / (numCorrect + numIncorrect))) + 0.5));
				opt = JOptionPane.showOptionDialog(null, "You got it correct!\n" + (int1 + " - " + int2 + " = " + answer) + "\nYou have done " + (numCorrect + numIncorrect) + " questions, with "  + numCorrect + " correct and " + numIncorrect + " incorrect.\nThat is " +  percent + "% correct" + "\nWould you like to do another problem, switch problems, or exit?", "Choose an option below", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[2]);
			
			}else {
				//bad job
				numIncorrect++;
				double numC = numCorrect;
				int percent = ((int) ((100 *((numC) / (numCorrect + numIncorrect))) + 0.5));
				
				opt = JOptionPane.showOptionDialog(null, "You got it incorrect!\n" + (int1 + " - " + int2 + " = " + answer) + "\nYou have done " + (numCorrect + numIncorrect) + " questions, with "  + numCorrect + " correct and " + numIncorrect + " incorrect.\nThat is " +  percent + "% correct" + "\nWould you like to do another problem, switch problems, or exit?", "Choose an option below", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[2]);
				
			}
		}catch(Exception e) {
			//you didnt put in a number idiot
			numIncorrect++;
			double numC = numCorrect;
			int percent = ((int) ((100 *((numC) / (numCorrect + numIncorrect))) + 0.5));
			
			opt = JOptionPane.showOptionDialog(null, "You got it incorrect! You did not even put in a number smh.\n" + (int1 + " - " + int2 + " = " + answer) + "\nYou have done " + (numCorrect + numIncorrect) + " questions, with "  + numCorrect + " correct and " + numIncorrect + " incorrect.\nThat is " +  percent + "% correct" + "\nWould you like to do another problem, switch problems, or exit?", "Choose an option below", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[2]);
			
		}
		
		if(opt == 0) {
			close();
		}else if(opt == 1) {
			getStarted();
		}else if(opt == 2) {
			
		}
		
		
	}
	
	//This method presents a random multiplication problem to the player, gets their answer, and sees if they are right.
	public void startMultiplication(){

		int int1 = (int) (100 * Math.random());
		int int2 = (int) (100 * Math.random());
		
		while(int1 * int2 > 100) {
			int1 = (int) (100 * Math.random());
			int2 = (int) (100 * Math.random());
		}
		
		
		int answer = int1 * int2;
		
		String input;
		if(isRico) {
			input = JOptionPane.showInputDialog(int1 + " * " + int2 + " = ?\nThe answer is... " + (answer));
		}else {
			input = JOptionPane.showInputDialog(int1 + " * " + int2 + " = ?");
		}
		
		
		String[] options = {"Exit", "Switch Problems", "Do Another"};
		int opt = 0;
		try {
			if(Integer.parseInt(input) == answer){
				//good job
				numCorrect++;
				double numC = numCorrect;
				int percent = ((int) ((100 *((numC) / (numCorrect + numIncorrect))) + 0.5));
				opt = JOptionPane.showOptionDialog(null, "You got it correct!\n" + (int1 + " * " + int2 + " = " + answer) + "\nYou have done " + (numCorrect + numIncorrect) + " questions, with "  + numCorrect + " correct and " + numIncorrect + " incorrect.\nThat is " +  percent + "% correct" + "\nWould you like to do another problem, switch problems, or exit?", "Choose an option below", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[2]);
			
			}else {
				//bad job
				numIncorrect++;
				double numC = numCorrect;
				int percent = ((int) ((100 *((numC) / (numCorrect + numIncorrect))) + 0.5));
				
				opt = JOptionPane.showOptionDialog(null, "You got it incorrect!\n" + (int1 + " * " + int2 + " = " + answer) + "\nYou have done " + (numCorrect + numIncorrect) + " questions, with "  + numCorrect + " correct and " + numIncorrect + " incorrect.\nThat is " +  percent + "% correct" + "\nWould you like to do another problem, switch problems, or exit?", "Choose an option below", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[2]);
				
			}
		}catch(Exception e) {
			//you didnt put in a number idiot
			numIncorrect++;
			double numC = numCorrect;
			int percent = ((int) ((100 *((numC) / (numCorrect + numIncorrect))) + 0.5));
			
			opt = JOptionPane.showOptionDialog(null, "You got it incorrect! You did not even put in a number smh.\n" + (int1 + " * " + int2 + " = " + answer) + "\nYou have done " + (numCorrect + numIncorrect) + " questions, with "  + numCorrect + " correct and " + numIncorrect + " incorrect.\nThat is " +  percent + "% correct" + "\nWould you like to do another problem, switch problems, or exit?", "Choose an option below", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[2]);
			
		}
		
		if(opt == 0) {
			close();
		}else if(opt == 1) {
			getStarted();
		}else if(opt == 2) {
			
		}
		
	}
	
	//This method presents a random division problem to the player, gets their answer, and sees if they are right.
	public void startDivision() {

		int int1 = (int) (100 * Math.random());
		int int2 = (int) (100 * Math.random())  + 1;
		double double1 = int1;
		String s = double1 / int2 + "";
		
		
		if(int1 < int2) {
			int temp = int1;
			int1 = int2;
			int2 = temp;
			double1 = int1;
			s = double1 / int2 + "";
		}
		
		
		while(double1 / int2 > 100 || int2 == 0 || !s.substring(s.length()-2, s.length()).equals(".0")) {
			int1 = (int) (100 * Math.random());
			int2 = (int) (100 * Math.random()) + 1;
			double1 = int1;
			
			s = double1 / int2 + "";
			
			if(int1 < int2) {
				int temp = int1;
				int1 = int2;
				int2 = temp;
				double1 = int1;
				s = double1 / int2 + "";
			}
		}
		
		System.out.println(s);
		
		int answer = int1 / int2;
		
		String input;
		if(isRico) {
			input = JOptionPane.showInputDialog(int1 + " ÷ " + int2 + " = ?\nThe answer is... " + (answer));
		}else {
			input = JOptionPane.showInputDialog(int1 + " ÷ " + int2 + " = ?");
		}
		
		
		String[] options = {"Exit", "Switch Problems", "Do Another"};
		int opt = 0;
		try {
			if(Integer.parseInt(input) == answer){
				//good job
				numCorrect++;
				double numC = numCorrect;
				int percent = ((int) ((100 *((numC) / (numCorrect + numIncorrect))) + 0.5));
				opt = JOptionPane.showOptionDialog(null, "You got it correct!\n" + (int1 + " ÷ " + int2 + " = " + answer) + "\nYou have done " + (numCorrect + numIncorrect) + " questions, with "  + numCorrect + " correct and " + numIncorrect + " incorrect.\nThat is " +  percent + "% correct" + "\nWould you like to do another problem, switch problems, or exit?", "Choose an option below", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[2]);
			
			}else {
				//bad job
				numIncorrect++;
				double numC = numCorrect;
				int percent = ((int) ((100 *((numC) / (numCorrect + numIncorrect))) + 0.5));
				
				opt = JOptionPane.showOptionDialog(null, "You got it incorrect!\n" + (int1 + " ÷ " + int2 + " = " + answer) + "\nYou have done " + (numCorrect + numIncorrect) + " questions, with "  + numCorrect + " correct and " + numIncorrect + " incorrect.\nThat is " +  percent + "% correct" + "\nWould you like to do another problem, switch problems, or exit?", "Choose an option below", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[2]);
				
			}
		}catch(Exception e) {
			//you didnt put in a number idiot
			numIncorrect++;
			double numC = numCorrect;
			int percent = ((int) ((100 *((numC) / (numCorrect + numIncorrect))) + 0.5));
			
			opt = JOptionPane.showOptionDialog(null, "You got it incorrect! You did not even put in a number smh.\n" + (int1 + " ÷ " + int2 + " = " + answer) + "\nYou have done " + (numCorrect + numIncorrect) + " questions, with "  + numCorrect + " correct and " + numIncorrect + " incorrect.\nThat is " +  percent + "% correct" + "\nWould you like to do another problem, switch problems, or exit?", "Choose an option below", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[2]);
			
		}
		
		if(opt == 0) {
			close();
		}else if(opt == 1) {
			getStarted();
		}else if(opt == 2) {
			
		}
		
		
	}
	
	//This method presents a random remainders problem (where the player gives the remainder of a division problem as the answer) to the player, gets their answer, and sees if they are right.
	public void startRemainders() {

		int int1 = (int) (100 * Math.random());
		int int2 = (int) (100 * Math.random()) + 1;
		
		if(int1 < int2) {
			int temp = int1;
			int1 = int2;
			int2 = temp;
		}
		while(int1 % int2 > 100 || int2 == 0) {
			int1 = (int) (100 * Math.random());
			int2 = (int) (100 * Math.random()) + 1;
			if(int1 < int2) {
				int temp = int1;
				int1 = int2;
				int2 = temp;
			}
		}
		
		int answer = int1 % int2;
		
		String input;
		if(isRico) {
			input = JOptionPane.showInputDialog(int1 + " % " + int2 + " = ?\nThe answer is... " + (answer));
		}else {
			input = JOptionPane.showInputDialog(int1 + " % " + int2 + " = ?");
		}
		
		
		String[] options = {"Exit", "Switch Problems", "Do Another"};
		int opt = 0;
		try {
			if(Integer.parseInt(input) == answer){
				//good job
				numCorrect++;
				double numC = numCorrect;
				int percent = ((int) ((100 *((numC) / (numCorrect + numIncorrect))) + 0.5));
				opt = JOptionPane.showOptionDialog(null, "You got it correct!\n" + (int1 + " % " + int2 + " = " + answer) + "\nYou have done " + (numCorrect + numIncorrect) + " questions, with "  + numCorrect + " correct and " + numIncorrect + " incorrect.\nThat is " +  percent + "% correct" + "\nWould you like to do another problem, switch problems, or exit?", "Choose an option below", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[2]);
			
			}else {
				//bad job
				numIncorrect++;
				double numC = numCorrect;
				int percent = ((int) ((100 *((numC) / (numCorrect + numIncorrect))) + 0.5));
				
				opt = JOptionPane.showOptionDialog(null, "You got it incorrect!\n" + (int1 + " % " + int2 + " = " + answer) + "\nYou have done " + (numCorrect + numIncorrect) + " questions, with "  + numCorrect + " correct and " + numIncorrect + " incorrect.\nThat is " +  percent + "% correct" + "\nWould you like to do another problem, switch problems, or exit?", "Choose an option below", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[2]);
				
			}
		}catch(Exception e) {
			//you didnt put in a number idiot
			numIncorrect++;
			double numC = numCorrect;
			int percent = ((int) ((100 *((numC) / (numCorrect + numIncorrect))) + 0.5));
			
			opt = JOptionPane.showOptionDialog(null, "You got it incorrect! You did not even put in a number smh.\n" + (int1 + " % " + int2 + " = " + answer) + "\nYou have done " + (numCorrect + numIncorrect) + " questions, with "  + numCorrect + " correct and " + numIncorrect + " incorrect.\nThat is " +  percent + "% correct" + "\nWould you like to do another problem, switch problems, or exit?", "Choose an option below", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[2]);
			
		}
		
		if(opt == 0) {
			close();
		}else if(opt == 1) {
			getStarted();
		}else if(opt == 2) {
			
		}
		
		
	}
	
	//This method presents a random exponential problem to the player, gets their answer, and sees if they are right.
	public void startExponents() {

		int int1 = (int) (10 * Math.random());
		int int2 = (int) (4 * Math.random());
		
		
		while((int)Math.pow(int1, int2) > 100) {
			int1 = (int) (10 * Math.random());
			int2 = (int) (4 * Math.random());
		}
		
		int answer = (int)Math.pow(int1, int2);
		
		String input;
		if(isRico) {
			input = JOptionPane.showInputDialog(int1 + "^" + int2 + " = ?\nThe answer is... " + (answer));
		}else {
			input = JOptionPane.showInputDialog(int1 + "^" + int2 + " = ?");
		}
		
		
		String[] options = {"Exit", "Switch Problems", "Do Another"};
		int opt = 0;
		try {
			if(Integer.parseInt(input) == answer){
				//good job
				numCorrect++;
				double numC = numCorrect;
				int percent = ((int) ((100 *((numC) / (numCorrect + numIncorrect))) + 0.5));
				opt = JOptionPane.showOptionDialog(null, "You got it correct!\n" + (int1 + "^" + int2 + " = " + answer) + "\nYou have done " + (numCorrect + numIncorrect) + " questions, with "  + numCorrect + " correct and " + numIncorrect + " incorrect.\nThat is " +  percent + "% correct" + "\nWould you like to do another problem, switch problems, or exit?", "Choose an option below", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[2]);
			
			}else {
				//bad job
				numIncorrect++;
				double numC = numCorrect;
				int percent = ((int) ((100 *((numC) / (numCorrect + numIncorrect))) + 0.5));
				
				opt = JOptionPane.showOptionDialog(null, "You got it incorrect!\n" + (int1 + "^" + int2 + " = " + answer) + "\nYou have done " + (numCorrect + numIncorrect) + " questions, with "  + numCorrect + " correct and " + numIncorrect + " incorrect.\nThat is " +  percent + "% correct" + "\nWould you like to do another problem, switch problems, or exit?", "Choose an option below", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[2]);
				
			}
		}catch(Exception e) {
			//you didnt put in a number idiot
			numIncorrect++;
			double numC = numCorrect;
			int percent = ((int) ((100 *((numC) / (numCorrect + numIncorrect))) + 0.5));
			
			opt = JOptionPane.showOptionDialog(null, "You got it incorrect! You did not even put in a number smh.\n" + (int1 + "^" + int2 + " = " + answer) + "\nYou have done " + (numCorrect + numIncorrect) + " questions, with "  + numCorrect + " correct and " + numIncorrect + " incorrect.\nThat is " +  percent + "% correct" + "\nWould you like to do another problem, switch problems, or exit?", "Choose an option below", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[2]);
			
		}
		
		if(opt == 0) {
			close();
		}else if(opt == 1) {
			getStarted();
		}else if(opt == 2) {
			
		}
		
		
	}
	
	
	//This method presents a random roots problem to the player, gets their answer, and sees if they are right.
	public void startRoots() {

		int[] two = {4, 9, 16, 25, 36, 49, 64, 81, 100, 121, 144, 169, 196, 225, 256, 289, 324, 361, 400, 441, 484, 529, 576, 625, 676, 729, 784, 841, 900, 961};
		int[] three = {1, 8, 27, 64, 125, 216, 343, 512, 729, 100};
		int[] four = {0, 1, 16, 81, 256, 625};
		
		
		int int1 = (int) (4 * Math.random()) + 1;
		int int2 = 0;
		
		if(int1 == 1) {
			int2 = (int)(100 * Math.random());
		}else if(int1 == 2) {
			int2 = two[(int)(two.length * Math.random())];
		}else if(int1 == 3) {
			int2 = three[(int)(three.length * Math.random())];
		}else if(int1 == 4) {
			int2 = four[(int)(four.length * Math.random())];
		}
	   
		//System.out.println(int1 + " " + int2);
		double double1 = int1;
		
		int answer = (int)Math.round(Math.pow(int2, 1.0 / int1));
		
		String input;
		if(isRico) {
			input = JOptionPane.showInputDialog(int1 + "√" + int2 + " = ?\nThe answer is... " + (answer));
		}else {
			input = JOptionPane.showInputDialog(int1 + "√" + int2 + " = ?");
		}
		
		
		String[] options = {"Exit", "Switch Problems", "Do Another"};
		int opt = 0;
		try {
			if(Integer.parseInt(input) == answer){
				//good job
				numCorrect++;
				double numC = numCorrect;
				int percent = ((int) ((100 *((numC) / (numCorrect + numIncorrect))) + 0.5));
				opt = JOptionPane.showOptionDialog(null, "You got it correct!\n" + (int1 + "√" + int2 + " = " + answer) + "\nYou have done " + (numCorrect + numIncorrect) + " questions, with "  + numCorrect + " correct and " + numIncorrect + " incorrect.\nThat is " +  percent + "% correct" + "\nWould you like to do another problem, switch problems, or exit?", "Choose an option below", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[2]);
			
			}else {
				//bad job
				numIncorrect++;
				double numC = numCorrect;
				
				int percent = ((int) ((100 *((numC) / (numCorrect + numIncorrect))) + 0.5));
				
				opt = JOptionPane.showOptionDialog(null, "You got it incorrect!\n" + (int1 + "√" + int2 + " = " + answer) + "\nYou have done " + (numCorrect + numIncorrect) + " questions, with "  + numCorrect + " correct and " + numIncorrect + " incorrect.\nThat is " +  percent + "% correct" + "\nWould you like to do another problem, switch problems, or exit?", "Choose an option below", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[2]);
				
			}
		}catch(Exception e) {
			//you didnt put in a number idiot
			numIncorrect++;
			double numC = numCorrect;
			int percent = ((int) ((100 *((numC) / (numCorrect + numIncorrect))) + 0.5));
			
			opt = JOptionPane.showOptionDialog(null, "You got it incorrect! You did not even put in a number smh.\n" + (int1 + "√" + int2 + " = " + answer) + "\nYou have done " + (numCorrect + numIncorrect) + " questions, with "  + numCorrect + " correct and " + numIncorrect + " incorrect.\nThat is " +  percent + "% correct" + "\nWould you like to do another problem, switch problems, or exit?", "Choose an option below", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[2]);
			
		}
		
		if(opt == 0) {
			close();
		}else if(opt == 1) {
			getStarted();
		}else if(opt == 2) {
			
		}
		
	}
	
	
	
	
	
	
	
	
	
	//This method teahes the player how to use the program with instructions.
	public void teach() {
		
		String[] options = 
			{"Let's Start"};
		
		
		int opt = JOptionPane.showOptionDialog(null, 
				"SpeedyMaths is a very simple \"Brain Exerciser.\""
				+ "\nYou first choose which type of problems you want to do."
				+ "\nOnce you have choosen all of them, you input how many of those problems you want to do."
				+ "\nThen, you will be shown a random type of problem from the ones you selected."
				+ "\nYou just input the correct answer and click enter."
				+ "\nYou are also shown how many you got correct and incorrect throughout all the problems."
				+ "\nOnce you have done how many problems you chose to do, you can select new types of problems."
				+ "\nAt anytime after you finished a problem, you can choose to select different problems,\nor keep going with the ones you selected."
				+ "\n\nThe types of problems are..."
				+ "\nAddition (+), Subtraction (-), Multiplication (*), Division (÷),"
				+ "\nRemainders (%), Exponents (^), and Roots (√)"
				+ "\nThe problems will just be shown with 2 numbers and a sign between them, you just calculate it and write your answer."
				+ "\nThe remainders will be shown like this: 9%4, as in the remainder of 9 ÷ 4, which equals 1."
				+ "\nThe exponents will be shown like this: 2^3, as in the 2 to the 3rd power, which equals 8."
				+ "\nThe roots will be shown like this: 3√27, as in the third root of 27, which equals 3."
				, "Click the button below when you are done.",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
			//convert();
	}
	

	//This closes the program.
	public void close() {
		JOptionPane.showMessageDialog(null, "Hope you had a fun time using SpeedyMaths!");
		System.exit(0);
	}
	
	
	
	
}
