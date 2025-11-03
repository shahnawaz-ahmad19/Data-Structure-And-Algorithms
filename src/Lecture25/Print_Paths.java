/*
 * **Q)There is a robot on an `m x n` grid. The robot is initially located at the top-left corner (i.e., `grid[0][0]`). The robot tries to move to the bottom-right corner (i.e., `grid[m - 1][n - 1]`). The robot can only move either down or right at any point in time.**

**Given the two integers `m` and `n`Print the *possible unique paths that the robot can take to reach the bottom-right corner*.**
 */

package Lecture25;

public class Print_Paths {
  public static void main(String[] args) {
    int n = 4;// row
    int m = 5; // column
    PrintPath(0, 0, m - 1, n - 1, "");
  }

  private static void PrintPath(int currentColumn, int currentRow, int lastColumn, int lastRow, String ans) {
    if (currentRow == lastRow && currentColumn == lastColumn) {
      System.out.println(ans + " ");
      return;
    }
    if (currentRow > lastRow || currentColumn > lastColumn) {
      return;
    }

    PrintPath(currentColumn + 1, currentRow, lastColumn, lastRow, ans + "H");
    PrintPath(currentColumn, currentRow + 1, lastColumn, lastRow, ans + "V");
  }

}
