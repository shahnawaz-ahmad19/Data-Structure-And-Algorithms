package Lecture11;

public class Bubble_Sort {
  public static void main(String[] args) {
    int[] arr = {2,13,-4,5,7};
    sort(arr);
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i]+" ");
    }
  }

  private static void sort(int[] arr) {
    //for running number of turns
    for (int turn = 1; turn < arr.length; turn++) {
      //for swapping the number in a particular turn
      for (int i = 0; i < arr.length-turn; i++) {
         while (arr[i]>arr[i+1]) {
          int temp = arr[i];
          arr[i] = arr[i+1];
          arr[i+1]=temp;

         }
      }
    }
  }

}
