/*
 * 31. Next Permutation
A permutation of an array of integers is an arrangement of its members into a sequence or linear order.

For example, for arr = [1,2,3], the following are all the permutations of arr: [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].
The next permutation of an array of integers is the next lexicographically greater permutation of its integer. More formally, if all the permutations of the array are sorted in one container according to their lexicographical order, then the next permutation of that array is the permutation that follows it in the sorted container. If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).

For example, the next permutation of arr = [1,2,3] is [1,3,2].
Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger rearrangement.
Given an array of integers nums, find the next permutation of nums.

The replacement must be in place and use only constant extra memory.

 

Example 1:
Input: nums = [1,2,3]
Output: [1,3,2]

Example 2:
Input: nums = [3,2,1]
Output: [1,2,3]

Example 3:
Input: nums = [1,1,5]
Output: [1,5,1]
 
Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 100

* *****INTUITION*****

The main idea is that we want to make the number just slightly bigger.

To make a number bigger, we have to change a digit on the left to be a larger digit. To make it only slightly bigger, we want to make this change as far to the right as possible.

Think about the number 13542. The part 542 is in descending order. It's "maxed out"—you can't rearrange 542 to be any larger. To make the whole number larger, you have to "dip into" this descending part and change a number to its left.

The first number from the right that isn't in descending order is 3 (because 3 < 5). This is the "pivot" we need to change.

This gives us a 3-step algorithm.

The 3-Step Algorithm
Let's find the next permutation for [1, 3, 5, 4, 2].

Step 1: Find the "Pivot" Scan from the right to the left. Find the first number nums[i] that is smaller than the number to its right (nums[i+1]).

[1, 3, 5, 4, 2]

2

4 (Is 4 < 2? No.)

5 (Is 5 < 4? No.)

3 (Is 3 < 5? Yes!)

Stop. Our "pivot" is 3 at index 1. Everything to its right ([5, 4, 2]) is a descending "suffix" that is as large as it can be.

Step 2: Find the "Swap Partner" We need to swap our pivot (3) with a number from the suffix [5, 4, 2]. To make the smallest possible increase, we must swap it with the smallest number that is still larger than the pivot.

Scan the suffix ([5, 4, 2]) from right to left again. Find the first number that is greater than our pivot (3).

Is 2 > 3? No.

Is 4 > 3? Yes!

Stop. Our "swap partner" is 4 at index 3.

Now, swap them: [1, 3, 5, 4, 2] becomes [1, 4, 5, 3, 2]

Step 3: Make the Suffix as Small as Possible Our number is now [1, 4, 5, 3, 2]. We've made it bigger, but is it the next biggest? The prefix [1, 4] is locked, but we want the smallest possible arrangement of the new suffix [5, 3, 2].

How do you get the smallest arrangement? Sort it in ascending order.

[5, 3, 2] sorted becomes [2, 3, 5].

A key trick: The suffix [5, 4, 2] was already in descending order. Swapping 3 and 4 gave us a new suffix [5, 3, 2] which is still in descending order. The fastest way to sort a descending-order array is to just reverse it.

Reverse the suffix [5, 3, 2] to get [2, 3, 5].

Final array: [1, 4, 2, 3, 5]

The Edge Case (The "Largest" Permutation)
What about [3, 2, 1]?

Step 1: Find the pivot.

1

2 (Is 2 < 1? No.)

3 (Is 3 < 2? No.)

We've reached the beginning of the array and found no pivot. This means the entire array is in descending order. It's the largest possible permutation.

The problem says in this case, we must return the lowest possible order (sorted ascending).

What's the fastest way to sort [3, 2, 1] (which is in descending order) to be [1, 2, 3] (ascending order)?

Just reverse the whole thing.
 */
package Arrays_MediumProblem;

public class Next_Permutation {
  public static void main(String[] args) {

  }

