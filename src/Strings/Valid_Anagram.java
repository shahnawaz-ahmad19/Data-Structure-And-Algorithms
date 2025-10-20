/*
 * LeetCode Problem 242: Valid Anagram
 * 
Given two strings s and t, return true if t is an anagram of s, and false otherwise.

 

Example 1:
Input: s = "anagram", t = "nagaram"

Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false

Constraints:

1 <= s.length, t.length <= 5 * 104
s and t consist of lowercase English letters.
 */

package Assignment03_Arrays;

public class Valid_Anagram {
  public static void main(String[] args) {

  }

  public boolean isAnagram(String s, String t) {
    /*
     * Naive approach
     * if (s.length() != t.length()) return false;
     * 
     * // Sort both strings
     * char[] s1Array = s.toCharArray();
     * char[] s2Array = t.toCharArray();
     * Arrays.sort(s1Array);
     * Arrays.sort(s2Array);
     * 
     * // Compare sorted strings
     * return Arrays.equals(s1Array, s2Array);
     */

    // Step 1: The quick check. Anagrams must have the same length.
    if (s.length() != t.length()) {
      return false;
    }

    // Step 2: Create our 26 "buckets" for each lowercase English letter.
    // The array is automatically filled with zeros.
    int[] charCounts = new int[26];

    // Step 3: First pass. Loop through string 's' and add to the counts.
    for (int i = 0; i < s.length(); i++) {
      // 'a' - 'a' is 0, 'b' - 'a' is 1, etc.
      // This finds the correct bucket for the letter.
      int index = s.charAt(i) - 'a';
      charCounts[index]++; // Add one to the bucket.
    }

    // Step 4: Second pass. Loop through string 't' and subtract from the counts.
    for (int i = 0; i < t.length(); i++) {
      int index = t.charAt(i) - 'a';
      charCounts[index]--; // Remove one from the bucket.

      // The "shortcut" check. If a bucket goes negative, it means 't' has
      // a letter that 's' didn't have, so they can't be anagrams.
      if (charCounts[index] < 0) {
        return false;
      }
    }

    // Step 5: If the second loop completes, it means every count that was
    // added was perfectly cancelled out. They are anagrams.
    return true;
  }

}
