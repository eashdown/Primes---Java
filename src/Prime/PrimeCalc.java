package Prime;
import java.util.ArrayList;

/*
 * Project: Primes
 * File: PrimeCalc.java
 * Author: eashdown
 * Date: 6/5/2020
 * This class does calculations on a number, such as:
 * 			check if a number is a prime
 * 			find all primes up to a number
 * 			Euler's phi function
 * 			the gcd of two numbers
 * 			check if two numbers are comprime
 */
public class PrimeCalc {

	/* 
	 * This function finds all the primes up to a number (does not include 1)
	 * Input: int num - the num to find all primes up to
	 * 		valid input: n > 0
	 * Output: ArrayList<Integer> toReturn - an array list of ints with all
	 * 	the primes less than num (the input)
	 */
	public static ArrayList<Integer> allPrimes (int num) {
		ArrayList<Integer> toReturn = new ArrayList<Integer>();
		//if num = 1
		if(num == 1) {
			//1 is not prime so return an empty ArrayList
			return toReturn;
		}
		if( num <= 0) {
			System.out.println("allPrimes was given a negative number");
			return toReturn;
		}
		toReturn.add(2);
		//for 3 to num
		for(int i = 3; i <= num; i++ ) {
			//for 1 to the square root of i
			int sqrtI = (int) Math.sqrt(i);
			//for all primes found so far 
			//check if i is divisible by a prime
			for (int j = 0; j < toReturn.size(); j++) {
				int currPrime = toReturn.get(j);
				//if currPrime > square root of i
				if(currPrime > sqrtI) {
					//i is prime b/c no divisor found < sqrtI
					toReturn.add(i);
					break;
				}
				//if currPrime divides i 
				else if(i%currPrime == 0) {
					//i is not prime
					break;
				}
			}
		}
		return toReturn;
	}
	/*
	 * This function checks if a given number is prime
	 * Input: int toCheck - the number to check if prime
	 * Output: Boolean isPrime
	 * 			True if toCheck is a prime
	 * 			False if toCheck is NOT a prime
	 */
	public static Boolean isPrime(int toCheck) {
		//check if toCheck <= 1
		if(toCheck <= 1) {
			//not prime
			return false;
		}
		//check if toCheck is 2
		if(toCheck == 2) {
			//two is prime
			return true;
		}
		int sqrt = (int) Math.sqrt(toCheck);
		//get all primes up to the square root of toCheck
		ArrayList<Integer> thePrimes = allPrimes(sqrt);
		//for all primes found
		for(int i = 0; i < thePrimes.size(); i++) {
			int currPrime = thePrimes.get(i);
			//if toCheck is divisable by currPrime
			if (toCheck % currPrime == 0) {
				//toCheck is not prime
				return false;
			}
		}
		//no divisors found => true, toCheck is prime
		return true;
	}
	
	/*
	 * This recursive function finds the greatest common divisor (gcd) of
	 * 	two positive ints
	 * Input: int a & int b the two ints to find the gcd of
	 * Output:
	 * 		0 if a or b is 0
	 * 		-1 if a or b is < 0
	 * 		otherwise the gcd of a and b
	 */
	public static int gcd( int a, int b) {
		//bad input: negative
		if( a < 0 || b < 0) {
			return -1;
		}
		//bad input: 0
		if (a == 0 || b == 0) {
			return 0;
		}
		//base case: a == b or a|b 
		if(a == b ) {
			//the gcd is a 
			return a;
		}
		//inductive step
		if( a > b ) {
			return gcd(a-b,b);
		}
		//otherwise: b > a
		return gcd(a,b-a);
	}
	/*
	 * This function checks if two numbers are co-prime
	 * Input: int a & int b - the numbers to check if coprime
	 * Output: Boolean isCoprime
	 * 			True if a & b are co-prime
	 * 			False if a & b are NOT co-prime
	 */
	public static Boolean isCoprime(int a, int b){
		int theGCD = gcd(a,b);
		//if the gcd = 1 a and b are co-prime
		return (theGCD == 1);
	}
	
	/*
	 * This function finds Euler's Phi (the number of numbers co-prime to
	 * 	a number) of a number given
	 * Input: int num - the number to find Euler's phi of
	 * Output: int toReturn - the number of numbers co-prime to num
	 */
	public static int eulersPhi(int num) {
		//if num is <= 0
		if(num <= 0) {
			//invalid input
			return -1;
		}
		//if num is 1
		if(num == 1) {
			//by definition this is 1
			return 1;
		}
		int toReturn = 0;
		//from 1 to num 
		for(int i = 1; i < num; i++) {
			if(isCoprime(i, num) == true) {
				//if i is co-prime to num add one to the # of numbers 
					//co-prime to num
				toReturn ++;
			}
		}
		return toReturn;
	}
	
}
