package assignment1;
/**
 * This program displays a question, collects the answers from
 * the students and prints out statistical results.
 * 
 * @author Brian Tan
 * Assignment 1 - iClicker Simulator
 */

public class SimulationDriver {
	public static void main(String[] args) {	
		IClickerService start = new IClickerService();
		start.printQuestion();
		start.printResults(start.submissions());
	}

}
