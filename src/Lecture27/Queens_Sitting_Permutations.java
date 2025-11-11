/*
 * > **Given n distinct slots (a 1D board) and k (or totalQueens) distinct queens, find all possible permutations of placing these k queens into the n slots.**
> 
> 
> **Each slot can hold at most one queen. Print the sequence of all possible placements, identifying each placement by its slot number (b) and the queen's index (q)."**

**For your input (`n=4`, `totalQueens=2`), this means: "Find all the ways to place Queen 0 and Queen 1 into 4 available slots."**
*/
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
