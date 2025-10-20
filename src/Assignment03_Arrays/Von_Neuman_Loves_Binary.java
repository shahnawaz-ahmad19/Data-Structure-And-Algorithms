/*
 * Given a binary number ,help Von Neuman to find out its decimal representation. For eg 000111 in binary is 7 in decimal.


Input Format
The first line contains N , the number of binary numbers.
 Next N lines contain N integers each representing binary represenation of number.


Constraints
N<=1000 Digits in binary representation is <=16.

Output Format
N lines,each containing a decimal equivalent of the binary number.

Sample Input
4
101
1111
00110
111111

Sample Output
5
15
6
63
Explanation
For binary number fedcba , Decimal number = f * 25 + e * 24 + d * 23 + …..+ a * 20.

Our Algorithm Idea:
==========================
=> Start a sum at 0.
=> Start a powerOfTwo variable at 1 (for the $2^0$ position).
=> Loop from the rightmost character of the string to the left.
=> For each character:
    If the character is a '1', add the current powerOfTwo to our sum.
    If the character is '0', add nothing.
    Multiply powerOfTwo by 2 to prepare for the next position (e.g., from 1 to 2, 2 to 4, 4 to 8...).
=> Return the final sum.

Q) Why We Still Prefer the String Solution?

Even though long works here, but by the String solution because it's a better and more professional habit. Here's why:

It's Fragile: The long solution only works because the constraint was 16 digits.
If the problem said "up to 20 digits," your long would fail just like the int did.
 The String solution would work fine for 20, 50, or 100 digits.

It's a "Trick": our manual long solution (and the int one) is a clever trick. 
It's not really treating the input as binary.
 It's treating it as a decimal number (e.g., "one hundred and one") 
 and using math (% 10) to pick the digits off. This just happens to
  work because the digits are only 1s and 0s.

It's Not "Correct": The String solution is semantically correct.
 It treats the input 101 as what it truly is: "a string of characters: 1, then 0, then 1." This is the right way to think about it.

The String solution is more robust (it won't break if the constraints change) and idiomatic (it's the standard "Java way" to handle this)

 */

package Assignment03_Arrays;

import java.util.Scanner;

public class Von_Neuman_Loves_Binary {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int numberOfBinaryNumbers = sc.nextInt();

    for (int i = 0; i < numberOfBinaryNumbers; i++) {
      // Read as a String
      String binaryString = sc.next();

      int decimalValue = binaryToDecimal(binaryString);
      System.out.println(decimalValue);
    }

  }

  public static int binaryToDecimal(String binaryString) {
    int sum = 0;
    int powerOfTwo = 1;

    // Loop from the LAST character (right) to the first (left)
    for (int i = binaryString.length() - 1; i >= 0; i--) {

      // Check if the character at this position is '1'
      if (binaryString.charAt(i) == '1') {
        sum = sum + powerOfTwo;
      }

      // Move to the next power of 2 (2, 4, 8, ...)
      powerOfTwo = powerOfTwo * 2;
    }

    return sum;
  }

}
