package Lecture10;

import java.util.Scanner;

public class Arrays_Input {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the size of the array");
    int n = sc.nextInt();
    int [] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }
    Display(arr);
  }

public static void Display(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i]+ " ");
    }
  }

}
