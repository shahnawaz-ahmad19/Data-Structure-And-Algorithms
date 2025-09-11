package Lecture02;


/*  
                                *
                        *       *
                *       *       *
        *       *       *       *
*       *       *       *       *
 */


import java.util.Scanner;

public class Pattern04 {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int star = 1;
    int row =1;
    int space = n-1;
    while (row<=n) {
      //for space
      int i = 1;
      while (i<=space) {
        System.out.print(" "+"\t");
        i++;
      }
      //for printing star
      int j = 1;
      while (j<=star){
        System.out.print("*"+"\t");
        j++;
      }
      //next row preparation
      row++;
      star++;
      space--;
      System.out.println();
      
    }

  }
}
