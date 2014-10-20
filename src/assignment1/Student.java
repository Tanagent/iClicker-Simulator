package assignment1;
import java.util.HashMap;

/**
 * The Student class holds an ID number for each student.
 * 
 * @author Brian Tan
 */
public class Student {
	private int studentID;

	public Student(int studentID) {
		this.studentID = studentID;
	}
	
	public int getStudentID(){
		return studentID;
	}

	public void setStudentID(int studentID){
		this.studentID = studentID;
	}
}
