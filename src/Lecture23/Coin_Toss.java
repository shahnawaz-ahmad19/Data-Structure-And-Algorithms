/*
 * Generate all possible outcomes of tossing a coin n times (recursive)
 */
package Lecture23;

public class Coin_Toss {
  public static void main(String[] args) {
    int n = 3;
    possibleOutcomes(n, "");
  }

  public static void possibleOutcomes(int n, String ans) {
    if (n == 0) {
      System.out.print(ans + " ");
      return;
    }

    possibleOutcomes(n - 1, ans + "H");
    possibleOutcomes(n - 1, ans + "T");
  }

}
