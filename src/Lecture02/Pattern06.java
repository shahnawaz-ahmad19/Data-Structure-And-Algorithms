package Lecture02;


/*  
  for n=5
 * * * * *
    * * * *
        * * *
            * *
                *


 */

import java.util.Scanner;

public class Pattern06 {
  public static void main(String[] args) {
    System.out.println("Enter the number of rows!");
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int star = n;
    int row =1;
    int space = 0;
    while(row<=n){
      int i = 1;
      while(i<=space){
        System.out.print("  ");
        i++;
      }
      int j = 1;
      while(j<=star){
        System.out.print("* ");
        j++;
      }
      row++;
      star--;
      space+=2;
      System.out.println();
    }
  }

}
