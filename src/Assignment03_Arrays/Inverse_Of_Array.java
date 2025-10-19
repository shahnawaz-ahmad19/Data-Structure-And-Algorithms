/*
 * Take as input N, a number. Take N more inputs and store that in an array.
 *  Write a recursive function which inverses the array. Print the values of inverted array
Input Format
Enter a number N and take N more inputs

Constraints
None

Output Format
Display the values of the inverted array in a space separated manner


Sample Input
5
0 2 4 1 3
Sample Output
0 3 1 4 2

****EXPLANATION****
Inverse is Simply swapping the value of the array with the value at that index.

*Algo***

1).Create a new Array say narr and original array is arr.
2).now at the arr[i]th index of narr save the ith value.
   (previously i is the index and arr[i] is the value bt now arr[i] is the index and i is the value.)
3) return new array.
 */
package Assignment03_Arrays;

import java.util.Scanner;

public class Inverse_Of_Array {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = sc.nextInt();
    }
    // Get the inverted array
    int[] invertedArr = inverse(arr);

    // Print the inverted array
    for (int i = 0; i < invertedArr.length; i++) {
      System.out.print(invertedArr[i] + " ");
    }
  }

  public static int[] inverse(int[] arr) {

    int[] narr = new int[arr.length];

    for (int i = 0; i < arr.length; i++) {

      narr[arr[i]] = i;
    }

    return narr;
  }

}
