package Lecture02;


/*  
 for n=5
* 
* * 
* * * 
* * * * 
* * * * * 

 */



import java.util.Scanner;

public class Pattern02 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int row = 1;
    int star = 1;
    while (row<=n) {
      int i = 1;
      while (i<=star){
        //Star printing
        System.out.print("* ");
        i++;
      }
      //Next row preparation
      row++;
      star++;
      System.out.println();
    }

  }

}
