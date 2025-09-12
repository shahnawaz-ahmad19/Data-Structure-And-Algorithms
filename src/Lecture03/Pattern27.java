package Lecture03;

/*
  for n=5
  
          1
        1 2 1
      1 2 3 2 1
    1 2 3 4 3 2 1
  1 2 3 4 5 4 3 2 1  

 */

import java.util.Scanner;

public class Pattern27 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int star = 1;
    int row = 1;
    int space = n-1;
  
    while (row<=n) {
      //for space printing
      int i = 1;
      while (i<=space) {
        System.out.print("\t");
        i++;
      }
      //for star printing
      int j = 1;  
      int val = 1; // This val is used to print numbers in each row starting from 1 every time
      while (j<=star) {
        System.out.print(val +"\t");
        //Applying vertical mirroring concept here as we can see the pattern is vertically mirrored
        if (j<(star/2)+1) {
          val++;
        } else {
          val--;    
        }
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
