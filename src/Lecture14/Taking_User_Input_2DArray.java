package Lecture14;

import java.util.Scanner;

public class Taking_User_Input_2DArray {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the number of rows ");
    int m = sc.nextInt();
    System.out.println("Enter the number of column");
    int n = sc.nextInt();
    int [][] arr= new int[m][n];
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        arr[i][j]= sc.nextInt();
      }
    }
    Display(arr);
  }
  public static void Display(int [][] arr){
    
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[0].length; j++) {
        System.out.print(arr[i][j]+" ");
      }
      System.out.println();
    }

  }

}
