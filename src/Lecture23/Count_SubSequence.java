package Lecture23;

public class Count_SubSequence {
  public static void main(String[] args) {
    String str = "abc";
    System.out.println("\n" + PrintSubSequence(str, ""));
  }

  public static int PrintSubSequence(String str, String ans) {
    if (str.length() == 0) {
      System.out.print(ans + " ");
      return 1;
    }
    char ch = str.charAt(0);
    int a1 = PrintSubSequence(str.substring(1), ans);
    int b1 = PrintSubSequence(str.substring(1), ans + ch);
    return a1 + b1;
  }

}
