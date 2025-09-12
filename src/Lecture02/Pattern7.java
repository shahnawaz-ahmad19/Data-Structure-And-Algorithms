package Lecture02;

/*  
  for n=5
* * * * * 
*       * 
*       * 
*       * 
* * * * *
 */

import java.util.Scanner;

public class Pattern7 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int star = n;
    int row =1;
    int space = n-2;
    while (row<=n) {
      //for printing stars in 1st and last row if row=1 or row=n
      if (row == 1 || row == n) {
        int i = 1;
        while(i<=star){
          System.out.print("* ");
          i++;
        }
      }else{
        //for printing star  if row!=1 and row!=n
          System.out.print("* ");

          //for printing space
          int j = 1;
          while (j<=space) {
            System.out.print("  ");
            j++;  
          }

          //for printing star at the end of the row if row!=1 and row!=n
          System.out.print("* ");
        }  
        //next row preparation      
      row++;
      System.out.println();
      }
    }
  
  }


