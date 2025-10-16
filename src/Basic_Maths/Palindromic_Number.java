/*
 * 9.Leetcode
 *  Palindrome Number
Given an integer x, return true if x is a palindrome, and false otherwise.

 

Example 1:
Input: x = 121
Output: true
Explanation: 121 reads as 121 from left to right and from right to left.
Example 2:

Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
Example 3:

Input: x = 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 

Constraints:
-231 <= x <= 231 - 1
 */
package Basic_Maths;

import java.util.Scanner;

public class Palindromic_Number {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    System.out.println(isPalindrome(n));
  }

  public static boolean isPalindrome(int x) {
    int revNum = 0;
    int originalNumber = x;
    while (x > 0) {
      int lastDigit = x % 10;
      // Check for positive overflow

      revNum = (revNum * 10) + lastDigit;
      x = x / 10;
    }
    if (originalNumber == revNum) {
      return true;
    } else {
      return false;
    }

  }

}
