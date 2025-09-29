/*
 * Leetcode 
 * Q)42.Trapping Rain Water
 * Given n non-negative integers representing an elevation 
 *  where the width of each bar is 1, compute how much water it can trap after raining.

 

Example 1:
Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
 In this case, 6 units of rain water (blue section) are being trapped.

Example 2:
Input: height = [4,2,0,3,2,5]
Output: 9
 
Constraints:
n == height.length
1 <= n <= 2 * 104
0 <= height[i] <= 105
 */


package Lecture12;

public class Trapping_Rain_Water {
  public static void main(String[] args) {
    int [] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
    System.out.println(Water_trapping(arr));
  }

  public static int Water_trapping(int[] arr) {
    int n = arr.length;
    //Step1. Calculating LeftMaximum
    int [] leftMax = new int[n];
    leftMax[0] = arr[0];
    for (int i = 1; i < n; i++) {   
      leftMax[i]=Math.max(leftMax[i-1], arr[i]);
    }

    //Step2. Calculating RightMaximum
    int[] rightMax=new int[n];
    rightMax[n-1]=arr[n-1];
    for (int i = n-2; i >=0; i--) {
      rightMax[i]=Math.max(rightMax[i+1], arr[i]);
    }
    //Step3.
    int sum = 0;
    for (int i = 0; i < n; i++) {
      sum = sum +Math.min(leftMax[i], rightMax[i])-arr[i];
    }
    return sum;
  }

}
