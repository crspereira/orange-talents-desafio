package zup.orangetalents.loterrychallenge.entities.util.test;

import java.util.Arrays;
import java.util.Random;

public class RandomLotteryNumbers {

	public static void main(String[] args) {
		Random rand = new Random();
		int min = 1, max = 50, slots = 6;
		
		//all elements are initialized to be zeros
		int[] lotteryArray = new int[slots];
		boolean isRepeated;
		int randomNumber = 0;
		
		// indexDrawn means it traces the index
		for (int indexDrawn = 0; indexDrawn < slots; indexDrawn++) {
			do {
				isRepeated = false;
				//avoid starting with zero, generating 1 to 50 numbers
				randomNumber = rand.nextInt(max + 1- min) + min;
				// check for repeated number against
				// the filled no-zero elements
				for (int k = 0; k <= indexDrawn; k++) {
					// check against each filled non-zero elements
					// hope that none repeats the random number
					if (lotteryArray[k] == randomNumber) {
						isRepeated = true;
						break;
					}
				}
			} while (isRepeated);
			lotteryArray[indexDrawn] = randomNumber;
		}
		
		Arrays.sort(lotteryArray);
		System.out.println("The result of the Lottery:");
		for (int i = 0; i < slots; i++) {
			System.out.print(lotteryArray[i] + " ");
		}
		System.out.println("");
		System.out.println("The result of the Lottery in String:");
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < slots; i++) {
			str.append(lotteryArray[i] + " ");
		}
		System.out.println(str.toString());
	}

}
