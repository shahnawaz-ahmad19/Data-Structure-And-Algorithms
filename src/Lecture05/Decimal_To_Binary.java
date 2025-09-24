package Lecture05;

import java.util.Scanner;

public class Decimal_To_Binary {
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt(); // source base
    int sum=0;
    int mul = 1;
    while(n>0){
      int rem = n%2; //destination base
      sum = sum +rem*mul;
      mul = mul*10;
      n = n/2;
    }
    System.out.println(sum);
  }

}
