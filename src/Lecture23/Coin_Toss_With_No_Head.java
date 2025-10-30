package Lecture23;

public class Coin_Toss_With_No_Head {
  public static void main(String[] args) {
    int n = 3;
    PossibleOutcomes(n, "");
  }

  public static void PossibleOutcomes(int n, String ans) {
    if (n == 0) {
      System.out.print(ans + " ");
      return;
    }
    if (ans.length() == 0 || ans.charAt(ans.length() - 1) != 'H') {
      PossibleOutcomes(n - 1, ans + "H");
    }
    PossibleOutcomes(n - 1, ans + "T");

  }

}
