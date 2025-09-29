package Lecture11;

public class Selection_Sort {
  public static void main(String[] args) {
    int[] arr = {2,13,-4,5,7};
    sort(arr);
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i]+" ");
    }
  }

  private static void sort(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      int mini =i; //Its a index not a value
      for (int j = i+1; j < arr.length; j++) {
        if(arr[j]<arr[mini]){
          mini = j;
        }
      }
      int temp = arr[i];
      arr[i] = arr[mini];
      arr[mini] = temp;
    }
  }

}
