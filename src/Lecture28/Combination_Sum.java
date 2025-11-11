/*
 * 39. Combination Sum
Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.

The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.

Example 1:

Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.
Example 2:

Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]
Example 3:

Input: candidates = [2], target = 1
Output: []
 

Constraints:

1 <= candidates.length <= 30
2 <= candidates[i] <= 40
All elements of candidates are distinct.
1 <= target <= 40
*/
package Lecture28;

import java.util.ArrayList;
import java.util.List;

public class Combination_Sum {
  public static void main(String[] args) {
    int[] coins = { 2, 1, 3, 5 };
    int targetAmount = 4;
    List<Integer> ll = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();
    coinCombination(coins, targetAmount, ll, 0, ans);
    System.out.println(ans);

  }

  public static void coinCombination(int[] coins, int targetAmount, List<Integer> ll, int idx,
      List<List<Integer>> ans) {
    if (targetAmount == 0) {
      //System.out.println(ll);
      ans.add(new ArrayList<>(ll));
      return;
    }
    for (int i = idx; i < coins.length; i++) {
      if (targetAmount >= coins[i]) {
        ll.add(coins[i]);
        coinCombination(coins, targetAmount - coins[i], ll, i, ans);
        ll.remove(ll.size() - 1); //backtracking step
      }
    }
  }

}
