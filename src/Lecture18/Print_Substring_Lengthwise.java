package Lecture18;

public class Print_Substring_Lengthwise {
  public static void main(String[] args) {
    String str = "83415";
    printSubstring(str);

  }

  public static void printSubstring(String str) {
    for (int length = 0; length <= str.length(); length++) {
      for (int j = length; j <= str.length(); j++) {
        int i = j - length;
        System.out.print(str.substring(i, j) + " ");
      }
    }
  }

}
