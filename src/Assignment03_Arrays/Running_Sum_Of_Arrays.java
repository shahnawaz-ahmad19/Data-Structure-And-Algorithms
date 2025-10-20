/*
 * Given an array nums of length n. We define a running sum of an array as for every index runningSum[i] = sum(nums[0]…nums[i]).

Return the running sum of array for each i (0 <= i < n).

Input Format
First line contains an integer n representing number of elements. Next line contains n integers denoting array elements.

Constraints
1 <= nums.length <= 1000
-10^6 <= nums[i] <= 10^6


Output Format
An integer representing running sum array of the given array

Sample Input
4
1 2 3 4
Sample Output
1 3 6 10
Explanation
Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4].
 */

package Assignment03_Arrays;

import java.util.Scanner;

public class Running_Sum_Of_Arrays {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = sc.nextInt();
    }
    // Get the resultArr array
    int[] resultArr = RunnningSum(arr);

    // Print the resultArr array
    for (int i = 0; i < resultArr.length; i++) {
      System.out.print(resultArr[i] + " ");
    }

  }

  public static int[] RunnningSum(int[] arr) {
    int sum = 0;
    for (int i = 0; i < arr.length; i++) {
      sum = arr[i] + sum;
      arr[i] = sum;
    }
    return arr;
  }
}
