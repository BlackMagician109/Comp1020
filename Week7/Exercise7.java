/**
* Class Exercise7
*
* COMP 1020 SECTION D01
* INSTRUCTOR Reyhaneh Ababzadeh
* ASSIGNMENT Exercise 7
* @author Shivam Sharma, 7885183
* @version 15-11-2022
*
* PURPOSE: To sort the provided array by name.
*/

import java.util.*;

public class Exercise7 {
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
    
}
