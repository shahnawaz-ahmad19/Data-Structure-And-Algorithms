package Lecture03;

/* 
          for n=3
          1
        2 3 2
      3 4 5 4 3
        2 3 2
          1
 
 */

import java.util.Scanner;

public class Pattern_Hard {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int star = 1;
    int row =1;
    int space = n-1;
    int val = 1; // it is used to remember the starting value of each row
    while(row<=2*n-1){
      //for printing space
      int i = 1;
      while(i<=space){
        System.out.print("  ");
        i++;
      }
      //for printing star
      int j = 1;
      int p = val; // p is used to print the value in each row and it starts from val which is updated after each row
      while (j<=star) {
        System.out.print(p+" ");
        //applying vertical mirror logic as we can the pattern is also mirrored vertically
        if(j<(star/2)+1){
          p++;
        }
        else{
          p--;
        }
        j++;
      }
      //preparation of next row
      //applying mirror logic
      if(row<n){
        star+=2;
        space--;
        val++;
    }
      else{
        star-=2;
        space++;
        val--;
      }
      row++;
      
      System.out.println();
    }
  }
}
