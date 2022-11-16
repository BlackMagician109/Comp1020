import java.util.*;

public class Exercise7 {
	public static void main(String[] args) {
		StudentList students = new StudentList();

		students.add(new Student(8032, "Casper", 2.78));
		students.add(new Student(3044, "Sheena", 3.92));
		students.add(new Student(6170, "Yolanda", 4.26));
		students.add(new Student(1755, "Geordi", 3.58));

		students.printByNumber();
		students.printByName();

		System.out.println("\nEnd of processing.");
	}
}

class Student {
	private int number;
	private String name;
	private double gpa;

	public Student(int number, String name, double gpa) {
		this.number = number;
		this.name = name;
		this.gpa = gpa;
	}

	public int getNumber() {
		return number;
	}

	public double getGPA() {
		return gpa;
	}

	public boolean nameComesBefore(Student other) {
		return name.compareToIgnoreCase(other.name) < 0;
	}

	public String toString() {
		return number + " " + name + " (" + gpa + ")";
	}
}

class StudentList {
	private ArrayList<Student> list;
		
	public StudentList() {
		list = new ArrayList<Student>();
	}
	
	public void add(Student student) {
		boolean done = false;
		int pos;

		// find the insertion point (this is just a linear search)
		pos = list.size() - 1;
		while (pos >= 0 && !done) {
			if (student.getNumber() > list.get(pos).getNumber()) {
				done = true;
			} else {
				pos--;
			}
		}

		list.add(pos + 1, student);
	}

	private void sortByName(ArrayList<Student> list){
		Student bufferStudent;

		for(int i=0 ; i<list.size()-1 ; i++){
			if(list.get(i+1).nameComesBefore(list.get(i))){
				bufferStudent = list.get(i);
				list.set(i, list.get(i+1));
				list.set(i+1, bufferStudent);
				i = -1;
			}
		}
	}

	public void printByName(){
		ArrayList<Student> toPrint = new ArrayList<Student>();
		toPrint = (ArrayList<Student>)list.clone();
		sortByName(toPrint);
		System.out.println("\nStudents ordered by name:");
		printStudents(toPrint);
	}

	public void printByNumber() {
		System.out.println("\nStudents ordered by number:");
		printStudents(list);
	}

	private void printStudents(ArrayList<Student> list) {
		System.out.println("\nList of all students:\n");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(i + 1 + ": " + list.get(i));
		}
	}
}
