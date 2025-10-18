package Lecture21;

public class PowerExample {
  public static void main(String[] args) {
    int x = 4;
    int n = 5;
    System.out.println(power(x, n));
  }

  public static int power(int x, int n) {
    // Base Condition: The stop sign
    if (n == 0) {
      return 1;
    }
    // Recursive Step: Call itself with a smaller problem
    int ans = power(x, n - 1);
    return x * ans;
  }

}
