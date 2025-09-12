package Lecture03;

/*
  for n=5
  
          1
        1 2 3
      1 2 3 4 5
    1 2 3 4 5 6 7
  1 2 3 4 5 6 7 8 9 

 */



import java.util.Scanner;

public class Pattern26 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int star = 1;
    int row =1;
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
        val++;
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
