package Lecture17;

public class Comparing_String_Lexicographically {
  public static void main(String[] args) {
    String str1 = "abc";
    String str2 = "agc";
    System.out.println(compareTo(str1, str2));
  }

  private static int compareTo(String str1, String str2) {
    if (str1 == str2) {
      return 0;
    }
    for (int i = 0; i < Math.min(str1.length(), str2.length()); i++) {
      if (str1.charAt(i) != str2.charAt(i)) {
        return str1.charAt(i) - str2.charAt(i);
      }
    }
    return str1.length() - str2.length(); // if one string is a prefix of another lets say one string is present in
                                          // another string
                                          // Ex: Raj and Rajat then Raj is smaller than Rajat because Raj is prefix of
                                          // Rajat

  }

}
