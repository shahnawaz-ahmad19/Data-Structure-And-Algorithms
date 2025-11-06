package Java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StreamAPI {
  public static void main(String[] args) {
    List<Object> list = new ArrayList<>();
    list.add("abc");
    list.add("bbc");
    list.add(54);
    list.add("kbc");
    list.add(89);
    // System.out.println(list);

    /*
     * list.stream()
     * .forEach(obj -> System.out.print(obj + " "));
     */
    // Retrieving and printing only strings
    /*
     * list.stream()
     * .filter(obj -> obj instanceof String)
     * .forEach(System.out::println);
     */
    // Retrieving and printing only Itegers
    /*
     * list.stream()
     * .filter(obj -> obj instanceof Integer)
     * .forEach(obj -> System.out.println(obj));
     */

    // Retrieving and printing only even Itegers
    /*
     * list.stream()
     * .filter(obj -> obj instanceof Integer)
     * .filter(obj -> (Integer) obj % 2 == 0)
     * .forEach(System.out::print);
     */

    List<Student> studentList = List.of(
        new Student(101, "S1", "Core Java", 6500),
        new Student(102, "S2", "Oracle", 2000),
        new Student(103, "S3", "HTML", 2000),
        new Student(104, "S4", "Adv Java", 3500),
        new Student(105, "S5", "JavaScript", 4500),
        new Student(106, "S6", "Core Java", 4500),
        new Student(106, "S6", "Core Java", 3500),
        new Student(106, "S6", "Core Java", 2500));

    // System.out.println(studentList);
    /*
     * studentList.stream()
     * .forEach(System.out::println);
     */
    /*
     * studentList.stream()
     * .filter(student -> student.getCourse().equals("Core Java"))
     * .forEach(System.out::println);
     */

    /*
     * studentList.stream()
     * .filter(student -> student.getCourse().equalsIgnoreCase("Core Java"))
     * .filter(student -> student.getFee() < 6500)
     * .forEach(System.out::println);
     */

    /*
     * studentList.stream()
     * .filter(student -> student.getCourse().equalsIgnoreCase("Core Java"))
     * .map(student -> student.getName())
     * .forEach(System.out::println);
     */

    List<String[]> stringArrayList = List.of(
        new String[] { "a", "b" },
        new String[] { "c", "d" },
        new String[] { "e", "f" },
        new String[] { "g", "h" });

    List<String> resList = stringArrayList.stream()
        .flatMap(sa -> Arrays.stream(sa))
        .toList();
    System.out.println(resList);
  }

}
