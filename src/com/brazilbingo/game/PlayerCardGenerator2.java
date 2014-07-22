package com.brazilbingo.game;


public class PlayerCardGenerator2 {
	public static final int NUMROWS = 3;
	public static final int NUMCOLS = 9;

	public static void main(String[] args)
	{
		
		System.out.println("PlayerCardGenerator2.main()"
						+ Integer.toBinaryString(511));
		
		char[] testArr = convertIntToCharArr(438);
		
		
		
		char[] chRow1, chRow2, chRow3;
		
		for(int row1=0; row1 <= 511; row1++)
		{
			chRow1 = convertIntToCharArr(row1);
			if (thisRowIsInvalid(chRow1))
			{
				continue;
			}
			
			for (int row2=0; row2 <= 511; row2++)
			{
				chRow2 = convertIntToCharArr(row2);
				if (thisRowIsInvalid(chRow2))
				{
					continue;
				}
				
				for(int row3=0; row3 <= 511; row3++)
				{
					
					chRow3 = convertIntToCharArr(row3);
					if (thisRowIsInvalid(chRow3))
					{
						continue;
					}
					
					
					if (checkIfValidByColumn(chRow1, chRow2, chRow3))
					{
						System.out.println(row1 + "  " + row2 + "   " + row3);
					}
									
				}
			}
		}
		//ckIfMoreThanFive(myCharArray);
		
		//checkIfMoreThanThreeInARow(myCharArray);
		
		
	}

	private static boolean checkIfMoreThanThreeInARow(char[] myCharArray) {
		// Check #2: Check to see if more than three in a row
		int cnt = 0;
		for(int i=0; i < NUMCOLS; i++)
		{
			if (myCharArray[i] == '0')			
			{
				cnt = 0;
			} 
			else if (myCharArray[i] == '1')
			{
				cnt++;
			}
			
			if (cnt > 3)
			{
				return true;
			}
		}
		
		return false;
	}

	private static boolean NotFiveSetInThisRow(char[] myCharArray) {
		// Check #1: is it more than 5 set in this line
		int cnt=0;
		for(int i=0; i < NUMCOLS; i++)
		{
			if (myCharArray[i] == '1')
			{
				cnt++;
			}
		}
		
		if (cnt == 5)
		{
			return true;
		}else {
			return false;
		}
	}
	
	private static boolean checkIfValidByColumn(char[] row1, char[] row2, char[] row3)
	{
		for (int i=0; i < NUMCOLS; i++)
		{
		
			int sum = Integer.valueOf("" + row1[i]) + Integer.valueOf("" + row2[i]) + Integer.valueOf("" + row3[i]);
			
			// We must have at 1 or two numbers per column.  If we have only 1 or 3, then the column is invalid
			if ( (sum == 0) || (sum == 3))
			{
				return false;
			}
		}
		
		return true;
		
	}
	
	private static char[] convertIntToCharArr(int anInt)
	
	{
		//System.out.println("PlayerCardGenerator2.main()"
		//		+ Integer.toBinaryString(test));

		String row1 = Integer.toBinaryString(anInt);

		StringBuffer aString = new StringBuffer("000000000");
		aString.replace(9 - row1.length(), 9, row1);

		// System.out.println("Output String: " + aString);

		// Convert to char array
		char[] myCharArray = new String(aString).toCharArray();
		
		return myCharArray;

	}
	
	private static boolean thisRowIsInvalid(char[] aCharArr)
	{
		return (checkIfMoreThanThreeInARow(aCharArr) && NotFiveSetInThisRow(aCharArr));
	}
}