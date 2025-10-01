/*
 * Let X^k <= n, Find the maximum value of x for which the above equation holds true?
 * where k -> 3; n -> 87
 */

package Lecture13;

public class Kth_Root {
  public static void main(String[] args) {
    int n = 87;
    int k = 3;
    System.out.println(kthRoot(n,k));
  }

  private static int kthRoot(int n, int k) {
    int low = 1;
    int high = 87;
    int ans = 0;
    while (low<=high) {
      int mid = (low+high)/2;
      if(Math.pow(mid,k)<=n){ // mid^k<=n
        ans = mid;
        low= mid + 1; // To check maximum value 
      }
      else{
        high = mid - 1;
      }
    }
    return ans;
  }

}
