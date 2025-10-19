/*
 * Sort just 0 and 1
Input Format
A line containing N number of 0s and 1s Next line
 follows a long sequence of 0 and 1 seperated by space


Constraints
N will not exceed 10^7


Output Format
Sorted Sequence


Sample Input
7
1 0 0 1 1 0 1
Sample Output
0 0 0 1 1 1 1
 */

package Assignment03_Arrays;

import java.util.Scanner;

public class Sort_Zeros_And_Ones {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = sc.nextInt();
    }
    // Get the sorted squares array
    int[] sortedArr = SortZeroAndOne(arr);

    // Print the sorted array
    for (int i = 0; i < sortedArr.length; i++) {
      System.out.print(sortedArr[i] + " ");
    }

  }

  public static int[] SortZeroAndOne(int[] arr) {
    int zeroPointer = 0;
    int onePointer = arr.length - 1;

    while (zeroPointer < onePointer) {
      if (arr[zeroPointer] == 0) {
        zeroPointer++;
      } else if (arr[onePointer] == 1) {
        onePointer--;

      } else {
        // swap
        int temp = arr[zeroPointer];
        arr[zeroPointer] = arr[onePointer];
        arr[onePointer] = temp;
        zeroPointer++;
        onePointer--;
      }
    }
    return arr;
  }

}
