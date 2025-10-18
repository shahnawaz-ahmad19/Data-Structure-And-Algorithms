/*
 * Kartik Bhaiya has a string consisting of only 'a' and 'b' as the characters. Kartik Bhaiya describes perfectness of a string as the maximum length substring of equal characters. Kartik Bhaiya is given a number k which denotes the maximum number of characters he can change. Find the maximum perfectness he can generate by changing no more than k characters.

Input format
The first line contains an integer denoting the value of K.
The next line contains a string having only ‘a’ and ‘b’ as the characters.

Output format
A single integer denoting the maximum perfectness achievable.

Example 1
Input
2
abba

Output
4
Explanation
We can swap the a's to b using the 2 swaps and obtain the string "bbbb". This would have all the b's and hence the answer 4. 

Alternatively, we can also swap the b's to make "aaaa". The final answer remains the same for both cases.


Constraints
2 ≤ N ≤ 10^6
 */

package Lecture20;

import java.util.Scanner;

public class Kartik_Bhaiya_String {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int k = sc.nextInt();
    String s = sc.next();
    int flip_A = maxPerfectness(s, 'a', k);
    int flip_B = maxPerfectness(s, 'b', k);
    System.out.println(Math.max(flip_A, flip_B));

  }

  private static int maxPerfectness(String str, char ch, int k) {
    int startingIndex = 0;
    int endingIndex = 0;
    int ans = 0;
    int flip = 0;

    while (endingIndex < str.length()) {
      // growing window
      if (str.charAt(endingIndex) == ch) {
        flip++;
      }
      // shrinking window
      while (flip > k && startingIndex <= endingIndex) {
        if (str.charAt(si) == ch) {
          flip--;
        }
      }
      // calculating the ans
      ans = Math.max(ans, endingIndex - startingIndex + 1);
      endingIndex++;

    }
    return ans;

  }

}
