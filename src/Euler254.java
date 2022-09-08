import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Euler254 {
	private static List<Integer> factorialMap = calculateFactorialMap(new ArrayList<>(10));
	public static void main(String[] args) {
		//System.out.println(factorialMap);
		
		//int n = 150;
		//System.out.println("Summation g(i) where 1 <= i <= " + n + " = " + ans(n));
		
//		int n = 2378889;
//		int temp =  f(n);
//		System.out.println("f(" + n + ") = " + temp);
//		System.out.println("sf(" + n + ") = " +  s(temp));
//		
//		findSumList(72);
//		System.out.println(Integer.MAX_VALUE >> 5);
		findCombinations("12225", 5, "   ");
		System.out.println("Size of map:" + combinationMap.size());
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
			place = place.multiply(BigInteger.valueOf(10));
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
			place = place.multiply(BigInteger.valueOf(10));
			pad--;
		}
		
		return digits;
	}
	
	private static List<String> findSortedCombinations(String x){
		Set<String> l = findCombinations(x, x.length() - 2, "");
		List<String> m = new ArrayList<String>(l.size());
		List<String> n = new ArrayList<String>(l.size());
		m.addAll(l);
		n.addAll(l);
		Collections.sort(m);
		//System.out.println(m);
		//System.out.println(n);
		System.out.println(m.equals(n));
//		List<Integer> intList = new ArrayList<Integer>(l.size());
//		for(String s : m)
//			intList.add(Integer.valueOf(s));
		return m;
	}
	
	public static long ans(long n) {
		long sum = 0;
		for (long i = 1; i <= n; i++) {
			int temp = s(g(i));
			sum += temp;
			System.out.println("sg(" + i + ") = " + temp);
		}
		return sum;
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
			int result = factorialMap.get(mod);
			sum += result;
			out += result + " + ";
		}
		//System.out.println(out + "= " + sum);
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

	private static Map<String, Set<String>> combinationMap = new HashMap<String, Set<String>>();
	private static Set<String> findCombinations(String s, int mapKeySizeThreshold, String callTreeSpace){
		System.out.println(callTreeSpace + "Call() with: " + s);
		Set<String> cSet;
		if (combinationMap.containsKey(s)) {
			System.out.println(callTreeSpace + "Successfully used duplicate");
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
						+ s.substring(i + 1), mapKeySizeThreshold, callTreeSpace + callTreeSpace);
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