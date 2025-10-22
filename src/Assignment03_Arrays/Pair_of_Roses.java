/*
 * Deepak has a limited amount of money that he can spend on his girlfriend. So he decides to buy two roses for her. Since roses are of varying sizes, their prices are different. Deepak wishes to completely spend that fixed amount of money on buying roses for her.
As he wishes to spend all the money, he should choose a pair of roses whose prices when summed up are equal to the money that he has.
Help Deepak choose such a pair of roses for his girlfriend.

NOTE: If there are multiple solutions print the solution that minimizes the difference between the prices i and j. After each test case, you must print a blank line.


Input Format
The first line indicates the number of test cases T.
Then, in the next line, the number of available roses, N is given.
The next line will have N integers, representing the price of each rose, a rose that costs less than 1000001.
Then there is another line with an integer M, representing how much money Deepak has.
There is a blank line after each test case.


Constraints
1≤ T ≤100
2 ≤ N ≤ 10000
Price[i]<1000001


Output Format
For each test case, you must print the message: ‘Deepak should buy roses whose prices are i and j.’, where i and j are the prices of the roses whose sum is equal do M and i ≤ j. You can consider that it is always possible to find a solution. If there are multiple solutions print the solution that minimizes the difference between the prices i and j.


Sample Input
2
2
40 40
80

5
10 2 6 8 4
10
Sample Output
Deepak should buy roses whose prices are 40 and 40.
Deepak should buy roses whose prices are 4 and 6.
Explanation
Find two such kinds of price of roses which has sum up to equal to Deepak's Money.

* ************INTUTION*************
Sort the Array: First, sort the array of rose prices in ascending order

we use a two-pointer technique.

Place one pointer (left) at the beginning of the sorted array (the cheapest rose) and another pointer (right) at the end (the most expensive rose).

Calculate the sum of the prices at the two pointers.

If the sum is equal to the money M, we've found a valid pair. Since the array is sorted, as the pointers move closer together, the difference between them will decrease. We store this pair and continue searching (by moving both pointers) to see if there's another pair even closer together.

If the sum is less than M, we need a larger sum, so we move the left pointer to the right.

If the sum is greater than M, we need a smaller sum, so we move the right pointer to the left.

We repeat this until left and right cross each other. The last valid pair we stored will be the one with the minimum difference.
 */
package Assignment03_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Pair_of_Roses {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // Read the number of test cases
    int T = sc.nextInt();
    for (int i = 0; i < T; i++) {
      // Read the number of roses
      int N = sc.nextInt();
      int[] prices = new int[N];

      for (int j = 0; j < prices.length; j++) {
        prices[j] = sc.nextInt();
      }

      // Read the amount of money Deepak has
      int M = sc.nextInt();
      // Call the function to get the result
      int[] result = findBestPair(prices, M);
      // Print the result
      System.out.println("Deepak should buy roses whose prices are " + result[0] + " and " + result[1] + ".");
      System.out.println();
    }

  }

  /**
   * @param prices The array of available rose prices.
   * @param M      The total money Deepak has.
   * @return An integer array of size 2 containing the prices [i, j] where i <= j.
   */
  public static int[] findBestPair(int[] price, int M) {
    // Sort the array to use the two-pointer technique
    Arrays.sort(price);

    // Sort the array to use the two-pointer technique
    int left = 0;
    int right = price.length - 1;
    int rose1 = 0;
    int rose2 = 0;

    while (left < right) {
      int sum = price[left] + price[right];
      if (sum == M) {
        // Found a valid pair. This is a potential answer.
        // Because the pointers are moving inwards,
        // any future pair with sum M will have a
        // smaller or equal difference.
        rose1 = price[left];
        rose2 = price[right];

        // Move both pointers to find the next possible pair
        left++;
        right--;
      } else if (sum < M) {
        // The sum is too small, need a larger number.
        // Move the left pointer to the right.
        left++;
      } else {
        // The sum is too large, need a smaller number.
        // Move the right pointer to the left.
        right--;
      }

    }
    return new int[] { rose1, rose2 };
  }
}
