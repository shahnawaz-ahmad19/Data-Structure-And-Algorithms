package Lecture19;

import java.util.ArrayList;

public class ArrayList_Working {
  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<>();
    for (int i = 0; i < 5; i++) {
      list.add((i + 1) * 10);
    }
    System.out.println(list);

    // Normal for loop
    for (int i = 0; i < list.size(); i++) {
      System.out.print(list.get(i) + " ");
    }
    System.out.println();

    // for each loop
    for (int ele : list) {
      System.out.print(ele + " ");
    }
  }

}
