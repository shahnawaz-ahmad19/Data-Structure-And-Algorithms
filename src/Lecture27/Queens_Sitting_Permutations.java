package Lecture27;

public class Queens_Sitting_Permutations {
  public static void main(String[] args) {
    int n = 4;
    int totalQueens = 2;
    boolean[] board = new boolean[n];
    permutation(board, totalQueens, 0, "");

  }

  public static void permutation(boolean[] board, int totalQueens, int queenPlacedSoFar, String ans) {
    if (totalQueens == queenPlacedSoFar) {
      System.out.println(ans);
      return;
    }
    for (int i = 0; i < board.length; i++) {
      if (board[i] == false) {
        board[i] = true;
        permutation(board, totalQueens, queenPlacedSoFar + 1, ans + "b" + i + "q" + queenPlacedSoFar);
        board[i] = false;
      }
    }
  }

}
