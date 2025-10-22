/*
 * Leetcode
 * 125. Valid Palindrome
Solved
Easy
Topics
premium lock icon
Companies
A phrase is a palindrome if, after converting all uppercase 
letters into lowercase letters and removing all non-alphanumeric characters,
it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.
Example 1:
Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.
Example 2:

Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.
Example 3:

Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.
 
Constraints:
1 <= s.length <= 2 * 105
s consists only of printable ASCII characters.
 */
package Basic_Maths;

import java.util.Scanner;

public class Valid_Palindrome {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String s = sc.nextLine();
    System.out.println(isPalindrome(s));

  }

  public static boolean isPalindrome(String s) {
    // Create the cleaned-up string once
    String validString = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
    // Initialize pointers based on the CLEANED string's length
    Integer i = 0;
    Integer j = validString.length() - 1;
    // String un = s.replaceAll("[^a-zA-Z0-9]", "");
    while (i < j) {
      // Compare characters from the cleaned string
      if (validString.charAt(i) != validString.charAt(j)) {
        return false;
      }
      i++;
      j--;
    }
    return true;
  }

}
