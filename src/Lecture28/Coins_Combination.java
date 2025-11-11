package Lecture28;

public class Coins_Combination {
  public static void main(String[] args) {
    int[] coins = { 2, 1, 3, 5 };
    int targetAmount = 4;
    coinCombination(coins, targetAmount, "", 0);

  }

  public static void coinCombination(int[] coins, int targetAmount, String ans, int idx) {
    if (targetAmount == 0) {
      System.out.println(ans);
      return;
    }
    for (int i = idx; i < coins.length; i++) {
      if (targetAmount >= coins[i]) {
        coinCombination(coins, targetAmount - coins[i], ans + coins[i], i);
      }
    }
  }

}
