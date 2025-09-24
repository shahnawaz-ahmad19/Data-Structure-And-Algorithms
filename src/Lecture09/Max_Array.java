package Lecture09;

public class Max_Array {
  public static void main(String[] args) {
    int[] arr ={5,3,1,81,97};
    //System.out.println(maxElement(arr));
    //System.out.println(maxElement_2(arr));
    System.out.println(maxElement_3(arr));

  }

  public static int maxElement(int [] arr){
    int max = arr[0];
    for (int i = 1; i < arr.length; i++) {
      if (arr[i]>max) {
        max = arr[i];
      }
    }
    return max;
  }

  public static int maxElement_2(int [] arr){
    int max = Integer.MIN_VALUE; //-2^31
    //Integer.MAX_VALUE = 2^31 -1 
    for (int i = 0; i < arr.length; i++) {
      if (arr[i]>max) {
        max = arr[i];
      }
    }
    return max;
  }

  public static int maxElement_3(int [] arr){
    int max = Integer.MIN_VALUE; //-2^31
    //Integer.MAX_VALUE = 2^31 -1 
    for (int i = 0; i < arr.length; i++) {
      /* if (arr[i]>max) {
        max = arr[i];
      } */
     max=Math.max(arr[i], max);
    }
    return max;
  }


}
