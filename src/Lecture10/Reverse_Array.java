package Lecture10;

import java.util.Scanner;

public class Reverse_Array {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the size of the array");
    int n = sc.nextInt();
    int [] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }
    reverse(arr);
    Display(arr);
  }

  private static void Display(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i]+ " ");
    }
  }

  private static void reverse(int[] arr) {
    int i =0;
    int j = arr.length-1;
    while (i<j) {
      int temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
      i++;
      j--;
    }
  }

}
