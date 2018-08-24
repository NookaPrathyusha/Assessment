package RandomAndDictionary;
import java.util.InputMismatchException;
import java.util.Scanner;

public class RandomNumbers {
	static int randomNumbersCount = 500;
	static int input;
	public static void main(String[] args) {
		// Create array object
		int[] randomNumbersList = new int[randomNumbersCount];
		// Generate random numbers
		generateRandomNumbers(randomNumbersList); 
		// Sort random numbers
		arraySort(randomNumbersList); 
		System.out.print("Please enter a number between 1 and "	+ randomNumbersCount + ": ");
		try{
			Scanner sc = new Scanner(System.in);
			input = sc.nextInt();
		}catch(InputMismatchException e){
			System.out.println("Entered value is incorrect");
			e.printStackTrace();
		}
		if (input >= 1 && input <= randomNumbersCount) {
			// random numbers to string
			String result = "";
			for (int j = 0; j < randomNumbersList.length; j++) {
				result += " " + randomNumbersList[j];
			}
			// Print all random number
			System.out.println("The Numbers are" + result);
			// Print user input nth number
			if (input == 1) {
				System.out.println("The "+ input + "st number is "+ findNthSmallestNumber(input,randomNumbersList) + ".");
			} else if (input == 2) {
				System.out.println("The "+ input+ "nd number is "+ findNthSmallestNumber(input,randomNumbersList) + ".");
			} else if (input == 3) {
				System.out.println("The "+ input+ "rd number is "+ findNthSmallestNumber(input,randomNumbersList) + ".");
			} else {
				System.out.println("The "+ input+ "th number is "+ findNthSmallestNumber(input,randomNumbersList) + ".");
			}
		}
		else{
			System.out.println("The entered value "+ input+" is not with in the range of 1 to "+randomNumbersCount);
		}
	}

	// Generate random number method
	public static void generateRandomNumbers(int[] arraylist) 
	{
		for (int i = 0; i < arraylist.length; i++) {
			arraylist[i] = (int) (Math.random() * randomNumbersCount);
		}
	}

	// Array sort method
	public static void arraySort(int[] arraylist) 
	{
		int temp;
		for (int i = 1; i < arraylist.length; i++) 
		{
			for (int j = 0; j < arraylist.length - i; j++) 
			{
				if (arraylist[j] > arraylist[j + 1]) 
				{
					temp = arraylist[j];
					arraylist[j] = arraylist[j + 1];
					arraylist[j + 1] = temp;
				}
			}
		}
	}

	// find nth smallest method
	public static int findNthSmallestNumber(int n, int[] numbers) 
	{
		return numbers[n - 1];
	}
}
