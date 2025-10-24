/*
 * 268. Missing Number
Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.

Example 1:
Input: nums = [3,0,1]

Output: 2
Explanation:

n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.

Example 2:
Input: nums = [0,1]

Output: 2
Explanation:

n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number in the range since it does not appear in nums.

Example 3:
Input: nums = [9,6,4,2,3,5,7,0,1]

Output: 8
Explanation:

n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 8 is the missing number in the range since it does not appear in nums.
 */

package Arrays_EasyProblem;

public class Missing_Number {
  public static void main(String[] args) {
    int[] arr = { 0, 1, 3 };
    System.out.println(missingNumber(arr));

  }

  public static int missingNumber(int[] nums) {
    int n = nums.length;

    // 1. Calculate the expected sum from 0 to n
    // n * (n + 1) / 2
    int expectedSum = (n * (n + 1)) / 2;

    // 2. Calculate the actual sum of the array
    int actualSum = 0;
    for (int num : nums) {
      actualSum += num;
    }

    // 3. The difference is the missing number
    return expectedSum - actualSum;
  }

}
