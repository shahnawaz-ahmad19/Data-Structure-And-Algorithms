/*
 * **"Given `n` distinct slots (a 1D board) and `k` (or `totalQueens`) identical queens, find all possible combinations of placing these `k` queens into the `n` slots.**

**A combination is a unique set of chosen slots, regardless of the order. For example, placing queens at slots `[0, 1]` is considered the *same combination* as placing them at `[1, 0]`. Print all unique sets of placements."**
*/

package Lecture27;

public class Queens_Sitting_Combination {
  public static void main(String[] args) {
    int n = 4;
    int totalQueens = 2;
    boolean[] board = new boolean[n];
    combination(board, totalQueens, 0, "", 0);
  }

  public static void combination(boolean[] board, int totalQueens, int queenPlacedSoFar, String ans,
      int lastPlacedQueenIndex) {
    if (totalQueens == queenPlacedSoFar) {
      System.out.println(ans);
      return;
    }
    for (int i = lastPlacedQueenIndex; i < board.length; i++) {
      if (board[i] == false) {
        board[i] = true;
        combination(board, totalQueens, queenPlacedSoFar + 1, ans + "b" + i + "q" + queenPlacedSoFar, i + 1);
        board[i] = false;
      }
    }
  }

}
