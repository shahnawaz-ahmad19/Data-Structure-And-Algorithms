/*
 * Given an array of integers nums and an integer k, return the number of contiguous subarrays where the product of all the elements in the subarray is strictly less than k.

Example 1:
Input: nums = [10,5,2,6], k = 100
Output: 8
Explanation: The 8 subarrays that have product less than 100 are:
[10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6]
Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
Example 2:

Input: nums = [1,2,3], k = 0
Output: 0
Constraints:

1 <= nums.length <= 3 * 104
1 <= nums[i] <= 1000
0 <= k <= 106
 */

package Lecture20;

public class Subarray_Product_LessThan_K {
  public static void main(String[] args) {
    int[] arr = { 10, 5, 2, 6 };
    int k = 100;
    System.out.println(numSubarrayProductLessThanK(arr, k));

  }

  public static int numSubarrayProductLessThanK(int[] nums, int k) {
    int startingIndex = 0;
    int endingIndex = 0;
    int product = 1;
    int ans = 0;
    while (endingIndex < nums.length) {
      // for growing the window
      product = product * nums[endingIndex];

      // for shrinking the window
      while (product >= k && startingIndex <= endingIndex) {
        product = product / nums[startingIndex];
        startingIndex++;
      }
      // calculating the ans
      ans = ans + (endingIndex - startingIndex + 1);
      endingIndex++;
    }
    return ans;

  }

}
