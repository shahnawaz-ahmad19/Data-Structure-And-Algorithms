package Lecture22;

public class Subsequence_Using_Recursion {
  public static void main(String[] args) {
    String str = "abc";
    PrintSubSequence(str, "");
  }

  public static void PrintSubSequence(String str, String ans) {
    if (str.length() == 0) {
      System.out.print(ans + " ");
      return;
    }
    char ch = str.charAt(0);
    PrintSubSequence(str.substring(1), ans);
    PrintSubSequence(str.substring(1), ans + ch);
  }

}
