package Lecture19;

import java.util.ArrayList;

public class ArrayLIst_Demo {
  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<>();
    System.out.println(list);
    System.out.println(list.size());
    list.add(10);
    list.add(20);
    list.add(30);
    list.add(40);
    list.add(50);
    System.out.println(list);
    list.add(2, -6);
    System.out.println(list);
    System.out.println(list.size());

    // get
    System.out.println(list.get(3));
    // set
    list.set(2, 100);
    System.out.println(list);

    // remove
    System.out.println(list.remove(2));
    System.out.println(list);

  }

}
