package Lecture03;


/*
for n=5
        * * * * * 
      * * * * 
    * * * 
  * * 
* 
  * * 
    * * * 
      * * * * 
        * * * * * 
 */

import java.util.Scanner;

public class Pattern16 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int star = n;
    int row =1;
    int space = n-1;
    while(row<=2*n-1){
      //Space printing
      int i = 1;
      while (i<=space) {
        System.out.print("  ");
        i++;  
        
      }
      //Star printing
      int j = 1;
      while (j<=star) {
        System.out.print("* ");
        j++;
      } 
      //next row preparation
      if(row<n){
        star--;
        space--;
    }else
      {
        star++;
        space++;
      }
      row++;
      System.out.println();
    }
  }

}
