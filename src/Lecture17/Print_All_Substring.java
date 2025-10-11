package Lecture17;

public class Print_All_Substring {
  public static void main(String[] args) {
    String str = "nitin";
    printAllSubstring(str);
  }

  public static void printAllSubstring(String str) {
    for (int i = 0; i < str.length(); i++) {
      for (int j = i + 1; j <= str.length(); j++) {
        System.out.print(str.substring(i, j) + " ");
      }
    }
  }

}
