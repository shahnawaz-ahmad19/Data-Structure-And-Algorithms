package Lecture22;

public class First_Occurence_OfElement {
  public static void main(String[] args) {
    int[] arr = { 2, 13, 7, 5, 3, 4, 5, 6, 3, 9, 3 };
    System.out.println(FirstIndex(arr, 0, 3));
  }

  public static int FirstIndex(int[] arr, int currentIndex, int item) {

    /*
     * We found the element!
     * Because we search from the start (0), this is the first occurrence.
     */
    if (arr[currentIndex] == item) {
      return currentIndex;
    }
    // Recursive Step: Ask the function to check the *next* index.
    return FirstIndex(arr, currentIndex + 1, item);
  }

}
