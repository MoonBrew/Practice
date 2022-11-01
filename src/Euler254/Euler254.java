package Euler254;

/**
 * Coding against an interface?
 * Trying to capture the spec/requirements
 * 
 * Expecting there to be multiple versions of these methods, gonna call them attempts
 * Some kind of time comparision will also be needed as the Euler version expects the solution to take under a minute
 * 
 * Everything is integer here even though I know I need to use Big integer eventually
 * Want to capture when it is needed
 * 
 * Referring https://projecteuler.net/problem=254.
 * The goal is to find ans(150)
 * For now ignoring the Hackerrank version's additional parameters/constraints
 * Hackerrank version: https://www.hackerrank.com/contests/projecteuler/challenges/euler254/problem
 * 
 * Felt like sum of digits could be a separate function, but no need to force it here.
 * This is possibly an implementation detail
 * 
 * @author Jossy George
 *
 */
public interface Euler254 {

	/**
	 * Define f(n) as the sum of the factorials of the digits of n.
	 * For example, f(342) = 3! + 4! + 2! = 32.
	 * 
	 * @param n
	 * @return sum of the factorials of the digits of n
	 */
	int f(int n);
	
	/**
	 * Define sf(n) as the sum of the digits of f(n).
	 * So sf(342) = 3 + 2 = 5.
	 * @param n
	 * @return sum of the digits of f(n)
	 */
	int sf(int n);
	
	/**
	 * Define g(i) to be the smallest positive integer n such that sf(n) = i.
	 * Though sf(342) is 5, sf(25) is also 5, and it can be verified that g(5) is 25.
	 * 
	 * @param i
	 * @return smallest positive integer n such that sf(n) = i
	 */
	int g(int i);
	
	/**
	 * Define sg(i) as the sum of the digits of g(i).
	 * So sg(5) = 2 + 5 = 7.
	 * 
	 * @param i
	 * @return sum of the digits of g(i)
	 */
	int sg(int i);
	
	/**
	 * The sum of all the sg(i) where 1 <= i <= n.
	 * When n is 20, ans(20) is 156
	 * 
	 * @author jossy
	 * @param n
	 * @return The sum of all the sg(i) where 1 <= i <= n
	 */
	int ans(int n);
}
