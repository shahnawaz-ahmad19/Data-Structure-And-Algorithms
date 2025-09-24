package Lecture05;

import java.util.Scanner;

public class Binary_To_Decimal {
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt(); // source base
    int sum = 0;
    int mul = 1;
    while (n > 0) {

      int rem = n%10; //destination base
      sum = sum + rem*mul;
      mul = mul*2;
      n = n/10;
  }
  System.out.println(sum);
  }

}
