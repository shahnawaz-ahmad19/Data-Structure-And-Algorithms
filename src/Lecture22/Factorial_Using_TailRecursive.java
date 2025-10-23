package Lecture22;

public class Factorial_Using_TailRecursive {
  public static void main(String[] args) {
    int n = 5;
    System.out.println(factorial(n, 1));
  }

  public static int factorial(int n, int ans) {
    if (n == 0) {
      return ans;
    }
    return factorial(n - 1, ans * n);
  }

}
