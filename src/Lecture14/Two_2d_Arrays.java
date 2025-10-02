package Lecture14;

import java.util.Scanner;

public class Two_2d_Arrays {
  public static void main(String[] args) {
    int[][] arr=new int[3][4];
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
