package Lecture03;

/*
 
           for n= 5
                                  1
                          2       3       4
                  5       6       7       8       9
          10      11      12      13      14      15      16
  17      18      19      20      21      22      23      24    25 
  
  
  
 */


import java.util.Scanner;

public class Pattern25 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int star = 1;
    int row =1;
    int space = n-1;
    int val = 1; // to print the value, here we take it ouside the loop to make it continue increasing
    while (row<=n) {
      //for space printing
      int i = 1;
      while (i<=space) {
        System.out.print("\t");
        i++;
      }
      //for star printing
      int j = 1;  
      while (j<=star) {
        System.out.print(val +"\t");
        val++;
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
