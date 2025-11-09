package Lecture26;

public class Tower_Of_Hanoi {
  public static void main(String[] args) {
    int n = 3;
    towerOfHanoi(n, "A", "B", "C");
  }

  public static void towerOfHanoi(int n, String source, String helper, String destination) {
    if (n == 0) {
      return;
    }
    towerOfHanoi(n - 1, source, destination, helper);
    System.out.println("Move " + n + "th from " + source + " to " + destination);
    towerOfHanoi(n - 1, helper, source, destination);
  }

}
