/*
 * Implementing our own Equal method
 */

package Lecture17;

public class Equals {
  public static void main(String[] args) {
    String str1 = "hello";
    String str2 = "hello";
    System.out.println(str1 == str2);
    System.out.println(Equals(str1, str2));

  }

  public static boolean Equals(String str1, String str2) {
    if (str1.length() != str2.length()) {
      return false;
    }
    if (str1 == str2) {
      return true;
    }
    for (int i = 0; i < str1.length(); i++) {
      if (str1.charAt(i) != str2.charAt(i)) {
        return false;
      }
    }
    return true;
  }

}
