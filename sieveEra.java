/* Sieve of Eratosthenes written in java. Written on 10/1/2024. Took around 1 hour */

import java.util.Scanner;

public class sieveEra {

    //validate user input
    public static int validateInput(int input, Scanner scnr) {
        System.out.print("Enter a number between 3 and 160000: ");
        input = scnr.nextInt();
        while ((input < 3) || (input > 160000)) {
            System.out.println("Error, number is not between 3 and 160000.");
            System.out.print("enter a number between 3 and 160000: ");
            input = scnr.nextInt();
        }
        return input;
    }

    //set array to all 1's
    public static void setArray(boolean [] primeArr, int arrSize) {
        for (int i = 2; i < (arrSize + 1); i ++) {
            primeArr[i] = true;
        }
    }

    //find composites and set them
    public static void findAndSetComposites(boolean [] primeArr, int arrSize) {
        for (int divisor = 2; divisor < (arrSize / 2); divisor ++) {
            for (int i = 3; i < (arrSize + 1); i ++) {
                if ((i % divisor == 0) && (primeArr[i] == true) && (i != divisor)) {
                    primeArr[i] = false;
                }
            }
        }
    }

    //print primes
    public static void printPrimes(boolean [] primeArr, int arrSize) {
        int counter = 0;
        System.out.println("The primes are: ");
        for (int i = 2; i < (arrSize + 1); i ++) {
            if (primeArr[i] == true) {
                System.out.print(i + " ");
                counter ++;
            }
            if (counter == 10) {
                System.out.println();
                counter = 0;
            }
        }
    }

    public static void main(String[] args) {

        //get user input and validate
        Scanner scnr = new Scanner(System.in);
        int userInput = validateInput(0, scnr);

        //store user input in array
        boolean primeArr[] = new boolean[userInput + 1];
        setArray(primeArr, userInput);

        //find composites and set them
        findAndSetComposites(primeArr, userInput);

        //print primes
        printPrimes(primeArr, userInput);
    }
}