/*
 LeetCode Problem 7
 * 7. Reverse Integer
Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

Example 1:
Input: x = 123
Output: 321
Example 2:

Input: x = -123
Output: -321
Example 3:

Input: x = 120
Output: 21
 */

package Basic_Maths;

import java.util.Scanner;

public class Reverse_Integer {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    System.out.println(reverse(n));

  }

  public static int reverse(int x) {
    int revNum = 0;
    while (x != 0) {
      int lastDigit = x % 10;
      // Check for positive overflow
      if (revNum > Integer.MAX_VALUE / 10 || (revNum == Integer.MAX_VALUE / 10 && lastDigit > 7)) {
        return 0;
      }

      // Check for negative overflow
      if (revNum < Integer.MIN_VALUE / 10 || (revNum == Integer.MIN_VALUE / 10 && lastDigit < -8)) {
        return 0;
      }
      revNum = (revNum * 10) + lastDigit;
      x = x / 10;

    }
    return revNum;
  }
}
