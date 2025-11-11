/*
 * You are given a set of coin denominations, coins = {1, 2, 3, 5}, and a target sum of 4. 
 * Assuming you have an infinite supply of each coin,
 *  find and list all possible permutations (ordered sequences) of coins that sum up exactly to the target.
*/
package Lecture28;

public class Coins_Permutation_Using_Backtracking {
  public static void main(String[] args) {
    int[] coins = { 2, 1, 3, 5 };
    int targetAmount = 4;
    coinPermutation(coins, targetAmount, "");

  }

  public static void coinPermutation(int[] coins, int targetAmount, String ans) {
    if (targetAmount == 0) {
      System.out.println(ans);
      return;
    }
    for (int i = 0; i < coins.length; i++) {
      if (targetAmount >= coins[i]) {
        targetAmount -= coins[i];
        coinPermutation(coins, targetAmount, ans + coins[i]);
        targetAmount += coins[i]; //backtracking step
      }
    }
  }

}
