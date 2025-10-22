/*
 * Take as input N, the size of array.
 *  Take N more inputs and store that in an array.
 *  Take as input “target”, a number.
 *  Write a function which prints all pairs of numbers which sum to target.


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

import java.util.Arrays;
import java.util.Scanner;

public class Target_Sum_Pairs {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = sc.nextInt();
    }

    int targetNumber = sc.nextInt();
    findDuplets(arr, targetNumber);

  }

  public static void findDuplets(int[] arr, int target) {
    // 1. Sort the array
    Arrays.sort(arr);

    // 2. Set up ONE left and ONE right pointer
    int left = 0;
    int right = arr.length - 1;

    // 3. Loop until the pointers cross
    while (left < right) {
      int currentSum = arr[left] + arr[right];

      if (currentSum == target) {
        // 4. Found a pair!
        System.out.println(arr[left] + " and " + arr[right]);

        // 5. Skip duplicates
        while (left < right && arr[left] == arr[left + 1]) {
          left++;
        }
        while (left < right && arr[right] == arr[right - 1]) {
          right--;
        }

        // 6. Move to the next unique pair
        left++;
        right--;

      } else if (currentSum < target) {
        // 7. Sum is too small, move left pointer to get a bigger number
        left++;
      } else {
        // 8. Sum is too big, move right pointer to get a smaller number
        right--;
      }
    }
  }
}
