package Lecture10;

import java.util.Scanner;

public class Reversing_Certain_Part_Of_Aarray {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the size of the array");
    int n = sc.nextInt();
    int [] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }
    System.out.println("Enter the starting index from where to want to reverse the array: ");
    int i = sc.nextInt();
    System.out.println("Enter the Ending index from where to want to reverse the array: ");

    int j = sc.nextInt();
    reverse(arr,i,j);
    Display(arr);
  }

  private static void Display(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i]+" ");
    }
  }

  private static void reverse(int[] arr ,int i, int j) {
    while (i<j) {
      int temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
      i++;
      j--;
    }
  }

}
