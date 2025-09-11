package Lecture03;

/*
 for n=7
      *
    * * *
  * * * * *
* * * * * * *
  * * * * *
    * * *
      *
 */
import java.util.Scanner;

public class Pattern18 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int star = 1;
    int row =1;
    int space = n-4;
    while (row<=n) {
      //printing space
      int i = 1;
      while(i<=space){
        System.out.print("  ");
        i++;
      }
      //printing star
      int j = 1;
      while (j<=star) {
        System.out.print("* ");
        j++;
      }
      //next row preparation
      if (row<n/2+1) {
        space--;
        star+=2;
      }else{
        space++;
        star-=2;
      }
      row++;
      System.out.println();
    }
  }

}
