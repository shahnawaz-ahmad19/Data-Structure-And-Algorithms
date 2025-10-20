package Assignment03_Arrays;

import java.util.Scanner;

public class How_Many_Questions {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    // read the number of problem to be solved
    int n = sc.nextInt();

    int problenmSolved = 0;
    for (int i = 1; i <= n; i++) {
      int petya = sc.nextInt();
      int vasya = sc.nextInt();
      int tonya = sc.nextInt();

      // Call the function to make the decision
      if (howManyQuestions(petya, vasya, tonya)) {
        problenmSolved++;
      }
    }
    System.out.println(problenmSolved);
  }

  public static boolean howManyQuestions(int petya, int vasya, int tonya) {
    int confidenceSum = petya + vasya + tonya;
    if (confidenceSum >= 2) {
      return true;
    } else
      return false;
  }

}
