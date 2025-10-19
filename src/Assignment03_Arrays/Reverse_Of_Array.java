package Assignment03_Arrays;

import java.util.Scanner;

public class Reverse_Of_Array {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = sc.nextInt();
    }
    // reverse method modifies the array in place,
    // so we don't even need to assign it to a new variable.
    // int[] reversedArr = reverse(arr);

    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i] + " ");
    }

  }

  public static int[] reverse(int[] arr) {
    int left = 0;
    int right = arr.length - 1;
    while (left < right) {
      int temp = arr[left];
      arr[left] = arr[right];
      arr[right] = temp;
      left++;
      right--;
    }
    return arr;
  }

}
