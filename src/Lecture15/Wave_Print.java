/*Printing array in wavy manner */

package Lecture15;

public class Wave_Print {
  public static void main(String[] args) {
    int [][] arr= {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16},{17,18,19,20}};
    wavePrint(arr);
  }

  public static void wavePrint(int[][] arr){
    //for printing even column
    for (int col = 0; col < arr[0].length; col++) {
      //if column is even
      if (col%2==0) {
        for (int row = 0; row < arr.length; row++) {
          System.out.print(arr[row][col]+" ");
        }
        System.out.println();
      }
      //if column is odd
      else{
        for (int row = arr.length-1; row >=0 ; row--) {
          System.out.print(arr[row][col]+" ");
        }
        System.out.println();
      }
    }
  }

}
