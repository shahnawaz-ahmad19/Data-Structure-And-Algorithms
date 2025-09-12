package Lecture03;

/*  
for n=7
* * * * * * *
* * *   * * *
* *       * *
*           *
* *       * *
* * *   * * *
* * * * * * *                               
 */
import java.util.Scanner;

public class Pattern19 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int star = n-3;
    int row =1;
    int space = -1;
    while(row<=n){
      //for star printing
      int i = 1;
      while(i<=star){
        System.out.print("* ");
        i++;
      }
      //for space printing
      int j = 1;
      while(j<=space){    
        System.out.print("  ");
        j++;
      }
      //for star printing
      int k = 1;  
      if(row==1 || row==n){
        k=2;
      }
      while(k<=star){
        System.out.print("* ");
        k++;
      }
      if(row<n/2+1){
        star--;
        space+=2;
      }else{
        star++;
        space-=2;
      }
      row++;
      System.out.println();
    }
  }

}
