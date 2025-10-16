/*
 * Given a number n, determine whether it is a prime number or not.
Note: A prime number is a number greater than 1 that has no positive divisors other than 1 and itself.

Examples :
Input: n = 7
Output: true
Explanation: 7 has exactly two divisors: 1 and 7, making it a prime number.
Input: n = 25
Output: false
Explanation: 25 has more than two divisors: 1, 5, and 25, so it is not a prime number.
Input: n = 1
Output: false
Explanation: 1 has only one divisor (1 itself), which is not sufficient for it to be considered prime.
Constraints:
1 ≤ n ≤ 109
 */

package Basic_Maths;

import java.util.Scanner;

public class PrimeNumber {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    System.out.println(isPrime(n));
  }

  static boolean isPrime(int n) {
    // code here
    if (n <= 1) {
      return false;
    }
    int count = 0;
    for (int i = 2; i <= Math.sqrt(n); i++) {
      if (n % i == 0) {
        count++;
      }
    }
    if (count >= 1) {
      return false;
    } else {
      return true;
    }
  }

}
