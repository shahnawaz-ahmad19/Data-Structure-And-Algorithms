/*
 * 189. Rotate Array
Solved
Medium
Topics
premium lock icon
Companies
Hint
Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.

 

Example 1:

Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
Example 2:

Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation: 
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]
 

Constraints:

1 <= nums.length <= 105
-231 <= nums[i] <= 231 - 1
0 <= k <= 105
 
 */

package Arrays_EasyProblem;

public class Rotate_Array {
  public static void main(String[] args) {

  }

  public static void Rotate(int[] arr, int k) {
    int n = arr.length;
    k = k % n;

    Reverse(arr, n - k, n - 1); // for reversing last k's element
    Reverse(arr, 0, n - 1); // for rotating whole array
    Reverse(arr, k, n - 1);// for rotating last elements other than k's elements

  }

  public static void Reverse(int[] arr, int i, int j) {
    while (i < j) {
      int temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
      i++;
      j--;
    }
  }

}
