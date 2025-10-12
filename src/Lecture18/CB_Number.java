/*
 * Finding CB Numbers
Kartik Bhaiya and Kanak Bhaiya are discussing a special type of number, which they call a Coding Blocks Number (CB Number). A number qualifies as a CB Number based on the following criteria:

0 and 1 are not considered CB numbers.

The following prime numbers are always CB numbers:
2, 3, 5, 7, 11, 13, 17, 19, 23, 29.

Any other number is a CB number if it is not divisible by any of the numbers listed in point (2).

The Challenge
===========================
Kartik Bhaiya challenges Kanak Bhaiya with a problem:

He provides a string of digits, and Kanak Bhaiya must determine the maximum number of CB numbers that can be extracted from it while following these constraints:


1. Non-overlapping Substrings:
A CB number cannot be a substring or superstring of another chosen CB number.

Example: In 4991, both 499 and 991 are CB numbers, but we can choose only one of them.

2. Valid Substring Selection:

The CB number must be a contiguous substring of the given string.

Example: In 481, we cannot select 41 as a CB number because 41 is not a contiguous substring of "481."


3. Maximization Goal:
Since multiple solutions may exist, the goal is to find the maximum number of CB numbers that can be extracted from the given string.

Kanak Bhaiya has a class of Launchpad students to teach and needs help solving this challenge. Assist him in finding the solution.


Input format
First line contain size of the string.

Next line is A string of digits.

Output format
Maximum number of CB numbers that can be formed.


Example 1
Input
5
81615


Output
2

Explanation
For the string "81615"
    
Digits	Possible Substrings
1-digit	8, 1, 6, 1, 5
2-digit	81, 16, 61, 15
3-digit	816, 161, 615
4-digit	8161, 1615
5-digit	81615

 */

package Lecture18;

public class CB_Number {
  public static void main(String[] args) {
    String str = "81615";
    System.out.println(Print_Substring_Lengthwise(str));

  }

  public static int Print_Substring_Lengthwise(String s) {
    int count = 0;
    boolean[] visited = new boolean[s.length()];
    for (int length = 1; length <= s.length(); length++) {
      for (int j = length; j <= s.length(); j++) {
        int i = j - length;
        String s1 = s.substring(i, j);
        if (isCBNumber(Long.parseLong(s1)) == true && IsValid(visited, i, j) == true) {
          count++;
          // i to j-1 mark visited because they are already part of a CB number
          for (int k = i; k < j; k++) {
            visited[k] = true;
          }
        }
      }
    }
    return count;
  }

  public static boolean IsValid(boolean[] visited, int i, int j) {
    for (; i < j; i++) {
      if (visited[i] == true) {
        return false;
      }
    }
    return true;
  }

  public static boolean isCBNumber(long num) {
    if (num == 0 || num == 1) {
      return false;
    }
    int[] cbPrimes = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29 };
    for (int prime : cbPrimes) {
      if (num == prime) {
        return true;
      }
    }
    for (int prime : cbPrimes) {
      if (num % prime == 0) {
        return false;
      }
    }
    return true;
  }

}
