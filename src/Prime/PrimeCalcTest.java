package Prime;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;
import Prime.PrimeCalc;

class PrimeCalcTest {
	
	//Test isPrime
	@Test
	void testIsPrime() {
		assertEquals(Prime.PrimeCalc.isPrime(2), true );
		assertEquals(Prime.PrimeCalc.isPrime(1), false );
		assertEquals(Prime.PrimeCalc.isPrime(10), false );
		assertEquals(Prime.PrimeCalc.isPrime(101), true );
		assertEquals(Prime.PrimeCalc.isPrime(25), false );
		assertEquals(Prime.PrimeCalc.isPrime(-25), false );
		assertEquals(Prime.PrimeCalc.isPrime(0), false );
	}
	//Test allPrimes
	@Test
	void testAllPrimes()
	{
		ArrayList<Integer> empty = new ArrayList<Integer>();
		ArrayList<Integer> onTwo = new ArrayList<Integer>();
		onTwo.add(2);
		ArrayList<Integer> onHundred = new ArrayList<Integer>(
				Arrays.asList(2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,
						53,59,61,67,71,73,79,83,89,97));
		assertEquals(Prime.PrimeCalc.allPrimes(1), empty );
		assertEquals(Prime.PrimeCalc.allPrimes(0), empty );
		assertEquals(Prime.PrimeCalc.allPrimes(-100), empty );
		assertEquals(Prime.PrimeCalc.allPrimes(2), onTwo );
		assertEquals(Prime.PrimeCalc.allPrimes(100), onHundred );
	}
	//Test gcd
	@Test
	void testGCD() {
		assertEquals(Prime.PrimeCalc.gcd(1,0), 0 );
		assertEquals(Prime.PrimeCalc.gcd(0,0), 0 );
		assertEquals(Prime.PrimeCalc.gcd(0,3), 0 );
		assertEquals(Prime.PrimeCalc.gcd(1,-21), -1);
		assertEquals(Prime.PrimeCalc.gcd(10,2), 2 );
		assertEquals(Prime.PrimeCalc.gcd(18, 30), 6 );
		assertEquals(Prime.PrimeCalc.gcd(30, 18), 6 );
		assertEquals(Prime.PrimeCalc.gcd(2, 101), 1 );
		assertEquals(Prime.PrimeCalc.gcd(2, 2), 2 );
		assertEquals(Prime.PrimeCalc.gcd(1, 1), 1 );
	}
	//Test isCoprime
	@Test
	void testIsCoprime() {
		assertEquals(Prime.PrimeCalc.isCoprime(0,2), false );
		assertEquals(Prime.PrimeCalc.isCoprime(2,1), true );
		assertEquals(Prime.PrimeCalc.isCoprime(10,-20), false );
		assertEquals(Prime.PrimeCalc.isCoprime(2,2), false );
		assertEquals(Prime.PrimeCalc.isCoprime(4,2), false );
		assertEquals(Prime.PrimeCalc.isCoprime(2,4), false );
		assertEquals(Prime.PrimeCalc.isCoprime(101,4), true );
	}
	//Test 
	@Test
	void testEulersPhi() {
		assertEquals(Prime.PrimeCalc.eulersPhi(-100), -1 );
		assertEquals(Prime.PrimeCalc.eulersPhi(1), 1 );
		assertEquals(Prime.PrimeCalc.eulersPhi(2), 1 );
		assertEquals(Prime.PrimeCalc.eulersPhi(100), 40 );
		assertEquals(Prime.PrimeCalc.eulersPhi(17), 16 );
	}
}
