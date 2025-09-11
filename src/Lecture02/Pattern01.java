package Lecture02;

/*
for n=5  
* * * * * 
* * * * * 
* * * * * 
* * * * * 
* * * * *
 */

import java.util.Scanner;

public class Pattern01 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int row = 1;
    int star = n;
    while(row<=n){
      int i = 1;
      //printing star
      while(i<=star){
        System.out.print("* ");
        i++;
      }
      row++;
      System.out.println();
    }
    
  }

}
