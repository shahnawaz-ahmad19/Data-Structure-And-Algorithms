package Lecture03;

/*  
 for n=7
      *
    *   *
  *       *
*           *
  *       *
    *   *
      *
 */

import java.util.Scanner;

public class Pattern20 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int star = 1;
    int row =1;
    int space1 = n/2; //for first space before star
    int space2 = -1; //for space between two stars
    while(row<=n){
      //for space printing
      int i = 1;
      while(i<=space1){
        System.out.print("  "); 
        i++;
      }
      //for star printing
      System.out.print("* ");

      //for space2 printing
      int j = 1;
      while(j<=space2){
        System.out.print("  ");
        j++;
      }
      // for printing second star in each row except first and last row
      if (row!=1 && row!=n) { //to avoid printing star in first and last row twice
        System.out.print("* ");
      }
      
      
      if (row<n/2+1) {
        star+=2;
        space1--;
        space2+=2;
      } else {
        star-=2;
        space1++;
        space2-=2;      
      }
      row++;
      System.out.println();
    
    }
    
  }

}
