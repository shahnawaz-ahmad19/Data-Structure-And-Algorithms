package Assignment01_Pattern;

import java.util.Scanner;

public class Pascal_Triangle_Pattern03 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int row = 0;
    int star = 1;
    while(row<n){
      //for printing stars
      int i = 0;
      int ncr = 1;
      while(i<star){
        System.out.print(ncr+"\t");
        ncr = (ncr*(row - i)/(i+1));
        i++;
      }
      //for preparation of next row
      row++;
      star++;
      System.out.println();
    }

  }

}
