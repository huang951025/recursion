/**
 * Class: CIS211 Data Structures
 * Author: Wei Wen Huang
 * Date: 11/25/2019
 * Describe: write four method factoria , fibonacci, isPalindrome, and binarySearch, and two version recursive and no recursive.
 */

import java.math.BigInteger;

public class recursion {

	public static void main(String[] args) {
		
		testFactorial();
		testnFactorial();
		testfibonacci();
		testnfibonacci();
		testisPalindrome();
		testnisPalindrome();
		testrecursiveBinarySearch();
		testnBinarySearch();

	}// end main method

	public static BigInteger factorial(int n) {

		if (n == 1) {
			return BigInteger.valueOf(1);
		} // end if

		return factorial(n - 1).multiply(BigInteger.valueOf(n));
	}// end recursion factorial

	public static BigInteger nfactorial(int n) {

		long startTime = System.nanoTime(); // get star time
		BigInteger result = new BigInteger("1");

		// check is number negative
		if (n <= 0) {
			System.out.println("number can not be nagetive");
		} else if (n == 1) {
			return BigInteger.ONE;
		} else {
			// find the factorial
			for (int i = 1; i <= n; i++)
				result = result.multiply(new BigInteger(i + ""));
		} // end if else

		long endTime = System.nanoTime(); // get end time
		long spendtime = endTime - startTime;// get spend time
		System.out.println(spendtime + "ns");

		return result;
	}// end no recursion factorial

	public static long fibonacci(int n) {

		// check is n = 0 or 1
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		} else if (n == 2) {
			return 1;
		} else {
			return fibonacci(n - 1) + fibonacci(n - 2);
		} // end if else
	}// end method

	public static long nfibonacci(int n) {
			
		// check is n = 0 or 1
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		} else {

			int number1 = 0;// last number
			int number2 = 1;// last two number
			// for loop to find
			for (int i = 2; i <= n; i++) {
				number2 += number1;
				number1 = number2 - number1;
			} // end for loop
			return number2;
		} // end if else loop
		
	}// end method

//recursive ispalindrome
	public static class RecursivePalindrome {
		public static boolean isPalindrome(String s) {
			return isPalindrome(s, 0, s.length() - 1);
		}

		public static boolean isPalindrome(String s, int low, int high) {

			if (high <= low) {
				return true;
			} // end if
			else if (s.charAt(low) != s.charAt(high)) {
				return false;
			} else {
				return isPalindrome(s, low + 1, high - 1);
			} // keep check is each world match
		}// end if else
	}

//no recursive isPalindrome
public static boolean nisPalindrome(String s) {

			char[] charArr = s.toCharArray();
			for (int i = 0; i < s.length() / 2; i++) {

				if (charArr[i] != charArr[s.length() - 1 - i]) {
					return false;
				} // end if
			} // end for loop
			return true;

		}// end method
	

