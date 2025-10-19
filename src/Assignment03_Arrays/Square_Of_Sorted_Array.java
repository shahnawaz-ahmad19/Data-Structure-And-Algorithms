/*
 * Given an integer array nums sorted in non-decreasing order,
 *  return an array of the squares of each number sorted in non-decreasing order.
Input Format
First line of input contains an integer n representing the length of array n. Next line contains n array elements.

Constraints
1 <= nums.length <= 10^4
-10^4 <= nums[i] <= 10^4
nums is sorted in non-decreasing order.

Output Format
A sorted array representing squares of elements of nums array.

Sample Input
5
-4 -1 0 3 10

Sample Output
0 1 9 16 100

Explanation
After squaring, the array becomes [16,1,0,9,100]. After sorting, it becomes [0,1,9,16,100]

=> We can use a two-pointer approach to build the new array from scratch, in sorted order, in a single pass.

=> Create a new result array of the same size.

=> Use a left pointer at the start of the input (index 0) and a right pointer at the end (index n-1).

=> We will fill the result array from the end to the beginning (since we know the largest squares come from the edges).

=> Compare the absolute values at left and right.

The larger square goes into the result array, and we move the corresponding pointer (left or right) inward.
 */
package Assignment03_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Square_Of_Sorted_Array {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = sc.nextInt();
    }
    // Get the sorted squares array
    int[] sortedArr = squares(arr);

    // Print the sorted array
    for (int i = 0; i < sortedArr.length; i++) {
      System.out.print(sortedArr[i] + " ");
    }
  }

  /*
   * public static int[] squares(int[] arr) {
   * for (int i = 0; i < arr.length; i++) {
   * arr[i] = arr[i] * arr[i];
   * }
   * Arrays.sort(arr);
   * return arr;
   * }
   */
  // two-pointer approach solution.
  public static int[] squares(int[] arr) {
    int n = arr.length;
    int[] result = new int[n];

    int left = 0;
    int right = n - 1;
    for (int i = n - 1; i >= 0; i--) {
      int leftSquares = arr[left] * arr[left];
      int rightSquares = arr[right] * arr[right];
      if (leftSquares > rightSquares) {
        result[i] = leftSquares;
        left++;
      } else {
        result[i] = rightSquares;
        right--;
      }
    }
    return result;
  }
}