  public void nextPermutation(int[] nums) {
    int n = nums.length;

    // --- Step 1: Find the "Pivot" ---
    // Find the first element from the right (i) that is
    // smaller than the element to its right (i+1).
    int pivotIndex = -1;
    for (int i = n - 2; i >= 0; i--) {
      if (nums[i] < nums[i + 1]) {
        pivotIndex = i;
        break; // Found the pivot, stop searching
      }
    }

    // --- Step 2: Handle the Edge Case (Largest Permutation) ---
    if (pivotIndex == -1) {
      // If no pivot was found, the array is in descending order (e.g., [3, 2, 1])
      // This is the largest permutation, so we reverse it
      // to get the smallest (e.g., [1, 2, 3]).
      reverse(nums, 0, n - 1);
      return;
    }

    // --- Step 3: Find the "Swap Partner" and Swap ---
    // Scan from the right to find the first element in the suffix
    // that is just larger than the pivot.
    for (int i = n - 1; i > pivotIndex; i--) {
      if (nums[i] > nums[pivotIndex]) {
        // This is our swap partner.
        swap(nums, pivotIndex, i);
        break; // We only need to swap once
      }
    }

    // --- Step 4: Reverse the Suffix ---
    // The suffix (everything after the pivot) is in descending order.
    // Reverse it to make it as small as possible (ascending order).
    reverse(nums, pivotIndex + 1, n - 1);
  }

  /**
   * Helper function to swap two elements in an array.
   */
  private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

  /**
   * Helper function to reverse a sub-array in place.
   */
  private void reverse(int[] nums, int start, int end) {
    while (start < end) {
      swap(nums, start, end);
      start++;
      end--;
    }
  }

}
/*
 * *****Dry Run*****
 * 🧠 Step-by-Step Code Explanation
 * Let's trace the code with nums = [1, 3, 5, 4, 2].
 * 
 * Step 1: Find the "Pivot"
 * Java
 * 
 * int pivotIndex = -1;
 * for (int i = n - 2; i >= 0; i--) {
 * if (nums[i] < nums[i + 1]) {
 * pivotIndex = i;
 * break;
 * }
 * }
 * We start a loop from the second-to-last element (i = n - 2) and move left.
 * 
 * i = 3 (nums[3] = 4): Is 4 < 2? No.
 * 
 * i = 2 (nums[2] = 5): Is 5 < 4? No.
 * 
 * i = 1 (nums[1] = 3): Is 3 < 5? Yes!
 * 
 * We found our pivot. We set pivotIndex = 1 and break the loop.
 * 
 * Result: pivotIndex = 1 (the element is 3). The suffix [5, 4, 2] is the
 * descending part.
 * 
 * with an arrow pointing to 3 as the pivot and a bracket over [5, 4, 2] labeled
 * 'descending suffix']
 * 
 * Step 2: Handle the Edge Case
 * Java
 * 
 * if (pivotIndex == -1) {
 * reverse(nums, 0, n - 1);
 * return;
 * }
 * pivotIndex is 1, which is not -1, so we skip this block.
 * 
 * (This block is only for arrays like [3, 2, 1], where no pivot would be found,
 * and the whole array would be reversed to [1, 2, 3]).
 * 
 * Step 3: Find the "Swap Partner" and Swap
 * Java
 * 
 * for (int i = n - 1; i > pivotIndex; i--) {
 * if (nums[i] > nums[pivotIndex]) { // nums[i] > 3
 * swap(nums, pivotIndex, i); // swap(nums, 1, i)
 * break;
 * }
 * }
 * We scan the suffix [5, 4, 2] from right to left to find the first number just
 * bigger than our pivot (3).
 * 
 * i = 4 (nums[4] = 2): Is 2 > 3? No.
 * 
 * i = 3 (nums[3] = 4): Is 4 > 3? Yes!
 * 
 * We call swap(nums, 1, 3).
 * 
 * The array [1, 3, 5, 4, 2] becomes [1, 4, 5, 3, 2].
 * 
 * We break the loop.
 * 
 * Step 4: Reverse the Suffix
 * Java
 * 
 * reverse(nums, pivotIndex + 1, n - 1);
 * Our array is now [1, 4, 5, 3, 2]. The prefix [1, 4] is correct, but we need
 * to make the suffix [5, 3, 2] as small as possible.
 * 
 * Since [5, 3, 2] is in descending order, reversing it will make it ascending
 * ([2, 3, 5]).
 * 
 * We call reverse(nums, 2, 4).
 * 
 * The reverse function swaps nums[2] (5) and nums[4] (2) -> [1, 4, 2, 3, 5].
 * 
 * The pointers move, start becomes 3, end becomes 3. start < end is false, and
 * the reverse loop stops.
 * 
 * Final Result: The nums array is now [1, 4, 2, 3, 5].
 */