//Recursive Binary Binary Search
	public static class RecursiveBinarySearch {

		public static int recursiveBinarySearch(int[] list, int key) {

			int low = 0;
			int high = list.length - 1;
			return recursiveBinarySearch(list, key, low, high);
		}// end

		public static int recursiveBinarySearch(int[] list, int key, int low, int high) {

			if (low > high) {
				return -1;
			}

			int mid = (low + high) / 2;
			if (key < list[mid]) {
				return recursiveBinarySearch(list, key, low, mid - 1); // search in half
			} else if (key == list[mid]) {
				return mid;// found
			} else {
				return recursiveBinarySearch(list, key, mid + 1, high);// search in other half
			} // end if else loop
		} // end method recursiveBinarySearch

	}// end class

	public static int nBinarySearch(int[] list, int key) {
		int low = 0;
		int high = list.length - 1;

		// use while loop to found
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (list[mid] > key) {
				high = mid - 1;
			} else if (list[mid] < key) {
				low = mid + 1;
			} else {
				return mid; // found
			}
		} // end while loop
		return -1; // didn't found
	}// end method
	
	public static void testFactorial(){
		System.out.println("star test recursive Factorial");
		int n = 2;
		//run 20 times
		for(int i = 1; i <= 20; i++) {
		
		long startTime = System.nanoTime(); // get star time
		System.out.println(n + "! is " + factorial(n));	
		long endTime = System.nanoTime(); // get end time
		long spendtime = endTime - startTime;// get spend time
		System.out.println(spendtime + "ns");
		n = n + 2;
		}
		System.out.println("Test recursive Factorial is finish");
	}// end testFactorial
	
	public static void testnFactorial(){
		System.out.println("star test no recursive Factorial");
		int n = 2;
		//run 20 times
		for(int i = 1; i <= 20; i++) {
		System.out.println(n + "! is " + nfactorial(n));	
		n = n + 2;
		}
		System.out.println("Test no recursive Factorial is finish");
	}// end testnFactorial
	
	public static void testfibonacci(){
		System.out.println("star test recursive fibonacci");
		int n = 2;
		//run 20 times
		for(int i = 1; i <= 20; i++) {
			long startTime = System.nanoTime(); // get star time
			System.out.println(n + "nd fibonacci is " + fibonacci(n));
			long endTime = System.nanoTime(); // get end time
			long spendtime = endTime - startTime;// get spend time
			System.out.println(spendtime + "ns");
		n = n + 2;
		}
		
		System.out.println("Test recursive fibonacci is finish");
	}// end testFibonacci
	
	public static void testnfibonacci(){
		System.out.println("star test  no recursive fibonacci");
		int n = 2;
		//run 20 times
		for(int i = 1; i <= 20; i++) {
		long startTime = System.nanoTime(); // get star time
		System.out.println(n + "nd fibonacci is " + nfibonacci(n));	
		long endTime = System.nanoTime(); // get end time
		long spendtime = endTime - startTime;// get spend time
		System.out.println(spendtime + "ns");
		n = n + 2;
		}
		
		System.out.println("Test no recursive fibonacci is finish");
	}// end testnFibonacci
	
	public static void testisPalindrome() {
		long startTime = System.nanoTime(); // get star time
		System.out.println("1 Is asdfghjklsslkjhgfdsa a palindrome? " + RecursivePalindrome.isPalindrome("asdfghjklsslkjhgfdsa"));
		long endTime = System.nanoTime(); // get end time
		long spendtime = endTime - startTime;// get spend time
		System.out.println(spendtime + "ns");
		
		startTime = System.nanoTime(); // get star time
		System.out.println("2 Is qwertyuioppoiuytrewq a palindrome? " + RecursivePalindrome.isPalindrome("qwertyuioppoiuytrewq"));
		endTime = System.nanoTime(); // get end time
		spendtime = endTime - startTime;// get spend time
		System.out.println(spendtime + "ns");
		
		startTime = System.nanoTime(); // get star time
		System.out.println("3 Is qazxswedcvvcdewsxzaq a palindrome? " + RecursivePalindrome.isPalindrome("qazxswedcvvcdewsxzaq"));
		endTime = System.nanoTime(); // get end time
		spendtime = endTime - startTime;// get spend time
		System.out.println(spendtime + "ns");
		
		startTime = System.nanoTime(); // get star time	
		System.out.println("4 Is buubsaaaaaaaaaasbuqb a palindrome? " + RecursivePalindrome.isPalindrome("buubsaaaaaaaaaasbuqb"));
		endTime = System.nanoTime(); // get end time
		spendtime = endTime - startTime;// get spend time
		System.out.println(spendtime + "ns");
		
		startTime = System.nanoTime(); // get star time
		System.out.println("5 Is qazxcdertggtredcxzaq a palindrome? " + RecursivePalindrome.isPalindrome("qazxcdertggtredcxzaq"));
		endTime = System.nanoTime(); // get end time
		spendtime = endTime - startTime;// get spend time
		System.out.println(spendtime + "ns");
		
		startTime = System.nanoTime(); // get star time
		System.out.println("6 Is poiuytrewqqwertyuiop a palindrome? " + RecursivePalindrome.isPalindrome("poiuytrewqqwertyuiop"));
		endTime = System.nanoTime(); // get end time
		spendtime = endTime - startTime;// get spend time
		System.out.println(spendtime + "ns");
		
		startTime = System.nanoTime(); // get star time
		System.out.println("7 Is poiuytgbgttgbgtyuiop a palindrome? " + RecursivePalindrome.isPalindrome("poiuytgbgttgbgtyuiop"));
		endTime = System.nanoTime(); // get end time
		spendtime = endTime - startTime;// get spend time
		System.out.println(spendtime + "ns");
		
		startTime = System.nanoTime(); // get star time
		System.out.println("8 Is zxcvbnmklpplkmnbvcxz a palindrome? " + RecursivePalindrome.isPalindrome("zxcvbnmklpplkmnbvcxz"));
		endTime = System.nanoTime(); // get end time
		spendtime = endTime - startTime;// get spend time
		System.out.println(spendtime + "ns");
		
		startTime = System.nanoTime(); // get star time
		System.out.println("9 Is asikjuhdyehdsdfewrer a palindrome? " + RecursivePalindrome.isPalindrome("asikjuhdyehdsdfewrer"));
		endTime = System.nanoTime(); // get end time
		spendtime = endTime - startTime;// get spend time
		System.out.println(spendtime + "ns");
		
		startTime = System.nanoTime(); // get star time
		System.out.println("10 Is okmnhyujhgftyuhjiuyh a palindrome? " + RecursivePalindrome.isPalindrome("okmnhyujhgftyuhjiuyh"));
		endTime = System.nanoTime(); // get end time
		spendtime = endTime - startTime;// get spend time
		System.out.println(spendtime + "ns");
		
		startTime = System.nanoTime(); // get star time
		System.out.println("11 Is qazxcvbnmkkmnbvcxzaq a palindrome? " + RecursivePalindrome.isPalindrome("qazxcvbnmkkmnbvcxzaq"));
		endTime = System.nanoTime(); // get end time
		spendtime = endTime - startTime;// get spend time
		System.out.println(spendtime + "ns");
		
		startTime = System.nanoTime(); // get star time
		System.out.println("12 Is 12345678900987654321 a palindrome? " + RecursivePalindrome.isPalindrome("12345678900987654321"));
		endTime = System.nanoTime(); // get end time
		spendtime = endTime - startTime;// get spend time
		System.out.println(spendtime + "ns");
		
		startTime = System.nanoTime(); // get star time
		System.out.println("13 Is aassddffggggffddssaa a palindrome? " + RecursivePalindrome.isPalindrome("aassddffggggffddssaa"));
		endTime = System.nanoTime(); // get end time
		spendtime = endTime - startTime;// get spend time
		System.out.println(spendtime + "ns");
		
		startTime = System.nanoTime(); // get star time
		System.out.println("14 Is qqwweeddccccddeewwqq a palindrome? " + RecursivePalindrome.isPalindrome("qqwweeddccccddeewwqq"));
		endTime = System.nanoTime(); // get end time
		spendtime = endTime - startTime;// get spend time
		System.out.println(spendtime + "ns");
		
		startTime = System.nanoTime(); // get star time
		System.out.println("15 Is ookkmmnnbbbbnnmmkkoo a palindrome? " + RecursivePalindrome.isPalindrome("ookkmmnnbbbbnnmmkkoo"));
		endTime = System.nanoTime(); // get end time
		spendtime = endTime - startTime;// get spend time
		System.out.println(spendtime + "ns");
		
		System.out.println("Test recursive Palindrome is finish");
		
		
	}// end testisPalindrome
	
	public static void testnisPalindrome() {
		
		long startTime = System.nanoTime(); // get star time
		System.out.println("1 Is asdfghjklsslkjhgfdsa a palindrome? " + nisPalindrome("asdfghjklsslkjhgfdsa"));
		long endTime = System.nanoTime(); // get end time
		long spendtime = endTime - startTime;// get spend time
		System.out.println(spendtime + "ns");
		
		startTime = System.nanoTime(); // get star time
		System.out.println("2 Is qwertyuioppoiuytrewq a palindrome? " + nisPalindrome("qwertyuioppoiuytrewq"));
		endTime = System.nanoTime(); // get end time
		spendtime = endTime - startTime;// get spend time
		System.out.println(spendtime + "ns");
		
		startTime = System.nanoTime(); // get star time
		System.out.println("3 Is qazxswedcvvcdewsxzaq a palindrome? " + nisPalindrome("qazxswedcvvcdewsxzaq"));
		endTime = System.nanoTime(); // get end time
		spendtime = endTime - startTime;// get spend time
		System.out.println(spendtime + "ns");
		
		startTime = System.nanoTime(); // get star time	
		System.out.println("4 Is buubsaaaaaaaaaasbuqb a palindrome? " +  nisPalindrome("buubsaaaaaaaaaasbuqb"));
		endTime = System.nanoTime(); // get end time
		spendtime = endTime - startTime;// get spend time
		System.out.println(spendtime + "ns");
		
		startTime = System.nanoTime(); // get star time
		System.out.println("5 Is qazxcdertggtredcxzaq a palindrome? " + nisPalindrome("qazxcdertggtredcxzaq"));
		endTime = System.nanoTime(); // get end time
		spendtime = endTime - startTime;// get spend time
		System.out.println(spendtime + "ns");
		
		startTime = System.nanoTime(); // get star time
		System.out.println("6 Is poiuytrewqqwertyuiop a palindrome? " + nisPalindrome("poiuytrewqqwertyuiop"));
		endTime = System.nanoTime(); // get end time
		spendtime = endTime - startTime;// get spend time
		System.out.println(spendtime + "ns");
		
		startTime = System.nanoTime(); // get star time
		System.out.println("7 Is poiuytgbgttgbgtyuiop a palindrome? " +  nisPalindrome("poiuytgbgttgbgtyuiop"));
		endTime = System.nanoTime(); // get end time
		spendtime = endTime - startTime;// get spend time
		System.out.println(spendtime + "ns");
		
		startTime = System.nanoTime(); // get star time
		System.out.println("8 Is zxcvbnmklpplkmnbvcxz a palindrome? " +  nisPalindrome("zxcvbnmklpplkmnbvcxz"));
		endTime = System.nanoTime(); // get end time
		spendtime = endTime - startTime;// get spend time
		System.out.println(spendtime + "ns");
		
		startTime = System.nanoTime(); // get star time
		System.out.println("9 Is asikjuhdyehdsdfewrer a palindrome? " +  nisPalindrome("asikjuhdyehdsdfewrer"));
		endTime = System.nanoTime(); // get end time
		spendtime = endTime - startTime;// get spend time
		System.out.println(spendtime + "ns");
		
		startTime = System.nanoTime(); // get star time
		System.out.println("10 Is okmnhyujhgftyuhjiuyh a palindrome? " + nisPalindrome("okmnhyujhgftyuhjiuyh"));
		endTime = System.nanoTime(); // get end time
		spendtime = endTime - startTime;// get spend time
		System.out.println(spendtime + "ns");
		
		startTime = System.nanoTime(); // get star time
		System.out.println("11 Is qazxcvbnmkkmnbvcxzaq a palindrome? " +  nisPalindrome("qazxcvbnmkkmnbvcxzaq"));
		endTime = System.nanoTime(); // get end time
		spendtime = endTime - startTime;// get spend time
		System.out.println(spendtime + "ns");
		
		startTime = System.nanoTime(); // get star time
		System.out.println("12 Is 12345678900987654321 a palindrome? " +  nisPalindrome("12345678900987654321"));
		endTime = System.nanoTime(); // get end time
		spendtime = endTime - startTime;// get spend time
		System.out.println(spendtime + "ns");
		
		startTime = System.nanoTime(); // get star time
		System.out.println("13 Is aassddffggggffddssaa a palindrome? " +  nisPalindrome("aassddffggggffddssaa"));
		endTime = System.nanoTime(); // get end time
		spendtime = endTime - startTime;// get spend time
		System.out.println(spendtime + "ns");
		
		startTime = System.nanoTime(); // get star time
		System.out.println("14 Is qqwweeddccccddeewwqq a palindrome? " +  nisPalindrome("qqwweeddccccddeewwqq"));
		endTime = System.nanoTime(); // get end time
		spendtime = endTime - startTime;// get spend time
		System.out.println(spendtime + "ns");
		
		startTime = System.nanoTime(); // get star time
		System.out.println("15 Is ookkmmnnbbbbnnmmkkoo a palindrome? " +  nisPalindrome("ookkmmnnbbbbnnmmkkoo"));
		endTime = System.nanoTime(); // get end time
		spendtime = endTime - startTime;// get spend time
		System.out.println(spendtime + "ns");
		
		System.out.println("Test recursive Palindrome is finish");
		
	}// end test
	
	public static void testrecursiveBinarySearch() {
		int n =3;
		int[] list = new int[1000];
		for(int i = 0; i <= 999; i++){
			list[i] = n;
			n = n + 3;
		} //set up array
		
		//test
		long startTime = System.nanoTime(); // get star time
		System.out.println("the key in position(-1 mean not found): " + RecursiveBinarySearch.recursiveBinarySearch(list, 6));
		long endTime = System.nanoTime(); // get end time
		long spendtime = endTime - startTime;// get spend time
		System.out.println(spendtime + "ns");
		
		startTime = System.nanoTime(); // get star time
		System.out.println("the key in position(-1 mean not found): " + RecursiveBinarySearch.recursiveBinarySearch(list, 90));
		endTime = System.nanoTime(); // get end time
		spendtime = endTime - startTime;// get spend time
		System.out.println(spendtime + "ns");
		
		startTime = System.nanoTime(); // get star time
		System.out.println("the key in position(-1 mean not found): " + RecursiveBinarySearch.recursiveBinarySearch(list, 666));
		endTime = System.nanoTime(); // get end time
		spendtime = endTime - startTime;// get spend time
		System.out.println(spendtime + "ns");
		
		startTime = System.nanoTime(); // get star time
		System.out.println("the key in position(-1 mean not found): " + RecursiveBinarySearch.recursiveBinarySearch(list, 963));
		endTime = System.nanoTime(); // get end time
		spendtime = endTime - startTime;// get spend time
		System.out.println(spendtime + "ns");
		
		startTime = System.nanoTime(); // get star time
		System.out.println("the key in position(-1 mean not found): " + RecursiveBinarySearch.recursiveBinarySearch(list, 1257));
		endTime = System.nanoTime(); // get end time
		spendtime = endTime - startTime;// get spend time
		System.out.println(spendtime + "ns");
		
		startTime = System.nanoTime(); // get star time
		System.out.println("the key in position(-1 mean not found): " + RecursiveBinarySearch.recursiveBinarySearch(list, 2913));
		endTime = System.nanoTime(); // get end time
		spendtime = endTime - startTime;// get spend time
		System.out.println(spendtime + "ns");
		System.out.println("Test is end, star test random number");
		
		// set up 20 ramdon number between 3~3000
		int[] randomList1 = new int[20];
		for(int i = 0; i <= 19; i++) {
			randomList1[i] = (int) (Math.random()*2999 + 1);
		}
		
		startTime = System.nanoTime(); // get star time
		System.out.println("the key in position(-1 mean not found): " + RecursiveBinarySearch.recursiveBinarySearch(randomList1, 6));
		endTime = System.nanoTime(); // get end time
		spendtime = endTime - startTime;// get spend time
		
		startTime = System.nanoTime(); // get star time
		System.out.println("the key in position(-1 mean not found): " + RecursiveBinarySearch.recursiveBinarySearch(randomList1, 90));
		endTime = System.nanoTime(); // get end time
		spendtime = endTime - startTime;// get spend time
		System.out.println(spendtime + "ns");
		
		startTime = System.nanoTime(); // get star time
		System.out.println("the key in position(-1 mean not found): " + RecursiveBinarySearch.recursiveBinarySearch(randomList1, 666));
		endTime = System.nanoTime(); // get end time
		spendtime = endTime - startTime;// get spend time
		System.out.println(spendtime + "ns");
		
		startTime = System.nanoTime(); // get star time
		System.out.println("the key in position(-1 mean not found): " + RecursiveBinarySearch.recursiveBinarySearch(randomList1, 963));
		endTime = System.nanoTime(); // get end time
		spendtime = endTime - startTime;// get spend time
		System.out.println(spendtime + "ns");
		
		startTime = System.nanoTime(); // get star time
		System.out.println("the key in position(-1 mean not found): " + RecursiveBinarySearch.recursiveBinarySearch(randomList1, 1257));
		endTime = System.nanoTime(); // get end time
		spendtime = endTime - startTime;// get spend time
		System.out.println(spendtime + "ns");
		
		startTime = System.nanoTime(); // get star time
		System.out.println("the key in position(-1 mean not found): " + RecursiveBinarySearch.recursiveBinarySearch(randomList1, 2913));
		endTime = System.nanoTime(); // get end time
		spendtime = endTime - startTime;// get spend time
		System.out.println(spendtime + "ns");
		System.out.println("random number test is end");
	}// end test
	
	public static void testnBinarySearch() {
		int n =3;
		int[] list = new int[1000];
		for(int i = 0; i <= 999; i++){
			list[i] = n;
			n = n + 3;
		} //set up array
		
		//test
		long startTime = System.nanoTime(); // get star time
		System.out.println("the key in position(-1 mean not found): " + RecursiveBinarySearch.recursiveBinarySearch(list, 6));
		long endTime = System.nanoTime(); // get end time
		long spendtime = endTime - startTime;// get spend time
		System.out.println(spendtime + "ns");
		
		startTime = System.nanoTime(); // get star time
		System.out.println("the key in position(-1 mean not found): " + RecursiveBinarySearch.recursiveBinarySearch(list, 90));
		endTime = System.nanoTime(); // get end time
		spendtime = endTime - startTime;// get spend time
		System.out.println(spendtime + "ns");
		
		startTime = System.nanoTime(); // get star time
		System.out.println("the key in position(-1 mean not found): " + RecursiveBinarySearch.recursiveBinarySearch(list, 666));
		endTime = System.nanoTime(); // get end time
		spendtime = endTime - startTime;// get spend time
		System.out.println(spendtime + "ns");
		
		startTime = System.nanoTime(); // get star time
		System.out.println("the key in position(-1 mean not found): " + RecursiveBinarySearch.recursiveBinarySearch(list, 963));
		endTime = System.nanoTime(); // get end time
		spendtime = endTime - startTime;// get spend time
		System.out.println(spendtime + "ns");
		
		startTime = System.nanoTime(); // get star time
		System.out.println("the key in position(-1 mean not found): " + RecursiveBinarySearch.recursiveBinarySearch(list, 1257));
		endTime = System.nanoTime(); // get end time
		spendtime = endTime - startTime;// get spend time
		System.out.println(spendtime + "ns");
		
		startTime = System.nanoTime(); // get star time
		System.out.println("the key in position(-1 mean not found): " + RecursiveBinarySearch.recursiveBinarySearch(list, 2913));
		endTime = System.nanoTime(); // get end time
		spendtime = endTime - startTime;// get spend time
		System.out.println(spendtime + "ns");
		System.out.println("Test is end, star test random number");
		
		// set up 20 ramdon number between 3~3000
		int[] randomList1 = new int[20];
		for(int i = 0; i <= 19; i++) {
			randomList1[i] = (int) (Math.random()*2999 + 1);
		}
		
		startTime = System.nanoTime(); // get star time
		System.out.println("the key in position(-1 mean not found): " + nBinarySearch(randomList1, 6));
		endTime = System.nanoTime(); // get end time
		spendtime = endTime - startTime;// get spend time
		
		startTime = System.nanoTime(); // get star time
		System.out.println("the key in position(-1 mean not found): " + nBinarySearch(randomList1, 90));
		endTime = System.nanoTime(); // get end time
		spendtime = endTime - startTime;// get spend time
		System.out.println(spendtime + "ns");
		
		startTime = System.nanoTime(); // get star time
		System.out.println("the key in position(-1 mean not found): " + nBinarySearch(randomList1, 666));
		endTime = System.nanoTime(); // get end time
		spendtime = endTime - startTime;// get spend time
		System.out.println(spendtime + "ns");
		
		startTime = System.nanoTime(); // get star time
		System.out.println("the key in position(-1 mean not found): " + nBinarySearch(randomList1, 963));
		endTime = System.nanoTime(); // get end time
		spendtime = endTime - startTime;// get spend time
		System.out.println(spendtime + "ns");
		
		startTime = System.nanoTime(); // get star time
		System.out.println("the key in position(-1 mean not found): " + nBinarySearch(randomList1, 1257));
		endTime = System.nanoTime(); // get end time
		spendtime = endTime - startTime;// get spend time
		System.out.println(spendtime + "ns");
		
		startTime = System.nanoTime(); // get star time
		System.out.println("the key in position(-1 mean not found): " + nBinarySearch(randomList1, 2913));
		endTime = System.nanoTime(); // get end time
		spendtime = endTime - startTime;// get spend time
		System.out.println(spendtime + "ns");
		System.out.println("random number test is end");
	}// end test
	
}// all end
