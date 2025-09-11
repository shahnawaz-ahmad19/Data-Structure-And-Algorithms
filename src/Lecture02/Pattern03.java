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

public class Pattern03 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int star = n;
    int row =1;
    while (row<=n) {
      int i = 1;
      while (i<=star) {
        System.out.print("* ");
        i++;
      }
      row++;
      star--;
      System.out.println();
    }
  }

}
