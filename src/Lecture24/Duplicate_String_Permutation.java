package Lecture24;

public class Duplicate_String_Permutation {
  public static void main(String[] args) {
    String question = "abca";
    possiblePermutations(question, "");
  }

  public static void possiblePermutations(String question, String ans) {
    if (question.length() == 0) {
      System.out.println(ans + " ");
      return;
    }
    for (int i = 0; i < question.length(); i++) {
      char ch = question.charAt(i);
      boolean flag = false;
      for (int j = i + 1; j < question.length(); j++) {
        if (question.charAt(j) == ch) {
          flag = true;
          break;
        }
      }
      if (flag == false) {
        String str1 = question.substring(0, i);
        String str2 = question.substring(i + 1);
        possiblePermutations(str1 + str2, ans + ch);
      }
    }
  }

}
