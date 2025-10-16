/*
 * Given a number n, the task is to return the count of digits in this number.

Example:

Input: n = 1567
Output: 4
Explanation: There are 4 digits in 1567, which are 1, 5, 6 and 7.

Input: n = 255
Output: 3
Explanation: There are 3 digits in 256, which are 2, 5 and 5.
 */
package Basic_Maths;

import java.util.Scanner;

public class Count_Digits {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    System.out.println(countDigits(n));
  }

  public static int countDigits(int n) {
    // Regular approach to count digits
    /*
     * int count = 0;
     * while (n != 0) {
     * n = n / 10;
     * count++;
     * }
     * return count;
     */
    // Using logarithm to count digits
    int count = (int) (Math.log10(n) + 1);
    return count;
  }

}
