package Lecture24;

public class String_Permutation {
  public static void main(String[] args) {
    String question = "abc";
    possiblePermutations(question, "");
  }

  public static void possiblePermutations(String question, String ans) {
    if (question.length() == 0) {
      System.out.print(ans + " ");
      return;
    }
    for (int i = 0; i < question.length(); i++) {
      char ch = question.charAt(i);
      String str1 = question.substring(0, i);
      String str2 = question.substring(i + 1);
      possiblePermutations(str1 + str2, ans + ch);
    }
  }

}
