package Lecture23;

public class DiceRollWays {
  public static void main(String[] args) {
    int target = 3;
    BoardPath(target, 0, "");

  }

  public static void BoardPath(int target, int currentVal, String ans) {
    if (currentVal == target) {
      System.out.print(ans + " ");
      return;
    }
    if (currentVal > target) {
      return;
    }
    /*
     * BoardPath(target, currentVal + 1, ans + 1);
     * BoardPath(target, currentVal + 2, ans + 2);
     * BoardPath(target, currentVal + 3, ans + 3);
     */
    for (int dice = 1; dice <= 3; dice++) {
      BoardPath(target, currentVal + dice, ans + dice);
    }

  }
}
