import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Euler254 {
	private static List<Integer> fact = calculateFactorialMap(new ArrayList<>(10));
	public static void main(String[] args) {
		//System.out.println(factorialMap);
		
//		int n = 150;
//		System.out.println("Summation g(i) where 1 <= i <= " + n + " = " + ans(n));
		
//		int n = 2378889;
//		int temp =  f(n);
//		System.out.println("f(" + n + ") = " + temp);
//		System.out.println("sf(" + n + ") = " +  s(temp));
//		
//		findSumList(72);
//		System.out.println(Integer.MAX_VALUE >> 5);
//		Set<String> l = findCombinations("54321", 14, " ");
//		List<String> n = new ArrayList<String>(l.size());
//		n.addAll(l);
//		List<String> m = findSortedCombinations("21345");
//		System.out.println("Size of map:" + combinationMap.size());
//		System.out.println(m.equals(n));
//		System.out.println(combinationMap);
		//System.out.println(findSortedCombinations("Jossy"));
//		for(int i = 1000; i < 1100; i++) {
//			System.out.print("For " + i);
//			int size = 200;
//				BigInteger digits = findLowestSumToI(i, size);
//				if(digits == null)
//					continue;
//				else {
//					System.out.println(": " + digits);
//				}
//			
//		}
		
		//find lowest number to add to I
//		for(int i = 100; i < 200; i++) {
//			System.out.print("For " + i);
//			
//			for(int size = 1; size < 200; size++) {//clearly the sizes are incremental
//				BigInteger digits = findLowestSumToI(i, size);
//				if(digits == null)
//					continue;
//				else {
//					System.out.println(": " + digits);
//					break;
//				}
//			}
//		}
		
		//find lowest number to add to I - II
//		for(int i = 100; i < 200; i++) {
//			System.out.print("For " + i);
//			BigInteger digits = findLowestSumToI(i);
//			System.out.println(": " + digits);
//		}
//		
		
//		for(int i = 1; i < 10000; i++) {
//			System.out.print("sf(x) = sf(" + i + ") = s(");
//			int f = f(i);
//			System.out.print(") = s(" + f + ") = " + s(f));
//			System.out.println();
//		}
//		System.out.println(s(f(999999997)));
//		BigInteger [] ans = findLowestFactorialSumToN(new BigInteger("69999999999999"));
//		System.out.println(Arrays.toString(ans));
//		System.out.println(s(ans));
		
		System.out.println(ansNew(150));
		//test(150);
	}
	
	private static void test(long n) {
		for (long i = 1; i <= n; i++) {
			BigInteger [] temp = gNew(i);
			if(s(f(temp)) != i) {
				System.out.println("Error for " + i + ": " + Arrays.toString(temp));
			}
		}
	}


	private static BigInteger [] findLowestFactorialSumToN(BigInteger N){
		BigInteger [] noOfDigits = new BigInteger[10];
		BigInteger digits = BigInteger.ZERO;
		BigInteger place = BigInteger.ONE;
		for(int digit = 9; digit > 0; digit--) {
			if(N.equals(BigInteger.ZERO)) {
				break;
			}
			noOfDigits[digit] = N.divide(BigInteger.valueOf(fact.get(digit)));
			N = N.remainder(BigInteger.valueOf(fact.get(digit)));
			
			//adding the digits
//			for(BigInteger i = BigInteger.ZERO; !(noOfDigits.subtract(i)).equals(BigInteger.ZERO); i = i.add(BigInteger.ONE)) {
//				digits = digits.add(place.multiply(BigInteger.valueOf(digit)));
//				place = place.multiply(BigInteger.TEN);
//			}
		}

		return noOfDigits;
		
	}
	
	private static BigInteger findLowestSumToI(long x) {
		long noOf9s = x / 9;
		long rem = x % 9;
		
		BigInteger digits = BigInteger.ZERO;
		BigInteger place = BigInteger.ONE;
		int j = 0;
		for (; j < noOf9s; j++){
			digits = digits.add(place.multiply(BigInteger.valueOf(9)));
			place = place.multiply(BigInteger.TEN);
		}
		
		if (rem > 0) {
			digits = digits.add(place.multiply(BigInteger.valueOf(rem)));
		}
		
		return digits;
	}
	
	private static BigInteger findLowestSumToI(int i, int size){
		//0-9
		//can pad all lower with zeroes, should go only when lower ignored
		
		//find lowest
		int noOf9s = i / 9;
		int rem = i % 9;
		if (size < noOf9s || (size == noOf9s && rem > 0))
			return null;
		if (rem == 0 && size > noOf9s) {
			noOf9s--;
			rem = 9;
		}
		
		BigInteger digits = BigInteger.ZERO;
		BigInteger place = BigInteger.ONE;
		int j = 0;
		for (; j < noOf9s; j++){
			digits = digits.add(place.multiply(BigInteger.valueOf(9)));
			place = place.multiply(BigInteger.TEN);
		}
		//non 9s, padding
		int pad = size - noOf9s;
		while(pad > 0) {
			if(rem > pad) {
				int d = rem - pad + 1;
				//digits += d * place;
				digits = digits.add(place.multiply(BigInteger.valueOf(d)));
				rem -= d;
			}
			else if(rem == 1) {
				if(pad == 1) {
					digits = digits.add(place.multiply(BigInteger.ONE));
					rem--;
				}
			}
			else if(rem <= pad) {
				//digits += 1 * place;
				digits = digits.add(place.multiply(BigInteger.ONE));
				rem--;
			}
					
			//place *= 10;
			place = place.multiply(BigInteger.TEN);
			pad--;
		}
		
		return digits;
	}
	
	private static List<Integer> findSumList(int target) {
		List<Integer> li = new LinkedList<Integer>();
		for(int i = 0; i <= Integer.MAX_VALUE >> 2; i++) {
			if (s(i) == target) {
				li.add(i);
			}
		}
		System.out.print("All numbers that add to " + target + " are: ");
		System.out.println(li);
		return li;
	}

	public static long ans(long n) {
		long sum = 0;
		for (long i = 1; i <= n; i++) {
			int temp = s(g(i));
			sum += temp;
			//System.out.println("sg(" + i + ") = " + temp);
		}
		return sum;
	}
	
	public static BigInteger ansNew(long n) {
		BigInteger sum = BigInteger.ZERO;
		System.out.println("g(n) = [null, 1, 2, 3, 4, 5, 6, 7, 8, 9]");
		for (long i = 1; i <= n; i++) {
			BigInteger [] temp;
			System.out.println("g(" + i + ") = " + Arrays.toString(temp = gNew(i)));
			sum = sum.add(s(temp));
		}
		return sum;
	}
	
	private static BigInteger [] gNew(long x) {
		BigInteger fSumTarget = findLowestSumToI(x);
		return findLowestFactorialSumToN(fSumTarget);
	}
	
	//target sum
	private static int g(long x) {
		for(int i = 0; i <= Integer.MAX_VALUE; i++) {
			//System.out.print(i);
			if(s(f(i)) == x) {
				System.out.println("g(" + x + ") = " + i);
				return i;
			}
		}
		System.out.println("g(" + x + ") = " + -1);
		return -1;
	}

	/**
	 * Factorial sum
	 * @param x
	 * @return
	 */
	private static int f(long x) {
		int sum = 0;
		String out = "";
		for (int i = 10; x != 0;) {
			int mod = (int) (x % i);
			x = (x - mod) / i;
			int result = fact.get(mod);
			sum += result;
			out = result + "+" + out;
		}
		System.out.print(out);
		return sum;
	}
	
	private static BigInteger f(BigInteger[] x) {
		BigInteger sum = BigInteger.ZERO;
		for (int i = 0; i < x.length; i++) {
			if (x[i] == null)
				continue;
			sum = sum.add(x[i].multiply(BigInteger.valueOf(fact.get(i))));
		}
		return sum;
	}
	
	private static int s(int x) {
		int sum = 0;
		for (int i = 10; x != 0;) {
			int mod = x % i;
			x = (x - mod) / i;
			sum += mod;
			
		}
		return sum;
	}
	
	private static long s(BigInteger x) {
		long sum = 0;
		for (BigInteger i = BigInteger.TEN; !x.equals(BigInteger.ZERO);) {
			BigInteger mod = x.remainder(i);
			x = (x.subtract(mod)).divide(i);
			sum += mod.longValue();
		}
		return sum;
	}
	
	private static BigInteger s(BigInteger [] x) {
		BigInteger sum = BigInteger.ZERO;
		for (int i = 0; i < x.length; i++) {
			if (x[i] == null)
				continue;
			sum = sum.add(x[i].multiply(BigInteger.valueOf(i)));
		}
		return sum;
	}
	
	private static List<Integer> calculateFactorialMap(List<Integer> fList){
		int product = 1;
		fList.add(product);
		fList.add(product);
		
		for(int i = 2; i <= 9; i++) {
			product *= i;
			fList.add(product);
		}
		return fList;
	}

	private static List<String> findSortedCombinations(String x){
			Set<String> l = findCombinations(x);
			List<String> m = new ArrayList<String>(l.size());
			m.addAll(l);
			Collections.sort(m);
			//System.out.println(m);
			//System.out.println(n);
			
	//		List<Integer> intList = new ArrayList<Integer>(l.size());
	//		for(String s : m)
	//			intList.add(Integer.valueOf(s));
			return m;
		}
	
	private static Set<String> findCombinations(String x){
		//defaults
		return findCombinations(x, x.length(), " ");
	}

	private static Map<String, Set<String>> combinationMap = new HashMap<String, Set<String>>();
	private static Set<String> findCombinations(String s, int mapKeySizeThreshold, String callTreeSpace){
		//System.out.println(callTreeSpace + "Call() with: " + s);
		Set<String> cSet;
		if (combinationMap.containsKey(s)) {
			//System.out.println(callTreeSpace + " Duplicate!");
			return combinationMap.get(s);
		}
		else if (s.length() == 1) {
			cSet = Collections.singleton(s);
			//return cSet;
		}
		else {
			cSet = new TreeSet<String>();
			for (int i = 0; i < s.length(); i++) {
				Set<String> subCombinations = findCombinations(s.substring(0, i)
						+ s.substring(i + 1), mapKeySizeThreshold, callTreeSpace + " ");
				for(String t : subCombinations) {
					cSet.add(s.charAt(i) + t);
				}
			}
		}
		if(s.length() <= mapKeySizeThreshold)
			combinationMap.put(s, cSet);
		return cSet;
	}
}