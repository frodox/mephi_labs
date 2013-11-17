/**
 * 
 */
package com.bitthinker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Cristian
 * @var 20
 * @lab_num 3
 * @date 2013/11/17
 * @task: ...
 */
public class Lab3 {

	public Lab3() {
		
	}

	/**
	 * Convert Integer into array
	 * @param guess
	 * 		int to convert. Must be positive!
	 * 		Trim sign at the start.
	 * @return 
	 * 		int[] array with numbers in each ceil
	 */
	public static int[] Int2Array(int guess)
	{
		String temp = Integer.toString(guess);
		int tempLength = 0;
		
		// Trim possible sign
		if ('-' == temp.charAt(0) || '+' == temp.charAt(0)) {
			temp = temp.substring(1);
		}
		tempLength = temp.length();
		int intArray[] = new int[tempLength];
		
		for (int i = 0; i < tempLength; i++) {
			intArray[i] = temp.charAt(i) - '0';
		}

		return intArray;
	}

	
	/**
	 * Calculate plus-Minus sum of given array of in numbers.
	 * i.e. for {1, 5, 9, 55} -> + 1 - 5 + 9 - 55
	 * @param intArray
	 * 		array with positive int-numbers to calculate
	 * @return
	 * 		plus-minus sum of array
	 */
	public static int CalculatePlusMinusSum(int[] intArray)
	{
		if (null == intArray) {
			return 0;
		}
		int result = 0;

		for (int i = 0; i < intArray.length; i++) {
			// + - + - ...
			int sign = (0 == i%2) ? 1 : -1;
			result += sign * intArray[i];
		}

		return result;
	}


	/**
	 * @throws IOException 
	 */
	public static void main(String args[]) throws IOException {

		String buf = null;
		int number = 0;
		
		System.out.print("Enter a positive number number greater then zero: ");
		
		BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
		buf = bufferRead.readLine();
		
		try { // convert to Number
			number = Integer.parseInt(buf);
	
			if (number <= 0 ) {
				throw new NumberFormatException("Your number is bad. Try again!");
			}
		} catch(NumberFormatException nfe){
			System.err.println(nfe.getMessage());
			System.err.println("Oops! Please, try again :)");
			System.exit(-1);
		}

//		Int2Array(number);
		
		
	}
}
