package assignment1;

import java.util.HashMap;
import java.util.Random;

/**
 * This class creates the question and collects
 * the answers from the students.
 * 
 * @author Brian Tan
 */
public class IClickerService {
	// These fields give each students their ID number.
	private Student student1 = new Student(1);
	private Student student2 = new Student(2);
	private Student student3 = new Student(3);
	private Student student4 = new Student(4);
	private Student student5 = new Student(5);
	private Student student6 = new Student(6);
	private Student student7 = new Student(7);
	private Student student8 = new Student(8);
	private Student student9 = new Student(9);
	private Student student10 = new Student(10);
	private Student student11 = new Student(11);
	private Student student12 = new Student(12);
	private Student student13 = new Student(13);
	private Student student14 = new Student(14);
	private Student student15 = new Student(15);
	private Student student16 = new Student(16);
	// answers - the different answers the students are allowed to choose from.
	private char[] answers = { 'A', 'B', 'C', 'D', 'E', 'T', 'F'};
	// students - an array of all the students.
	private Student[] students = { student1, student2, student3, student4,
			student5, student6, student7, student8, student9, student10,
			student11, student12, student13, student14, student15,
			student16 };
	// random - the random number generator.
	private Random random;
	// type - determines if a question is a multiple choice or true/false question.
	private boolean type;
	
	public IClickerService(){
		random = new Random();
	}
	
	/**
	 * Randomly chooses between a multiple choice question
	 * or a True/False question and displays the question.
	 */
	public void printQuestion(){
		Question mc = new MultipleChoice();
		Question tf = new TrueOrFalse();
		Question[] question = {mc, tf};
		int randomNum = random.nextInt(2);
		if(question[randomNum] == mc){
			mc.setQuestion();
			type = true;
		}
		else{
			tf.setQuestion();
			type = false;
		}
	}
	
	/**
	 * This method allows each student to input their answers twice but
	 * would only collect their last input.
	 * 
	 * @return - a HashMap of all the students with their selected answers.
	 */
	public HashMap submissions(){
		HashMap<Integer, Character> input = new HashMap<Integer, Character>();
		// two for-loops to go through each student twice.
		for (int j = 0; j < 2; j++) {
			for (int i = 0; i < 16; i++) {
				int randomNum;
				if (type)
					randomNum = random.nextInt(5);
				else
					randomNum = random.nextInt(2) + 5;
				char selection = answers[randomNum];
				int ID = students[i].getStudentID();
				input.put(ID, selection);
			}
		}
		return input;
	}
	
	/**
	 * Prints out the statistical results.
	 * 
	 * @param input - the HashMap of all the students with their selected answers.
	 */
	public void printResults(HashMap<Integer, Character> input){
		if(type){
			int countA = 0;
			int countB = 0;
			int countC = 0;
			int countD = 0;
			int countE = 0;
			for (Character x : input.values()) {
				switch (x) {
				case 'A':
					countA++;
					break;
				case 'B':
					countB++;
					break;
				case 'C':
					countC++;
					break;
				case 'D':
					countD++;
					break;
				default:
					countE++;
					break;
				}
			}
			System.out.println("A: " + countA);
			System.out.println("B: " + countB);
			System.out.println("C: " + countC);
			System.out.println("D: " + countD);
			System.out.println("E: " + countE);
		} else {
			int countT = 0;
			int countF = 0;
			for (Character x : input.values()) {
				if (x == 'T')
					countT++;
				else
					countF++;
			}
			System.out.println("T: " + countT);
			System.out.println("F: " + countF);
		}
	}
}
