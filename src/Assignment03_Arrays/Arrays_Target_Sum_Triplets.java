/*
* Q)Take as input N, the size of array. Take N more inputs and store that in an array. 
Take as input “target”, a number. Write a  function which prints all triplets of numbers which sum to target.


Input Format
First line contains input N.
Next line contains N space separated integers denoting the elements of the array.
The third line contains a single integer T denoting the target element.


Constraints
Length of Array should be between 1 and 1000.


Output Format
Print all the triplet present in the array in a new line each. The triplets must be printed as A, B and C where A,B and C are the elements of the triplet ( A<=B<=C) and all triplets must be printed in sorted order. Print only unique triplets.


Sample Input
9
5 7 9 1 2 4 6 8 3
10
Sample Output
1, 2 and 7
1, 3 and 6
1, 4 and 5
2, 3 and 5
Explanation
Array = {5, 7, 9, 1, 2, 4, 6 ,8 ,3}. Target number = 10. Find any three number in the given array which sum to target number.


 * *******The Intuition ******
The Critical First Step: Sort the Array
Almost every problem that asks for pairs, triplets, or quadruplets
 that sum to a target becomes much easier if you sort the input array first.

* ****Why?****
========
It allows us to use pointers to search in an organized way.

It helps us easily handle the output requirements (unique triplets, and A <= B <= C).

* ***Reduce the Problem:*********
==================
Instead of looking for three numbers (A + B + C = target) all at once, let's simplify.
Let's fix one number, A, and then look for the other two.

This means we can start a for loop that iterates through the array. The element arr[i] will be our A.

Now, for each arr[i], the problem is simpler: "Find a pair (B and C) in the rest of the array that sums to target - A."

The Two-Pointer Approach (for the "Find a Pair" sub-problem)

This is the key. For each arr[i], we can find the pair B and C very quickly in the sorted array.

Set up two pointers:
A left pointer, which starts right after i (at i + 1).

A right pointer, which starts at the very end of the array (arr.length - 1).

Now, you just need to move these pointers inward until they cross.

* *********The Algorithm Inside the Main Loop************
Imagine our main loop has picked a number arr[i]. Your left pointer is at i + 1 and your right pointer is at the end.

[ A, ... B, ......... C ]
  ^      ^            ^
  i     left         right

Calculate currentSum = arr[i] + arr[left] + arr[right].

Compare currentSum with your target:

* *****If currentSum == target:*********
 You found a triplet! Print it. Now, you need to find other possible pairs for arr[i],
 so you should move both pointers inward (left++ and right--).

* **********If currentSum < target:*********
 Your sum is too small. To make it bigger, you need to use a larger number.
 You can't change arr[i] or arr[right] (that's the biggest),
  so you must move the left pointer to the right (left++) to get a bigger B.

* **********If currentSum > target:********* 
Your sum is too big. To make it smaller, 
you must move the right pointer to the left (right--) to get a smaller C.

Handling Uniqueness: The sorting helps a lot here. If we find a triplet,
 and the next left element is the same as the current left element,
  we should skip it to avoid printing duplicate triplets.
   The same logic applies to your main loop for the i pointer.

By fixing one number and using the two-pointer technique on the rest of the array, we can find all the triplets efficiently.

* *****How to remove Duplicate triplets, lets understand this******
Imagine our sorted array is a line of people ordered by height.

arr = [1, 1, 2, 2, 2, 3, 4, 4] target = 7

You are finding teams of three (A, B, C) that sum to 7.

* 1. How to Skip Duplicate A (The i loop)
Your for loop picks person A.

i = 0: You pick the first person, A = 1.
 You look for all their possible teammates (B and C) and find, for example, (1, 2, 4). You print it.

i = 1: You move to the next person. Their height is also A = 1.

*The Problem: If you search for teammates for this person,
 you will find the exact same teams you just found (like 1, 2, 4). This will print a duplicate.

* The Solution: You add a simple rule: "If the person I'm about to check (arr[i]) is the same height as the person I just finished checking (arr[i-1]), I'll just skip them. I've already found all their teams."

That's what this code does:


if (i > 0 && arr[i] == arr[i - 1]) {
    continue; // "Skip this person, I've seen their height before."
}

*2. How to Skip Duplicate B and C (The while loop)
This is the same idea, but it happens after you find a match.

Let's say your A = 1 (from index 0). Your pointers are:

left (B) is at index 2, pointing at 2.

right (C) is at index 6, pointing at 4.

1 + 2 + 4 = 7. It's a match! You print 1, 2 and 4.

*The Problem: Now you need to find the next team. Your code says to do left++ and right--. But look what happens:

left moves to index 3, which is still 2.

right moves to index 5, which is 3.

1 + 2 + 3 = 6. This is not a match.

left++.

left moves to index 4, which is still 2.

right is still at index 5, which is 3.

1 + 2 + 3 = 6. Still not a match.

You're wasting time by re-checking the same B (2) over and over.

*The Solution: After you find a match (1, 2, 4), you need to skip all the other 2s.

The Logic: "I found a match with B = 2.
 Now, I'll keep moving my left pointer forward as long as it keeps pointing to a 2.
  I want to find the next person who has a different height."

* // Skip all other 'B's that are the same
while (left < right && arr[left] == arr[left + 1]) {
    left++;
}
* // Skip all other 'C's that are the same
while (left < right && arr[right] == arr[right - 1]) {
    right--;
}

* Q)Why We Use arr.length - 2 (The Loop Bound)

The reason is that i represents the index of the first element of our triplet (A).

After we pick arr[i], we need at least two more elements left in the array for our left (B) and right (C) pointers.

Let's look at the last few elements of the array:

... | arr[n-3] | arr[n-2] | arr[n-1] | (index)

n-3: last index for i

n-2: index for left

n-1: index for right

* What Happens if We Don't Stop at arr.length - 2?
Imagine our loop was for (int i = 0; i < arr.length; i++).

Case 1: i reaches arr.length - 2

i is at index n-2.

left starts at i + 1, which is n-1.

right starts at arr.length - 1, which is n-1.

The inner loop condition while (left < right) becomes while (n-1 < n-1). 
This is false. The loop never runs, so no triplets are found.

Case 2: i reaches arr.length - 1

i is at index n-1.

left starts at i + 1, which is n. This is out of bounds.

So, the last useful index i can be is arr.length - 3.

The loop condition i < arr.length - 2 ensures this. When i becomes arr.length - 2, 
the condition is false and the loop stops, because we've run out of elements to make a triplet.

 */

package Assignment03_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Arrays_Target_Sum_Triplets {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = sc.nextInt();
    }

    int targetSum = sc.nextInt();
    findTriplets(arr, targetSum);

  }

  public static void findTriplets(int[] arr, int targetSum) {
    Arrays.sort(arr);
    for (int i = 0; i < arr.length - 2; i++) {
      int left = i + 1;
      int right = arr.length - 1;
      while (left < right) {
        int currentSum = arr[i] + arr[left] + arr[right];
        if (currentSum == targetSum) {
          System.out.println(arr[i] + ", " + arr[left] + " and " + arr[right]);

          // --- Skip duplicate 'B's ---
          // Move 'left' forward as long as it's a duplicate
          while (left < right && arr[left] == arr[left + 1]) {
            left++;
          }

          // --- Skip duplicate 'C's ---
          // Move 'right' backward as long as it's a duplicate
          while (left < right && arr[right] == arr[right - 1]) {
            right--;
          }
          left++;
          right--;
        } else if (currentSum < targetSum) {
          left++;
        } else {
          right--;
        }
      }
    }
  }

}
