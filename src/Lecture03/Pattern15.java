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

public class Pattern15 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int star = n;
    int row =1;
    int space = 0;
    while(row<=2*n-1){
      int i = 1;
      // print spaces
      while(i<=space){
        System.out.print("  ");
        i++;
      }
      // print stars
      int j = 1;
      while(j<=star){
        System.out.print("* ");
        j++;
      }
      //Next row preparation
      //Applying mirroring logic to upper half
      if(row<n){
        star--;
        space+=2;        
      }
      //Applying mirroring logic to lower half
      else{
        star++;
        space-=2;
      }
      row++;
      System.out.println();
    }
  }

}
