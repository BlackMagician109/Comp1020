/**
* Class Exercise5
*
* COMP 1020 SECTION D01
* INSTRUCTOR Reyhaneh Ababzadeh
* ASSIGNMENT Exercise 6
* @author Shivam Sharma, 7885183
* @version 08-11-2022
*
* PURPOSE: Consolidated code and created visiting student method.
*/
public class Exercise6 {
    class Student {
        private int number;
        private String name;
        private double gpa;
    
        public Student(int number, String name, double gpa) {
            this.number = number;
            this.name = name;
            this.gpa = gpa;
        }
    
        public boolean deansHonourList() {
            if(gpa >= honourGpa()){
                return true;
            }
            else{
                return false;
            }
        }
    
        public String toString() {
            return number + " " + name + " (" + gpa + ")";
        }
    
        public double honourGpa(){
            return 0.0;
        }
    }
    
    class UndergradStudent extends Student {
        private int year;
    
        public UndergradStudent(int number, String name, double gpa, int year) {
            super(number, name, gpa);
            this.year = year;
        }
    
        public double honourGpa() {
            return 3.5;
        }
    
        public String toString() {
            return "Undergraduate: " + super.toString() + " year: " + year;
        }
    }
    
    class GraduateStudent extends Student {
        private String thesis;
    
        public GraduateStudent(int number, String name, double gpa, String thesis) {
            super(number, name, gpa);
            this.thesis = thesis;
        }
    
        public double honourGpa() {
            return 3.75;
        }
    
        public String toString() {
            return "Graduate: " + super.toString() + " thesis: " + thesis;
        }
    }
    
    class VisitingStudent extends Student{
        //Instancer Variables
        String studentUni;
    
        //Constructor
        public VisitingStudent(int number, String name, double gpa, String studentUni){
            super(number, name, gpa);
            this.studentUni = studentUni;
        }
    
        //Instance Method
        public boolean deansHonourList(){
            return false;
        }
    
        public String toString(){
            return "Visiting Student: " + super.toString() + " Visiting from: " + studentUni;
        }
    }
}
