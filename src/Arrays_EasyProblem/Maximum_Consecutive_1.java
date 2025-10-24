/*
 * 485. Max Consecutive Ones

Given a binary array nums, return the maximum number of consecutive 1's in the array.

Example 1:
Input: nums = [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.

Example 2:
Input: nums = [1,0,1,1,0,1]
Output: 2

Constraints:

1 <= nums.length <= 105
nums[i] is either 0 or 1.
 */

package Arrays_EasyProblem;

public class Maximum_Consecutive_1 {
  public static void main(String[] args) {
    int[] arr = { 0, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1, 1, 1 };
    System.out.println(findMaxConsecutiveOnes(arr));

  }

  public static int findMaxConsecutiveOnes(int[] nums) {
    // An integer to count the streak of 1s we are currently in.
    int currentStreak = 0;
    // An integer to keep track of the highest streak we've seen so far.
    int maxStreak = 0;
    for (int i = 0; i < nums.length; i++) {
      // If we see a 1:
      // We are in a streak. Increment the currentStreak.
      if (nums[i] == 1) {
        currentStreak++;
        // Is this current streak now the biggest one we've ever seen?
        maxStreak = Math.max(currentStreak, maxStreak);
        // If we see a 0:
        // The streak is broken.
        // We must reset our currentStreak back to 0.
      } else {
        currentStreak = 0;
      }
    }
    return maxStreak;

  }

}
