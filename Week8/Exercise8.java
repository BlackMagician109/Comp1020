/**
* Class Exercise8
*
* COMP 1020 SECTION D01
* INSTRUCTOR Reyhaneh Ababzadeh
* ASSIGNMENT Exercise 8
* @author Shivam Sharma, 7885183
* @version 22-11-2022
*
* PURPOSE: Created an ackermann function.
*/
public class Exercise8{

    //Instance Method
    public static int ackermann(int m, int n){
        if(m == 0){
            return n+1;
        }
        else{
            if(n == 0){
                return ackermann(m-1, 1);
            }
            else{
                return ackermann(m-1, ackermann(m, n-1));
            }
        }
    }
}