/*
 * 283. Move Zeroes

Hint
Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.

 

Example 1:
Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]

Example 2:
Input: nums = [0]
Output: [0]
 

Constraints:

1 <= nums.length <= 104
-231 <= nums[i] <= 231 - 1
 */
package Arrays_EasyProblem;

public class Move_Zeros {
  public static void main(String[] args) {
    int[] arr = { 0, 1, 0, 3, 12 };
    moveZeros(arr);

  }

  public static void moveZeros(int[] nums) {

    // 'nextVipSpot' tracks the position where the
    // next non-zero number (VIP) should be placed.
    int nextVipSpot = 0;

    // 'currentGuest' is the pointer that scans the entire array
    // to check every element (guest).
    for (int currentGuest = 0; currentGuest < nums.length; currentGuest++) {

      // Check the ticket of the 'currentGuest'
      if (nums[currentGuest] != 0) {
        // It's a VIP!

        // Swap the VIP (at 'currentGuest') with the person
        // at the 'nextVipSpot'.
        int temp = nums[nextVipSpot];
        nums[nextVipSpot] = nums[currentGuest];
        nums[currentGuest] = temp;

        // The 'nextVipSpot' is now filled.
        // Move the rope to the next position.
        nextVipSpot++;
      }
      // If the 'currentGuest' is a zero, we do nothing.
      // We just move on to check the next person.
      // The 'nextVipSpot' pointer waits patiently for the next VIP.
    }
  }

}
