/*
 * Print all Divisors of a given Number

Problem Statement: Given an integer N, return all divisors of N.

A divisor of an integer N is a positive integer that divides N without leaving a remainder.
 In other words, if N is divisible by another integer without any remainder,
  then that integer is considered a divisor of N
 */
package Basic_Maths;

import java.util.ArrayList;
import java.util.Scanner;

public class Divisor_Of_A_Number {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    System.out.println(printDivisors(n));
  }

  public static ArrayList<Integer> printDivisors(int n) {
    ArrayList<Integer> list = new ArrayList<>();
    for (int i = 1; i <= Math.sqrt(n); i++) {
      if (n % i == 0) {
        // Add divisor i to the list
        list.add(i);
        // Add the counterpart divisor
        // if it's different from i
        if (n % i != i) {
          // Add the counterpart
          // divisor to the list
          list.add(n / i);
        }
      }
    }
    list.sort(null);
    return list;
  }

}
