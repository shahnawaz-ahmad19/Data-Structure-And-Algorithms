package Lecture04;

import java.util.Scanner;

public class Fibonacci {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n  = sc.nextInt();
    long a = 0;
    long b = 1;
    for(int i = 1; i<=n; i++){
      long c = a + b;
      a = b;
      b = c;
    }
    System.out.println(n+ "th fibonacci number is "+a);
  }

}
