package Lecture04;

import java.util.Scanner;

public class Sum_Of_Digits {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int sum = 0;
    while(n>0){
      int remainder= n%10;
      sum = sum + remainder;
      n=n/10;
  }
  System.out.println("Sum of digits is "+sum);
}

}
