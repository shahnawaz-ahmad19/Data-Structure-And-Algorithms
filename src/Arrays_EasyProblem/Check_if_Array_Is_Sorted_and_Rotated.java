/*
 * 1752. Check if Array Is Sorted and Rotated

Hint
Given an array nums, return true if the array was originally sorted in non-decreasing order, then rotated some number of positions (including zero). Otherwise, return false.

There may be duplicates in the original array.

Note: An array A rotated by x positions results in an array B of the same length such that B[i] == A[(i+x) % A.length] for every valid index i.

 

Example 1:
Input: nums = [3,4,5,1,2]
Output: true
Explanation: [1,2,3,4,5] is the original sorted array.
You can rotate the array by x = 2 positions to begin on the element of value 3: [3,4,5,1,2].

Example 2:
Input: nums = [2,1,3,4]
Output: false
Explanation: There is no sorted array once rotated that can make nums.

Example 3:
Input: nums = [1,2,3]
Output: true
Explanation: [1,2,3] is the original sorted array.
You can rotate the array by x = 0 positions (i.e. no rotation) to make nums.
 

Constraints:

1 <= nums.length <= 100
1 <= nums[i] <= 100
* *****INTUITION*****

  *The "Roller Coaster" Idea 🎢
Imagine the array is a roller coaster track.

A perfectly sorted array ([1, 2, 3, 4, 5]) is like a roller coaster that only goes up.

A rotated sorted array ([3, 4, 5, 1, 2]) is a track that goes up, has one big drop, and then goes up again.

An invalid array ([2, 1, 3, 4]) is not possible. Wait, let's check that.

An invalid array ([1, 5, 2, 4]) has multiple drops (5 > 2 and 4 > 1 if it wraps around).

The problem states that a valid rotated array can have at most ONE "drop".

[3, 4, 5, 1, 2] has one drop (from 5 to 1). This is valid.

[1, 2, 3, 4, 5] has zero drops. This is also valid (it's rotated by 0 positions).

[2, 1, 3, 4] has two drops: one from 2 to 1, and another "wrap-around" drop from 4 to 2. This is invalid.

The Solution: We just need to count the number of "drops" (where previous_number > current_number). If the count is 0 or 1, the array is valid.

* Example 1: nums = [3, 4, 5, 1, 2]

drops starts at 0.

Loop:

i=0: Is 3 > 4? No.

i=1: Is 4 > 5? No.

i=2: Is 5 > 1? Yes. drops is now 1.

i=3: Is 1 > 2? No.

Wrap-around check:

Is nums[4] > nums[0]? (Is 2 > 3?) No.

Final: return drops <= 1 (Is 1 <= 1?) -> true. This is correct.

* Example 2: nums = [2, 1, 3, 4]

drops starts at 0.

Loop:

i=0: Is 2 > 1? Yes. drops is now 1.

i=1: Is 1 > 3? No.

i=2: Is 3 > 4? No.

Wrap-around check:

Is nums[3] > nums[0]? (Is 4 > 2?) Yes. drops is now 2.

Final: return drops <= 1 (Is 2 <= 1?) -> false. This is correct.

* Example 3: nums = [1, 2, 3]

drops starts at 0.

Loop:

i=0: Is 1 > 2? No.

i=1: Is 2 > 3? No.

Wrap-around check:

Is nums[2] > nums[0]? (Is 3 > 1?) Yes. drops is now 1.

Final: return drops <= 1 (Is 1 <= 1?) -> true. This is correct.
 */

package Arrays_EasyProblem;

public class Check_if_Array_Is_Sorted_and_Rotated {
  public static void main(String[] args) {
    int[] arr = { 3, 4, 5, 1, 2 };
    System.out.println(check(arr));
  }

  public static boolean check(int[] nums) {
    int n = nums.length;
    int drops = 0; // Our counter for the number of "drops"

    // 1. Check the main part of the array (from index 0 to n-2)
    for (int i = 0; i < n - 1; i++) {
      if (nums[i] > nums[i + 1]) {
        // We found a drop!
        drops++;
      }
    }

    // 2. Check the "wrap-around" (from last element to first)
    if (nums[n - 1] > nums[0]) {
      // We found another drop!
      drops++;
    }

    // A valid array has 0 or 1 drops.
    // An invalid array has 2 or more drops.
    return drops <= 1;
  }

}
