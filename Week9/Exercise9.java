/**
* Class Exercise9
*
* COMP 1020 SECTION D01
* INSTRUCTOR Reyhaneh Ababzadeh
* ASSIGNMENT Exercise 9
* @author Shivam Sharma, 7885183
* @version 22-11-2022
*
* PURPOSE: To modify the completed emergency room program
*          to add additional features.
*/

public class Exercise9 {
    class PatientList {
        private PatientNode head;
        private int lastArrival;
        private int size;
    
        public PatientList() {
            head = null;
            lastArrival = 0;
            this.size = 0;
        }
        
        public void add(String name, int severity) {
            Patient patient;
            
            lastArrival++;
            patient = new Patient(name, lastArrival, severity);
    
            head = new PatientNode(patient, head);
            size++;
        }
        
        public Patient nextAdmission() {
            PatientNode current;
            PatientNode previous;
            PatientNode toAdmitCurrent = null;
            PatientNode toAdmitPrevious = null;
            
            current = head;
            previous = null;
            while (current != null) {
                if (toAdmitCurrent == null) {
                    toAdmitCurrent = current;
                } else {
                    if (current.data.isAdmittedBefore(toAdmitCurrent.data, lastArrival)) {
                        toAdmitCurrent = current;
                        toAdmitPrevious = previous;
                    }
                }
                previous = current;
                current = current.next;
            }
            
            if (toAdmitCurrent != null) {
    
                if (toAdmitPrevious == null) {
                    head = toAdmitCurrent.next;
                } else {
                    toAdmitPrevious.next = toAdmitCurrent.next;
                }
                size--;
                return toAdmitCurrent.data;
            } else {
                return null;
            }
        }
        
        public void print() {
            PatientNode current;
            //int size = 0;
            
            current = head;
            while (current != null) {
                System.out.println(current.data);
                //size++;
                current = current.next;
            }
            
            System.out.println("Size = " + size());
            System.out.println("Last arrival = " + lastArrival);
        }
    
        public int size(){
            return this.size;
        }
        
        public PatientList clone() {
            PatientList copy;
            PatientNode current;
            PatientNode copyCurrent;
            PatientNode newNode;
            
            copy = new PatientList();
            current = head;
            copyCurrent = null;
            while (current != null) {
                newNode = new PatientNode(current.data, null);
                if (copyCurrent == null) {
                    copy.head = newNode;
                } else {
                    // last node in copy points to the new node
                    copyCurrent.next = newNode;
                }
                // move to the next node in both lists
                copyCurrent = newNode;
                current = current.next;
            }
            copy.lastArrival = lastArrival;
            copy.size = this.size;
            return copy;
        }
    }

    class Patient {
        private String name;
        private int arrival;
        private int severity;
        
        public Patient(String name, int arrival, int severity) {
            this.name = name;
            this.arrival = arrival;
            this.severity = severity;
        }
        
        public boolean isAdmittedBefore(Patient other, int lastArrival) {
            boolean before;
            int priority, otherPriority;
    
            if (severity == 3) {
                // admitted before, unless the other's severity is 3 and arrived earlier
                before = (other.severity != 3) || (other.arrival > arrival);
            } else if (other.severity == 3) {
                before = false;
            } else {
                priority = (lastArrival - arrival) * severity;
                otherPriority = (lastArrival - other.arrival) * other.severity;
                before = (priority > otherPriority) ||
                         ((priority == otherPriority) && other.arrival > arrival);
            }
            
            return before;
        }
        
        public String toString() {
            return name + " arrived at " + arrival + " with severity " + severity;
        }
    }
}
