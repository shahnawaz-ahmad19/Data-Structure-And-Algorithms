package Lecture22;

public class Fibonacci_Using_Recursion {
  public static void main(String[] args) {
    int n = 5;
    System.out.println(fibonacci(n));
  }

  public static int fibonacci(int n) {
    if (n == 0 || n == 1) {
      return n;
    }

    int fibo1 = fibonacci(n - 1);
    int fibo2 = fibonacci(n - 2);
    return fibo1 + fibo2;
  }

}
