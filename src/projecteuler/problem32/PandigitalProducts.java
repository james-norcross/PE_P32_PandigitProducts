package projecteuler.problem32;

import java.util.ArrayList;
import java.util.Arrays;

public class PandigitalProducts {

	/**
	 * Author: James Norcross
	 * Date: 1/2/15
	 * Purpose: Solution of Project Euler problem 32
	 * Description: finds the sum of all unique pandigital products where the expression a*b=c contains each of the
	 * 				digits 1-9 exactly once
	 * 
	 * Note:  all possible candidates fall into one of two cases
	 * 		1) a one digit b 4 digits c 4 digits
	 * 		2) a two digits b 3 digits c 4 digits
	 * 
	 * Can limit loops by excluding multiplicand 1 (since that is obviously not going to return a pandigital result).  Can also
	 * limit based on requirements that multiplier/multiplicand cannot have repeated digits
	 */
	
	private static final char[] digit = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
	
	public static void main(String[] args) {
		
		ArrayList<Integer> products = new ArrayList<Integer>();
		int product;
		
		// consider case 1
		for (int i =2; i<10; i++)
		{
			for (int j=1234; j<9877; j++)
			{
				product = i*j;
				if(isPandigital(i, j, product))
					products.add(product);
			}
		}
		
		// consider case 2
		for (int i=12; i<99; i++)
		{
			for (int j=123; j<988; j++)
			{
				product = i*j;
				if(isPandigital(i,j,product))
					products.add(product);
			}
		}
		
		// find sum of unique products
		Integer[] productArray = new Integer[products.size()];
		productArray = products.toArray(productArray);
		Arrays.sort(productArray);
		
		int total = productArray[0];
		for(int i=1; i<productArray.length; i++)
		{
			if (!productArray[i].equals(productArray[i-1]))
			{
				total += productArray[i];
			}
		}
			
		System.out.println("The sum of unique pandigital products is " + total);
	}
	
	// tests whether the integers i,j,product have a total of 9 digits including all digits 1-9
	private static boolean isPandigital(int i, int j, int product)
	{
		String s = String.valueOf(i) + String.valueOf(j) + String.valueOf(product);
		
		return (s.length() == 9
				&& (s.indexOf(digit[0]) != -1)
				&& (s.indexOf(digit[1]) != -1)
				&& (s.indexOf(digit[2]) != -1)
				&& (s.indexOf(digit[3]) != -1)
				&& (s.indexOf(digit[4]) != -1)
				&& (s.indexOf(digit[5]) != -1)
				&& (s.indexOf(digit[6]) != -1)
				&& (s.indexOf(digit[7]) != -1)
				&& (s.indexOf(digit[8]) != -1));
	}

}
