package Lecture11;

public class Insertion_Sort {
  public static void main(String[] args) {
    int[] arr = {2,13,-4,5,7};
    sort(arr);
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i]+" ");
    }
  }

  private static void sort(int[] arr) {
    //considering 1st element is always sorted i.e why loop starts from 1
    for (int i = 1; i < arr.length; i++) {
      int picked_card=arr[i]; //Hand picked card
      int j = i-1;
      while (j>=0 && arr[j]>picked_card) {
        arr[j+1] = arr[j];
        j--;
      }
      arr[j+1] = picked_card;
    }
  }

}
