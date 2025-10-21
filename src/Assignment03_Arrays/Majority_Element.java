/*
 * Given an array of size n, find the majority element.
 * The majority element is the element that appears more than n/2 times.

You may assume that the array is non-empty and the majority element always exist in the array.

Input Format
First line contains integer N (size of the array) followed by N more integers.

Constraints
1 <= n <= 5 * 104

Output Format
Majority Element of array

Sample Input
3
1 1 2
Sample Output
1
Explanation
Number of 1's in the array is more than 3/2 , Hence majority element is 1

*******HINTS********
If we sort the array, the majority element is guaranteed to be in a specific spot.

Think about n = 5. The majority element appears at least 3 times.

[1, 2, 1, 3, 1] -> Sorted: [1, 1, 1, 2, 3]

[2, 2, 1, 2, 3] -> Sorted: [1, 2, 2, 2, 3]

Think about n = 7. The majority element appears at least 4 times.

[1, 7, 7, 5, 7, 7, 3] -> Sorted: [1, 3, 5, 7, 7, 7, 7]

Do we see the pattern? Because the element takes up more than half the spaces,
 it must occupy the middle position. So, if you sort the array, what is the only index you need to check?
  ->we need to check at index n/2 after sorting the array.
  
 */

package Assignment03_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Majority_Element {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = sc.nextInt();
    }
    // Get the majority element
    int majorityElement = majorityElement(arr);
    System.out.println(majorityElement);

  }

  public static int majorityElement(int[] arr) {
    // 1. Sort the array
    Arrays.sort(arr);
    // 2. The majority element is now guaranteed to be in the middle
    return arr[arr.length / 2];
  }

}
