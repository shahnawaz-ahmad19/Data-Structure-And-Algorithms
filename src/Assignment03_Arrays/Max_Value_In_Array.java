/*
 * Take as input N, the size of array. Take N more inputs and store that in an array.
 *  Take as input “target”, a number. Write a function which prints all pairs of numbers which sum to target.


Input Format
The first line contains input N. Next N lines contains the elements of array and (N+1)th line contains target number.

Constraints
Length of the arrays should be between 1 and 1000.

Output Format
Print all the pairs of numbers which sum to target. Print each pair in increasing order.

Sample Input
5
1
3
4
2
5
5
Sample Output
1 and 4
2 and 3
Explanation
Find any pair of elements in the array which has sum equal to target element and print them.
 */

package Assignment03_Arrays;

import java.util.Scanner;

public class Max_Value_In_Array {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = sc.nextInt();
    }
    System.out.println(findMaximum(arr));
  }

  public static int findMaximum(int[] arr) {
    int maxValue = arr[0];
    for (int i = 1; i < arr.length; i++) {
      if (arr[i] > maxValue) {
        maxValue = arr[i];
      }
    }
    return maxValue;
  }

}
