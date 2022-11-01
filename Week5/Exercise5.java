/**
* Class Exercise5
*
* COMP 1020 SECTION D01
* INSTRUCTOR Reyhaneh Ababzadeh
* ASSIGNMENT Exercise 5
* @author Shivam Sharma, 7885183
* @version 01-11-2022
*
* PURPOSE: This file has the check diagnal method and the modified check method.
*/
public class Exercise5{
    public static void check(int[][] array) {
		boolean overall;
		boolean rows, columns, diagonals;
		boolean values;
		int magicConstant;

		if (!isSquare(array)) {
			System.out.println("The array is not square.");
			overall = false;
		} else {
			magicConstant = magicConstant(array);
			System.out.println("The magic constant is " + magicConstant);
			rows = checkRows(array, magicConstant);
			columns = checkColumns(array, magicConstant);
			diagonals = checkDiagnals(array, magicConstant);
			values = checkValues(array, magicConstant);
			overall = rows && columns && values && diagonals;
		}

		if (overall) {
			System.out.println("This is a magic square.");
		} else {
			System.out.println("This is NOT a magic square.");
		}
	}

    public static boolean checkDiagnals(int[][] square, int magicConstant){
		int length = square.length;
		int invalid = 0;
		int sumOne = 0;
		int sumTwo = 0;

		for(int i=0 ; i<length ; i++){
			sumOne += square[i][i];
			sumTwo += square[i][4-i];
		}
		if(sumOne != magicConstant){
			invalid++;
		}
		if(sumTwo != magicConstant){
			invalid++;
		}
		System.out.println("There were " + invalid + " invalid diagonals");
		return invalid == 0;
	}
}