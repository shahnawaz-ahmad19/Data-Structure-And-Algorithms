package Lecture03;

/*
for n=5
        * 
      * *
    * * *
  * * * *
* * * * *
  * * * *
    * * * 
      * *
        *  
 */

import java.util.Scanner;

public class Pattern14 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int star = 1;
    int row =1;
    int space = n-1;
    while(row<=2*n-1){
      //space printing
      int j = 1;
      while(j<=space){
        System.out.print("  ");
        j++;
      }
      //star printing
      int i = 1;
      while(i<=star){
        System.out.print("* ");
        i++;
      }
      //next row preparation
      //mirroring the pattern 
      if(row<n){
        star++; 
        space--;      
      }else{
        star--;
        space++;
      } 
      row++;
      System.out.println();
    }
  }

}
