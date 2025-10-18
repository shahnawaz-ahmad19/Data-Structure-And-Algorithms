package Lecture20;

public class SubArraySum_Of_Size_K {
  public static void main(String[] args) {
    int[] arr = { 2, 1, 3, 4, 5, 6, 7, 8, 9, 2, 3 };
    int k = 3;
    System.out.println(MaxSum_Of_Size_K(arr, k));
  }

  public static int MaxSum_Of_Size_K(int[] arr, int k) {
    // calculate sum of first k size window
    int sum = 0;
    int ans = 0;
    for (int i = 0; i < k; i++) {
      sum = sum + arr[i];
    }
    ans = sum; // initial ans
    // slide the window
    for (int i = k; i < arr.length; i++) {
      sum = sum + arr[i]; // add next element
      sum = sum - arr[i - k]; // remove first element of previous window
      ans = Math.max(ans, sum);// update ans
    }
    return ans;

  }

}
