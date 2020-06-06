package Prime;
import java.util.*;
public class Main {

	//The main function for the package where the user can interact w/the code
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Welcome! To get all prime numbers up to a number "
				+ "n, type 0.");
		System.out.println ("To check if a number is prime type 1.");
		System.out.println ("To to get the gcd of two numbers type 2.");
		System.out.println ("To check if two numbers are coprime, type 3.");
		System.out.println ("To calculate Euler's Phi function of a number type 4.");
		System.out.println ("To quit, type 5.");
		
		Boolean loop = true;
		while(loop) {
			System.out.println ("To get help, type 6.");
			int userIn = in.nextInt();
			switch (userIn) {
			case 0:
				System.out.println("Please type the number to find all prime"
						+ " numbers up to: ");
				int num = in.nextInt();
				ArrayList<Integer> thePrimes = Prime.PrimeCalc.allPrimes(num);
				System.out.println("Those primes are: ");
				for(int i = 0; i < thePrimes.size(); i ++) {
					System.out.println(thePrimes.get(i));
				}
				break;
			case 1:
				System.out.println("Please input the number you want to check: ");
				int numb = in.nextInt();
				Boolean ifPrime = Prime.PrimeCalc.isPrime(numb);
				if (ifPrime) {
					System.out.println("Yes, " + numb + " is a prime.");
				}
				else {
					System.out.println("No, " + numb + " is NOT a prime.");
				}
				break;
			case 2:
				System.out.println("Please input the two numbers you want"
						+ " to get the gcd of: ");
				int a = in.nextInt();
				int b = in.nextInt();
				int gcd = Prime.PrimeCalc.gcd(a, b);
				System.out.println("The gcd of " + a + " and " 
						+ b + " is " + gcd + ".");
				break;
			case 3:
				System.out.println("Please input the two numbers you want"
						+ " are coprime: ");
				int ac = in.nextInt();
				int bc = in.nextInt();
				Boolean ifCoprime = Prime.PrimeCalc.isCoprime(ac,bc);
				if (ifCoprime) {
					System.out.println("Yes, " + ac +" and " + bc + " are coprime.");
				}
				else {
					System.out.println("No, "+ac +" and "+bc+ " are NOT coprime.");
				}
				break;
			case 4:
				System.out.println("Please input the numbers you want to find"
						+ " Euler's Phi function of: ");
				int n = in.nextInt();
				int euler = Prime.PrimeCalc.eulersPhi(n);
				System.out.println("Euler's Phi of " + n + " is " + euler +".");
				break;
			case 5:
				loop = false;
				System.out.println("Goodbye!");
				break;
			case 6:
				System.out.println("To get all prime numbers up to a number "
						+ "n, type 0.");
				System.out.println ("To check if a number is prime type 1.");
				System.out.println ("To to get the gcd of two numbers type 2.");
				System.out.println ("To check if two numbers are coprime, type 3.");
				System.out.println ("To calculate Euler's Phi function of a number type 4.");
				System.out.println ("To quit, type 5.");
				break;
			}
			
		}
		
		in.close();
	}

}
