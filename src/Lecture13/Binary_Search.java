package Lecture13;

public class Binary_Search {
  public static void main(String[] args) {
    int[] arr= {2,3,5,6,7,8,9,11,13,15,18};
    int target = 11; //element to search for
    int result = search(arr, target);
    System.out.println(result);
  }

  private static int search(int[] arr, int target) {
    int low = 0; // starting index of the array
    int high = arr.length-1; //ending index of the array
    while (low<=high) {
      int mid = (low+high)/2;
      if (arr[mid]==target) {
        return mid;
      }
      else if (arr[mid]>target) {
        high = mid-1;
      }
      else{
        low = mid+1;
      }

    }
    return -1;
  }

}
