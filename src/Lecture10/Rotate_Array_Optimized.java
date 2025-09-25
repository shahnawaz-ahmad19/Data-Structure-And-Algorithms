package Lecture10;

public class Rotate_Array_Optimized {
  public static void main(String[] args) {
    int [] arr = {1,2,3,4,5,6,7};
    int k = 3;
    Rotate(arr, k);
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i]+ " ");
    }
  }

  public static void Rotate(int[] arr, int k) {
    int n = arr.length;
    k = k%n;
    Reverse(arr, n-k, n-1); //for reversing last k's element
    Reverse(arr , 0, n-1); //for rotating whole array
    Reverse(arr,  k, n-1);// for rotating last elements other than k's elements

  }

  public static void Reverse(int [] arr, int i , int j){
    while (i<j) {
      int temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
      i++;
      j--;
    }
  }


}
