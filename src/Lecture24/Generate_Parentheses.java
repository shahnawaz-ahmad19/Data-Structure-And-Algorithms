/*
 * 22. Generate Parentheses
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

Example 1:
Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]

Example 2:
Input: n = 1
Output: ["()"]
 

Constraints:
1 <= n <= 8
* *****INTUITION*****
🧠 The Core Idea
You are building the string one character at a time. To ensure the string is always "well-formed," you follow two simple rules:

Rule for (: You can add an open parenthesis ( only if you haven't already used all n of them.

Rule for ): You can add a close parenthesis ) only if it doesn't create an invalid string. The easy way to check this is to make sure you've already added more open parentheses than close ones.

⚙️ The Function and Parameters
Your Parentheses helper function keeps track of the "state" of your string builder:

n: The target number (e.g., 3). This never changes.

open: How many ( you have used so far.

close: How many ) you have used so far.

ans: The string you have built so far (e.g., "((").

list: The final list to store the answers.
 */

package Lecture24;

import java.util.ArrayList;
import java.util.List;

public class Generate_Parentheses {
  public static void main(String[] args) {
    int n = 3;
    List<String> list = new ArrayList<>();
    Parentheses(n, 0, 0, "", list);
    System.out.println(list);

  }

  public static void Parentheses(int n, int open, int close, String ans, List<String> list) {
    if (open == n && close == n) {
      // System.out.print(ans + " ");
      list.add(ans);
      return;
    }
    if (open < n) {
      Parentheses(n, open + 1, close, ans + "(", list);
    }
    if (close < open) {
      Parentheses(n, open, close + 1, ans + ")", list);
    }
  }

}
