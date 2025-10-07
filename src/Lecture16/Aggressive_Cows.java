/*
 * Aggressive Cows
Given an array stalls[] representing the positions of stalls and an integer k denoting the number of aggressive cows, place the cows in the stalls such that the minimum distance between any two cows is as large as possible. Return this maximum possible minimum distance.

Examples: 

Input: stalls[] = [1, 2, 4, 8, 9], k = 3
Output: 3
Explanation: We can place cow 1 at position 1, cow 2 at position 4 and cow 3 at position 9. So, the maximum possible minimum distance between two cows is 3.

Input: stalls[] = [6, 7,  9, 11, 13, 15], k = 4
Output: 2
Explanation: We can place cow 1 at position 6, cow 2 at position 9, cow 3 at position 11 and cow 4 at position 15. So, the maximum possible minimum distance between two cows is 2.
 */
package Lecture16;

import java.util.Arrays;
import java.util.Scanner;

public class Aggressive_Cows {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the number of stall ");
    int numberOfStall = sc.nextInt();
    System.out.println("Enter the number of cows ");
    int numberOfCows = sc.nextInt();
    int[] stall = new int[numberOfStall];
    for (int i = 0; i < stall.length; i++) {
      stall[i] = sc.nextInt();
    }
    Arrays.sort(stall);
    System.out.println(minimumDistance(stall, numberOfCows));
  }

  public static int minimumDistance(int[] stall, int numberOfCows) {
    int low = stall[0];
    int high = stall[stall.length - 1];
    int ans = 0;
    while (low <= high) {
      int mid = (low + high) / 2;
      if (isItPossible(stall, numberOfCows, mid) == true) {
        ans = mid;
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return ans;
  }

  public static boolean isItPossible(int[] stall, int numberOfCows, int mid) {
    int lastPosition = stall[0]; // first cow placed at first stall
    int cowPlaced = 1; // we placed the 1st cow
    for (int i = 1; i < stall.length; i++) {
      if (stall[i] - lastPosition >= mid) {
        cowPlaced++; // placing the other cow if above condition satisfies
        lastPosition = stall[i]; // updating the last position
      }
      if (cowPlaced == numberOfCows) {
        return true;
      }
    }
    return false;

  }

}
