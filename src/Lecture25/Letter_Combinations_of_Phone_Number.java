/*
 * 17. Letter Combinations of a Phone Number

Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

Example 1:
Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

Example 2:
Input: digits = "2"
Output: ["a","b","c"]

Constraints:
1 <= digits.length <= 4
digits[i] is a digit in the range ['2', '9']
* *****INTUITION*****
🧠 The Intuition (The "Why")
Think of this problem as exploring a decision tree. For an input like "23", we have a series of choices:

First Choice (Digit '2'): we are at the start. we must choose one letter from "abc". we have three paths we can take: 'a', 'b', or 'c'.

Second Choice (Digit '3'):

If we chose 'a', we now face wer second choice: the digit '3'. we must choose one letter from "def". This leads to three sub-paths: "ad", "ae", "af".

If we chose 'b', we also face the '3'. This leads to: "bd", "be", "bf".

If we chose 'c', we get: "cd", "ce", "cf".

wer recursive function, PrintAnswer, acts as an "explorer" in this tree.

question (e.g., "23"): This is the "path" we still need to explore.

ans (e.g., "a"): This is the "path" we have taken so far.

Recursive Step: The for loop is the key. It says: "At my current position, I will explore every single available choice." It makes one recursive call for 'a', then finishes that entire branch (which adds "ad", "ae", "af"). Then, the for loop "backtracks" and runs for 'b', starting a new branch.

Base Case: When question.length() == 0, it means the "path to explore" is empty. we have reached a leaf of the tree. The ans string is now a complete combination, so we add it to the final list.

 *🌳 Recursion Tree (for input digits = "23")
Here is a visual of what the code is doing. P(q, a) is a call to PrintAnswer(q, a, ...).

                        P("23", "")
                             |
         -------------------------------------------------
        /                         |                       \
(i=0, 'a')                  (i=1, 'b')                  (i=2, 'c')
 P("3", "a")                 P("3", "b")                 P("3", "c")
      |                           |                           |
  ---------                 ---------                 ---------
 /    |    \               /    |    \               /    |    \
'd'  'e'  'f'             'd'  'e'  'f'             'd'  'e'  'f'
 |    |    |               |    |    |               |    |    |
 |    |    |               |    |    |               |    |    |
P("", "ad") [ADD "ad"]     P("", "bd") [ADD "bd"]     P("", "cd") [ADD "cd"]
P("", "ae") [ADD "ae"]     P("", "be") [ADD "be"]     P("", "ce") [ADD "ce"]
P("", "af") [ADD "af"]     P("", "bf") [ADD "bf"]     P("", "cf") [ADD "cf"]
 */

package Lecture25;

import java.util.ArrayList;
import java.util.List;

public class Letter_Combinations_of_Phone_Number {
  static String[] code = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

  public static void main(String[] args) {
    List<String> list = new ArrayList<>();
    String question = "23";
    PrintAnswer(question, "", list);
  }

  public static void PrintAnswer(String question, String ans, List<String> list) {
    if (question.length() == 0) {
      // System.out.print(ans + " ");
      list.add(ans);
      return;
    }
    char ch = question.charAt(0);
    String keyPressed = code[ch - 48];
    for (int i = 0; i < keyPressed.length(); i++) {
      PrintAnswer(question.substring(1), ans + keyPressed.charAt(i), list);
    }
  }

}
