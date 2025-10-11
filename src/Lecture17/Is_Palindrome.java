package Lecture17;

import java.util.Scanner;

public class Is_Palindrome {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String str = sc.next();
    System.out.println(isPalindrome(str));
  }

  public static boolean isPalindrome(String str) {
    int i = 0;
    int j = str.length() - 1;
    while (i < j) {
      if (str.toLowerCase().charAt(i) != str.toLowerCase().charAt(j)) {
        return false;
      }
      i++;
      j--;
    }
    return true;
  }

}
