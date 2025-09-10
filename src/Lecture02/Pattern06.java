package Lecture02;

import java.util.Scanner;

public class Pattern06 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int star = n;
    int row =1;
    int space = 0;
    while(row<=n){
      int i = 1;
      while(i<=space){
        System.out.print(" "+"\t");
        i++;
      }
      int j = 1;
      while(j<=star){
        System.out.print("*"+"\t");
        j++;
      }
      row++;
      star--;
      space+=2;
      System.out.println();
    }
  }

}
