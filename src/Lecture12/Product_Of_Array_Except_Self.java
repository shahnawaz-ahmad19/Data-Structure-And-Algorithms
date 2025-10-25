
/*
 *Q)238. Product of Array Except Self
 *Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
You must write an algorithm that runs in O(n) time and without using the division operation.

Example 1:
Input: nums = [1,2,3,4]
Output: [24,12,8,6]
Example 2:

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]
 

Constraints:
2 <= nums.length <= 105
-30 <= nums[i] <= 30
The input is generated such that answer[i] is guaranteed to fit in a 32-bit integer.
 * 
 * 
 */

package Lecture12;

public class Product_Of_Array_Except_Self {
  public static void main(String[] args) {
    int[] arr = { 2, 3, 5, 6, 8 };
    int[] ans = product(arr);
    for (int i = 0; i < ans.length; i++) {
      System.out.print(ans[i] + " ");
    }

  }

  public static int[] product(int[] arr) {
    int n = arr.length;
    int[] leftproduct = new int[n];
    leftproduct[0] = 1;
    // Step1. Calculating leftproduct
    for (int i = 1; i < n; i++) {
      leftproduct[i] = leftproduct[i - 1] * arr[i - 1];
    }
    // Step2. Calculating rightProduct
    int[] rightProduct = new int[n];
    rightProduct[n - 1] = 1;
    for (int i = n - 2; i >= 0; i--) {
      rightProduct[i] = rightProduct[i + 1] * arr[i + 1];
    }
    // Strep3.
    for (int i = 0; i < n; i++) {
      leftproduct[i] = leftproduct[i] * rightProduct[i];
    }
    return leftproduct;
  }

}
