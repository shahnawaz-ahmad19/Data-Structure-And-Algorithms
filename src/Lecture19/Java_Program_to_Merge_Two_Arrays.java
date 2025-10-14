/*
 * We have given two arrays, and our task is to merge them,
 *  and after merging, we need to put the result back into another array.
 */

package Lecture19;

import java.util.ArrayList;

public class Java_Program_to_Merge_Two_Arrays {
  public static void main(String[] args) {
    int[] arr1 = { 2, 3, 4, 5 };
    int[] arr2 = { 8, 3, 5, 3, 4, 7, 6 };
    AddNumbers(arr1, arr2);
  }

  public static void AddNumbers(int[] arr1, int[] arr2) {
    ArrayList<Integer> list = new ArrayList<>();
    int i = arr1.length - 1;
    int j = arr2.length - 1;
    int carry = 0;
    while (i >= 0 && j >= 0) {
      int sum = arr1[i] + arr2[j] + carry;
      list.add(sum % 10);
      carry = sum / 10;
      i--;
      j--;
    }
    while (i >= 0) {
      int sum = arr1[i] + carry;
      list.add(sum % 10);
      carry = sum / 10;
      i--;
    }
    while (j >= 0) {
      int sum = arr2[j] + carry;
      list.add(sum % 10);
      carry = sum / 10;
      j--;
    }
    if (carry > 0) {
      list.add(carry);
    }
    for (int k = list.size() - 1; k >= 0; k--) {
      System.out.print(list.get(k) + " ");
    }

  }

}
