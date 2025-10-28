/*
 * 2149. Rearrange Array Elements by Sign
Hint
You are given a 0-indexed integer array nums of even length consisting of an equal number of positive and negative integers.

You should return the array of nums such that the array follows the given conditions:

Every consecutive pair of integers have opposite signs.
For all integers with the same sign, the order in which they were present in nums is preserved.
The rearranged array begins with a positive integer.
Return the modified array after rearranging the elements to satisfy the aforementioned conditions.

 

Example 1:
Input: nums = [3,1,-2,-5,2,-4]
Output: [3,-2,1,-5,2,-4]
Explanation:
The positive integers in nums are [3,1,2]. The negative integers are [-2,-5,-4].
The only possible way to rearrange them such that they satisfy all conditions is [3,-2,1,-5,2,-4].
Other ways such as [1,-2,2,-5,3,-4], [3,1,2,-2,-5,-4], [-2,3,-5,1,-4,2] are incorrect because they do not satisfy one or more conditions.  

Example 2:
Input: nums = [-1,1]
Output: [1,-1]
Explanation:
1 is the only positive integer and -1 the only negative integer in nums.
So nums is rearranged to [1,-1].
 

Constraints:

2 <= nums.length <= 2 * 105
nums.length is even
1 <= |nums[i]| <= 105
nums consists of equal number of positive and negative integers.
* *****INTUITION*****
*Developing the Intuition

Read the Rules Again:
  Pair-by-pair, signs must be opposite.
  Relative order of same-sign numbers is preserved.
  The array must start with a positive number.

Combine Rule 1 and Rule 3: This is the key insight.
 If the array must start with a positive, and signs must alternate, then the entire structure of the output array is fixed.

index 0 must be positive.

index 1 must be negative.

index 2 must be positive.

index 3 must be negative.

...and so on.

So, we're not really "rearranging" in a complex way. we're just filling in the slots:

All Positive numbers go into the even indices (0, 2, 4, ...).

All Negative numbers go into the odd indices (1, 3, 5, ...).

Use Rule 2 (Preserve Order): How do we fill these slots while preserving the original order?

Simple: we iterate through the input array nums from start to finish. As we find each number, we place it in the next available slot for its sign.

This naturally preserves the relative order. The first positive we find goes in index 0. The second positive we find goes in index 2, and so on.

*The Two-Pointer Solution (Optimal)
This intuition leads to a clean "two-pointer" solution. we're not using two pointers to scan the same array, but two index pointers to build your new array.

Create a new result array, the same size as nums.

Create two index variables (our "pointers"):

posIndex = 0 (This tracks the next even slot to fill)

negIndex = 1 (This tracks the next odd slot to fill)

Loop through the original nums array from start to finish.

Inside the loop:

If nums[i] is positive, place it in result[posIndex] and then move the positive pointer: posIndex += 2.

If nums[i] is negative, place it in result[negIndex] and then move the negative pointer: negIndex += 2.

Return the result array.
 */

package Arrays_MediumProblem;

import java.util.Arrays;

public class Rearrange_Array_Elements_by_Sign {
  public static void main(String[] args) {
    int[] arr = { 3, 1, -2, -5, 2, -4 };
    int[] resArr = rearrangeArray(arr);
    // System.out.println(Arrays.toString(resArr));
    for (int i = 0; i < resArr.length; i++) {
      System.out.print(resArr[i] + " ");
    }

  }

  public static int[] rearrangeArray(int[] nums) {
    int n = nums.length;
    // 1. Create a new result array
    int[] result = new int[n];
    // 2. Create two "index" pointers
    // posIndex will fill the even slots (0, 2, 4, ...)
    int posIndex = 0;
    // negIndex will fill the odd slots (1, 3, 5, ...)
    int negIndex = 1;
    // 3. Loop through the original array to find numbers
    for (int i = 0; i < n; i++) {
      // 4. If the number is positive
      if (nums[i] > 0) {
        // Place it at the next available positive slot
        result[posIndex] = nums[i];
        // Move the positive pointer to the next even slot
        posIndex += 2;
        // 5. If the number is negative
      } else {
        // Place it at the next available negative slot
        result[negIndex] = nums[i];
        // Move the negative pointer to the next odd slot
        negIndex += 2;
      }
    }
    // 6. Return the fully-built array
    return result;

  }
}
