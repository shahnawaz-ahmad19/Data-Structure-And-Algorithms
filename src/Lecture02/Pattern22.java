package Lecture02;

/* 
For n=5
* * * * * * * * *
* * * *   * * * *
* * *       * * *
* *           * *
*               *

 */

import java.util.Scanner;

public class Pattern22 {
  public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int star = n;
    int row = 1;
    int space = -1;
    while (row<=n) {
      //for star
      int i = 1;
      if (row==1) {
        i=2;        
      }
      while(i<=star){
        System.out.print("* ");
        i++;
      }
      //for space printing
      int j = 1;
      while(j<=space){
        System.out.print("  ");
        j++;
      }
      //again for printing star
      int k = 1;    
      while(k<=star){
        System.out.print("* ");
        k++;
      }
      System.out.println();
      star--;
      space+=2;
      row++;
      
    }
  }

}
