/*
 *
 * 386. Lexicographical Numbers
Given an integer n, return all the numbers in the range [1, n] sorted in lexicographical order.

You must write an algorithm that runs in O(n) time and uses O(1) extra space. 

Example 1:
Input: n = 13
Output: [1,10,11,12,13,2,3,4,5,6,7,8,9]

Example 2:
Input: n = 2
Output: [1,2]
 
Constraints:

1 <= n <= 5 * 104
*/
package Lecture26;

import java.util.ArrayList;
import java.util.List;

public class Lexicographical_Numbers {
  public List<Integer> lexicalOrder(int n) {
    // 1. Create the list to store the results.
    List<Integer> result = new ArrayList<>();

    // 2. Call your function, starting from 0, and pass the list.
    printLexicographically(0, n, result);

    // 3. Return the populated list.
    return result;
  }

  /**
     * This is exact function, modified to add to a list.
     *
     * @param current The current number (e.g., 0, 1, 10, 100...).
     * @param n       The maximum number.
     * @param result  The list to add numbers to.
     */
  public void printLexicographically(int current, int n, List<Integer> result) {
    // Base Case: If we are past the limit, stop.
    if (current > n) {
      return;
    }

    //required output is in the form of  [1, n], so we skip adding 0..
    if (current != 0) {
      result.add(current);
    }

    // Your "Recursive Step" logic (this is perfect):
    int i = 0;

    // This handles the special case for the root (0),
    // so its children start from 1.
    if (current == 0) {
      i = 1;
    }

    // Loop through all children (0-9 for most numbers, 1-9 for 0)
    for (; i <= 9; i++) {
      // Recurse on the child
      printLexicographically(current * 10 + i, n, result);
    }
  }

}
