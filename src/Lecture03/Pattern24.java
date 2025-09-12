package Lecture03;

/*
  for n=5
  
          1
        2 2 2
      3 3 3 3 3
    4 4 4 4 4 4 4
  5 5 5 5 5 5 5 5 5
 */

import java.util.Scanner;

public class Pattern24 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int star = 1;
    int row =1;
    int space = n-1;
    while (row<=n) {
      //for space printing
      int i = 1;
      while (i<=space) {
        System.out.print("  ");
        i++;
      }
      //for star printing
      int j = 1;
      
      while (j<=star) {
        System.out.print(row +" ");
        j++;
      }
      //Next row preparation
      row++;
      star+=2;
      space--;
      System.out.println();
    }
  }

}
