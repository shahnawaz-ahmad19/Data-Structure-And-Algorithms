/*
 * LeetCode-189
 * Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.

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

package Lecture10;

public class Rotate_Array {
  public static void main(String[] args) {
    int [] arr = {1,2,3,4,5,6,7};
    int k = 3;
    Rotate(arr, k);
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i]+ " ");
    }
  }

  public static void Rotate(int[] arr, int k) {
    int n = arr.length;
    k=k%n; //for finding the period or rotation
    for (int i = 1; i <=k; i++) {
      int lastElement=arr[n-1];
      for (int j = n-2; j >=0; j--) {
      arr[j+1] = arr[j];
    }
    arr[0]=lastElement;
    } 
  }

}
// But this solution gives TLE(Time Limit Exceed) error as it is not optimized