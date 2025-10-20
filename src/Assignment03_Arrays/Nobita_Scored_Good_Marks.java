/*
 * Nobita scored good marks in his previous test, so his mom gave him x candies.
 *  Now, he wants to distribute the candies amongst his n friends(including himself).
He wants to distribute the candies equally for which he can either ask
 her mom for more candies or can return her extra candies.

He will do this in such a way that the number of candies that he takes or
 returns to his mom is minimum. Can you help him?


Input Format
First line contains an integer T-denoting the number of test cases.
Next T lines contain two space separated integer x and n.

Constraints
1 <= T <= 10^5
1 <=x,n <=10^9

Output Format
Print a single integer equal to minimum candies returned.

Sample Input
3
14 4
12 4
10 3
Sample Output
2
0
1
Explanation
=============
In the 1st test case, Nobita can return 2 candies to his mom and then left with 12 candies 
that can be divided amongst his 4 friends(including him as well), each will get 3 candies each.
In 2nd test case , candies are already divisible by 4(Number of Friends). Hence the answer is 0.
In 3rd test case , he will return 1 candy and left with 9 candies that
 can be distributed. Hence the answer in this case is 1.
 */
package Assignment03_Arrays;

import java.util.Scanner;

public class Nobita_Scored_Good_Marks {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // Number of test cases
    int numberOfTestCases = sc.nextInt();

    for (int t = 1; t <= numberOfTestCases; t++) {
      long x = sc.nextLong(); // Number of candies
      long n = sc.nextLong(); // Number of friends

      System.out.println(minimumCandiesReturned(x, n));
    }

  }

  public static long minimumCandiesReturned(long x, long n) {
    // 1. Calculate the number of candies to RETURN.
    long returnCandies = x % n;

    // 2. Calculate the number of candies to TAKE.
    // This is how many more candies you need to reach the *next* multiple of n.
    // Example: 3 - 1 = 2 (add 2 to get 12)
    long additionalCandiesNeeded = n - returnCandies;

    // 3. Return the minimum of the two options.
    return Math.min(returnCandies, additionalCandiesNeeded);
  }

}
