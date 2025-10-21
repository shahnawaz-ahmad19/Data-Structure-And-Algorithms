/*
 * 1. Two Sum

Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

Example 1:
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

Example 2:
Input: nums = [3,2,4], target = 6
Output: [1,2]

Example 3:
Input: nums = [3,3], target = 6
Output: [0,1]
 

Constraints:
2 <= nums.length <= 104
-109 <= nums[i] <= 109
-109 <= target <= 109

* ***********INTUTION************
The Intuition (The "One-Pass" HashMap)
The core idea is this: As you iterate through the array, for each number x, you need to find its "partner" or "complement," which is target - x.

Instead of looping through the rest of the array to find this complement, you just check if it's already in your HashMap.

Create an empty HashMap to store (value, index).

Start looping through the nums array.

At each number nums[i], calculate its required complement: int complement = target - nums[i].

Check the map: "Have I already seen the complement?"

*If YES: You're done! You've found the pair.
 The current index is i, and the complement's index is stored in the map. Return [map.get(complement), i].

*If NO: Add the current number nums[i] and its index i to the map. 
This way, if a future number needs nums[i] as its complement, it can find it.

*Analogy: The "Seen Before" List
The HashMap is a list of "Numbers I've already seen and their index."

Goal: Find two numbers that make 9. Array: [2, 7, 11, 15]

I'm at i = 0. The number is 2.

Question: To make 9, what number do I need?

Answer: I need a 7 (because 9 - 2 = 7).

Action: I check my "Seen Before" list. Have I seen a 7?

This is the check numMap.containsKey(7).

Result: No. My list is empty.

Final Action: I add my number, 2, to the "Seen Before" list.

List is now: {(key: 2, value: index 0)}

I'm at i = 1. The number is 7.

Question: To make 9, what number do I need?

Answer: I need a 2 (because 9 - 7 = 2).

Action: I check my "Seen Before" list. Have I seen a 2?

This is the check numMap.containsKey(2).

Result: YES! It's on my list!

Final Action: I found the pair! The number I need (2) is on the list,
 and its value is index 0. My current index is 1. I return [0, 1].
 */

package Assignment03_Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Two_Sum {
  public static void main(String[] args) {

  }

  public static int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> numMap = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int currentSum = nums[i];
      int complement = target - currentSum;
      // Check if the complement we need is already in the map
      if (numMap.containsKey(complement)) {
        // Found it! Return the complement's index and the current index
        return new int[] { numMap.get(complement), i };
      }
      // If we didn't find the complement, add the CURRENT number to the map
      // so it can be found by a future element.
      numMap.put(currentSum, i);

    }
    // In case there is no solution, return an empty array
    return new int[] {};
  }

}
