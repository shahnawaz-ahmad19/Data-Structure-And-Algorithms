package Lecture21;

public class Factorial {
  public static void main(String[] args) {
    int n = 5;
    System.out.println(factorial(n));
  }

  public static int factorial(int n) {
    if (n == 0 || n == 1) {
      return 1;
    }
    int fn = factorial(n - 1);
    return n * fn;
  }
}
