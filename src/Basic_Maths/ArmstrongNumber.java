/*
 * You are given a 3-digit number n, Find whether it is an Armstrong number or not.

An Armstrong number of three digits is a number such that the sum of the cubes
 of its digits is equal to the number itself. 371 is an Armstrong number
  since 33 + 73 + 13 = 371. 
 */

package Basic_Maths;

public class ArmstrongNumber {
  public static void main(String[] args) {
    int n = 153;
    System.out.println(armstrongNumber(n));

  }

  static boolean armstrongNumber(int n) {
    // code here
    int countOfDigits = (int) Math.log10(n) + 1;
    int sum = 0;
    int originalNumber = n;
    while (n > 0) {
      int lastDigit = n % 10;
      sum = sum + (int) Math.pow(lastDigit, countOfDigits);
      n = n / 10;
    }
    if (sum == originalNumber) {
      return true;
    } else {
      return false;
    }

  }
}
