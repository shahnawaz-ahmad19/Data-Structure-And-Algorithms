package Lecture08;


import java.util.Scanner;

public class ArmstrongNumber {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    System.out.println(isArmstrong(n));

  }
  public static boolean isArmstrong(int n){
    int d = countOfDigit(n);
    int sum = 0;
    int p = n;
    while(n>0){
      int rem = n%10;
      sum = (int) (sum + Math.pow(rem, d));
      n = n/10;
    }
    if (sum==p) {
      return true;
    }else
      return false;

  }
  public static int countOfDigit(int n){
    int count = 0;
    while (n>0) {
      count++;
      n = n/10;
  }
  return count;

}
}
  
