import java.io.*;

public class Activity5D {
	public static void main(String[] args) {
		processSquaresFromFile("squares.txt");

		System.out.println("\nEnd of processing.");
	}

	public static void processSquaresFromFile(String filename) {
		BufferedReader inputFile;
		String firstLine;
		int[][] square;

		try {
			inputFile = new BufferedReader(new FileReader(filename));
			firstLine = inputFile.readLine();
			while (firstLine != null) {
				square = readSquare(inputFile, firstLine);
				printSquare(square);
				check(square);
				firstLine = inputFile.readLine();
			}
			inputFile.close();
		}
		catch (IOException ioe) {
			System.out.println(ioe.getMessage());
			ioe.printStackTrace();
		}
	}

	public static int[][] readSquare(BufferedReader inputFile, String firstLine)
	   throws IOException
	{
		String[] split;
		String inputLine;
		int[][] square;
		int squareSize;

		squareSize = Integer.parseInt(firstLine);
		System.out.println("\nSize: " + squareSize);
		square = new int[squareSize][squareSize];
		for (int row = 0; row < squareSize; row++) {
			inputLine = inputFile.readLine();
			System.out.println(inputLine);
			split = inputLine.split("\\s+");

			for (int col = 0; col < squareSize; col++) {
				square[row][col] = Integer.parseInt(split[col]);
			}
		}

		return square;
	}

	public static void printSquare(int[][] magicSquare) {
		for (int row=0; row < magicSquare.length; row++) {
			for (int col=0; col < magicSquare[row].length; col++) {
				System.out.print(magicSquare[row][col] +"\t");
			}
			System.out.println();
		}
	}

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

	public static boolean isSquare(int[][] array) {
		boolean result;

		if (array.length == 0) {
			result = true;
		} else {
			result = array.length == array[0].length;
		}

		return result;
	}

	public static int magicConstant(int[][] square) {
		return (square.length * (square.length * square.length + 1)) / 2;
	}

	public static boolean checkRows(int[][] square, int magicConstant) {
		int length;
		int wrong;
		int sum;

		length = square.length;

		wrong = 0;
		for (int row = 0; row < length; row++) {
			sum = 0;
			for (int col = 0; col < length; col++) {
				sum += square[row][col];
			}
			if (sum != magicConstant) {
				wrong++;
			}
		}

		System.out.println("There were " + wrong + " invalid rows.");
		return wrong == 0;
	}

	public static boolean checkColumns(int[][] square, int magicConstant) {
		int length;
		int wrong;
		int sum;

		length = square.length;

		wrong = 0;
		for (int col = 0; col < length; col++) {
			sum = 0;
			for (int row = 0; row < length; row++) {
				sum += square[row][col];
			}
			if (sum != magicConstant) {
				wrong++;
			}
		}

		System.out.println("There were " + wrong + " invalid columns.");
		return wrong == 0;
	}

	public static boolean checkValues(int[][] square, int magicConstant) {
		int[] counts;
		int length;
		int wrong;

		length = square.length;
		counts = new int[length * length + 1];

		wrong = 0;

		for (int row = 0; row < length; row++) {
			for (int col = 0; col < length; col++) {
				if (square[row][col] < 1 || square[row][col] > length * length) {
					wrong++;
				} else {
					counts[square[row][col]]++;
				}
			}
		}

		for (int i = 1; i <= length * length; i++) {
			if (counts[i] > 1) {
				wrong++;
			}
		}

		System.out.println("There were " + wrong + " repeated or invalid values.");
		return wrong == 0;
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
