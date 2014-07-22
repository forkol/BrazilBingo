package com.brazilbingo.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

public class PlayerCardGenerator {
	public static final int NUMROWS = 18;
	public static final int NUMCOLS = 9;

	int[][] numArr = new int[NUMROWS][NUMCOLS];
	Random random = new Random();

	LinkedList<Integer> listOfRndColNums(int from, int to) {
		// Populate an empty array list going from FROM to TO
		LinkedList<Integer> myColNumList = new LinkedList<Integer>();
		for (int i = from; i <= to; i++) {
			myColNumList.add(i);
		}

		// Shuffle it
		Collections.shuffle(myColNumList);

		// return it
		return myColNumList;
	}

	LinkedList<Integer> genPossibleColConfigs() {
		LinkedList<Integer> possOrderList = new LinkedList<Integer>();

		// We need a of numbers that always add up to 10. Since we can only use
		// 1 number
		// per column, or 2 numbers per column, the only way 6 numbers using
		// only 1 and 2
		// add up is by having 4 number 2's and 2 number 1's. Then it's just a
		// case of
		// returning a permutation of that list to get a random order.

		possOrderList.add(1);
		possOrderList.add(1);
		possOrderList.add(2);
		possOrderList.add(2);
		possOrderList.add(2);
		possOrderList.add(2);

		// Shuffle the list to return a random order for each column
		Collections.shuffle(possOrderList);

		return possOrderList;

	}

	public int[][] genFullCard() {

		for (int col = 0; col < NUMCOLS; col++) {

			// Generate list of numbers to put in colums
			LinkedList<Integer> rndColNumList = listOfRndColNums((col * 10),
					(col * 10) + 9);

			LinkedList<Integer> possColConfig = genPossibleColConfigs();

			for (int row = 0; row < NUMROWS; row += 3) {

				Integer possOrdNum = possColConfig.remove();

				// / If that number is 1
				if (possOrdNum == 1) {
					// select a random number between 0 and 2;
					int randRowNum = random.nextInt(3);

					// Get a number off the list of Random Col Numbers
					int rndColNum = rndColNumList.remove();

					numArr[row + randRowNum][col] = rndColNum;

				} else if (possOrdNum == 2) {
					// select a random number between 0 and 2;
					int randRowNum = random.nextInt(3);

					// Get a pair of number off the Random Columm Number
					// List
					int rndColNum = rndColNumList.remove();
					int rndColNum2 = rndColNumList.remove();

					switch (randRowNum) {
						case 0: // Fill in top two2 or bottom two locations
						case 1: {
							numArr[row + randRowNum][col] = rndColNum;
							numArr[row + randRowNum + 1][col] = rndColNum2;
							break;
						}
						case 2: // Fill in 1st and 3rd position
						{
							numArr[row][col] = rndColNum;
							numArr[row + 2][col] = rndColNum2;
							break;
						}
					}
				}

			}
		}

		return numArr;
	}

}
