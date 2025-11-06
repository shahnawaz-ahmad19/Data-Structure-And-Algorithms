/*
 * Q) Print numbers from 0 to 1000 in lexicographically sorting order
 * 
 * 
 * 
 * 
*/
package Lecture26;

public class Print_Counting_Number_Lexicographically {
  public static void main(String[] args) {
    int n = 1000;
    printLexicographically(0, n);
  }

  public static void printLexicographically(int current, int n) {
    // Base Case: If we've gone past the limit, stop this path.
    if (current > n) {
      return;
    }
    // Visit: Print the valid number.
    System.out.println(current);

    // 'i' will be the next digit (0-9) to append.
    int i = 0;

    // **This is the most important logic.**
    // If we are at the root (0), its children start from 1 (1, 2, 3...)
    if (current == 0) {
      i = 1;
    }
    // Loop through all possible children.
    // - If current=0, loop i=1 to 9. (Calls P(1), P(2)...)
    // - If current=1, loop i=0 to 9. (Calls P(10), P(11)...)
    // - If current=13, loop i=0 to 9. (Calls P(130), P(131)...)
    for (; i <= 9; i++) {
      // The child's value is (current * 10 + i)
      printLexicographically(current * 10 + i, n);
    }
  }

}
