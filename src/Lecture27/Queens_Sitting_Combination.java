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
