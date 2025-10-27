package Lecture23;

public class Count_SubSequence_Using_StaticVar {
  public static void main(String[] args) {
    String str = "abc";
    PrintSubSequence(str, "");
    System.out.println(count);
  }

  static int count = 0;

  public static void PrintSubSequence(String str, String ans) {
    if (str.length() == 0) {
      System.out.print(ans + " ");
      count++;
      return;
    }
    char ch = str.charAt(0);
    PrintSubSequence(str.substring(1), ans);
    PrintSubSequence(str.substring(1), ans + ch);
  }

}
