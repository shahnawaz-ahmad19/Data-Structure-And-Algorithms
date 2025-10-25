/*
 * 75. Sort Colors
Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

You must solve this problem without using the library's sort function.

 

Example 1:
Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]

Example 2:
Input: nums = [2,0,1]
Output: [0,1,2]
 

Constraints:
n == nums.length
1 <= n <= 300
nums[i] is either 0, 1, or 2.

* ********INTUTION**********

Think of the array as a big shelf you need to organize. You have three types of items: 🔴 (0 - Red), ⚪ (1 - White), and 🔵 (2 - Blue).

You need to sort them on the shelf so all the 🔴 are on the left, all ⚪ are in the middle, and all 🔵 are on the right.

To do this, you'll use three "fingers" (our pointers):

low: Your left hand. It points to the spot where the next 🔴 should go. Everything to the left of this hand is already a 🔴.

high: Your right hand. It points to the spot where the next 🔵 should go. Everything to the right of this hand is already a 🔵.

mid: Your main working finger. This is the "Explorer." It scans the shelf from left to right, picking up each item and deciding what to do with it.

The space between your left hand (low) and mid is where the ⚪ items will live. The space between mid and your right hand (high) is the "Unknown" or "Unsorted" part of the shelf.

The Goal: Your mid "Explorer" finger needs to check every item in the "Unknown" zone until the "Unknown" zone is empty (i.e., mid passes high).

The 3 Simple Rules for "The Explorer" (mid)
As your mid finger moves along the shelf, it only has three rules:

Rule 1: If mid finds a 🔴 (0):

This 🔴 is in the wrong place! It belongs at the low position.

Action: Swap the 🔴 at mid with whatever is at low.

Now that you've put a 🔴 in its correct spot, you can move both your low hand and your mid finger one step to the right.

Rule 2: If mid finds a ⚪ (1):

This ⚪ is already in the right section! (It's supposed to be in the middle, after the reds).

Action: Leave it alone. Just move your mid finger one step to the right to check the next item.

Rule 3: If mid finds a 🔵 (2):

This 🔵 is in the wrong place! It belongs at the high position.

Action: Swap the 🔵 at mid with whatever is at high.

Now that you've put a 🔵 in its correct spot, you can move your high hand one step to the left.

Crucially: Do NOT move your mid finger. Why? Because the item you just swapped from the high position could be a 🔴 or a ⚪, and it still needs to be processed by mid.

Step-by-Step Walkthrough
Let's trace your example: nums = [2, 0, 2, 1, 1, 0]

Start: low = 0 mid = 0 high = 5

  L,M          H
  ↓ ↓          ↓
[ 2, 0, 2, 1, 1, 0 ]
Step 1:

mid is at index 0. nums[mid] is 2 (a 🔵).

Rule 3: It's a 🔵. Swap nums[mid] with nums[high].

Swap nums[0] with nums[5].

Move high to the left.

  L,M       H
  ↓ ↓       ↓
[ 0, 0, 2, 1, 1, 2 ]
 
Step 2:

mid is still at index 0. nums[mid] is 0 (a 🔴).

Rule 1: It's a 🔴. Swap nums[mid] with nums[low].

Swap nums[0] with nums[0] (no change).

Move low right. Move mid right.

     L,M    H
     ↓ ↓    ↓
[ 0, 0, 2, 1, 1, 2 ]
Step 3:

mid is at index 1. nums[mid] is 0 (a 🔴).

Rule 1: It's a 🔴. Swap nums[mid] with nums[low].

Swap nums[1] with nums[1] (no change).

Move low right. Move mid right.

        L,M  H
        ↓ ↓  ↓
[ 0, 0, 2, 1, 1, 2 ]
Step 4:

mid is at index 2. nums[mid] is 2 (a 🔵).

Rule 3: It's a 🔵. Swap nums[mid] with nums[high].

Swap nums[2] with nums[4].

Move high to the left.

        L,M H
        ↓ ↓ ↓
[ 0, 0, 1, 1, 2, 2 ]
Step 5:

mid is still at index 2. nums[mid] is 1 (a ⚪).

Rule 2: It's a ⚪. It's happy!

Move mid to the right.

        L  M,H
        ↓  ↓ ↓
[ 0, 0, 1, 1, 2, 2 ]
Step 6:

mid is at index 3. nums[mid] is 1 (a ⚪).

Rule 2: It's a ⚪. It's happy!

Move mid to the right.

        L   H  M
        ↓   ↓  ↓
[ 0, 0, 1, 1, 2, 2 ]
Step 7:

The loop condition mid <= high is now 4 <= 3, which is FALSE.

The loop stops.

Final Result: [0, 0, 1, 1, 2, 2]

 */
package Arrays_MediumProblem;

import java.util.ArrayList;
import java.util.Arrays;

public class Sort_Colors {
  public static void main(String[] args) {
    int[] arr = { 0, 2, 1, 2, 0, 1 };
    sortColors(arr);
    System.out.println("After sorting:");
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();

  }

  /**
   * Sorts an array containing 0s, 1s, and 2s in-place.
   * This implementation uses the Dutch National Flag algorithm (3-way
   * partitioning).
   */
  public static void sortColors(int[] nums) {
    // [0...low-1] <- All 0s
    // [low...mid-1] <- All 1s
    // [mid...high] <- The "unknown" or "unsorted" section we are processing
    // [high+1...n-1] <- All 2s
    int low = 0;
    int mid = 0;
    int high = nums.length - 1;
    // Loop as long as there are "unknown" elements to process
    while (mid <= high) {

      if (nums[mid] == 0) {
        // We found a 0. Swap it with the element at 'low'.
        swap(nums, low, mid);
        low++;
        mid++;
      } else if (nums[mid] == 1) {
        // We found a 1. It's already in the correct partition.
        // Just move 'mid' to check the next element.
        mid++;
      } else {
        // We found a 2. Swap it with the element at 'high'.
        swap(nums, mid, high);
        high--;
      }
    }

  }

  // Helper function to swap two elements in an array.
  public static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

}
