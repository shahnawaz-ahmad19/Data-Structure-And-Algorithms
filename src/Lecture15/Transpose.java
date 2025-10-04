/*
 * Find the transpose of the given matrix, do not create a new array for this operation
 */
package Lecture15;

public class Transpose {
  public static void main(String[] args) {
    int [][] arr= {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};
    Display_Transpose(arr);
    for (int row = 0; row < arr.length; row++) {
      for (int col = 0; col < arr[0].length; col++) {
        System.out.print(arr[row][col]+" ");
      }
      System.out.println();
    }
    
  }

  public static void Display_Transpose(int[][] arr) {
    for (int row = 0; row < arr.length; row++) {
      for (int col = row+1; col < arr[0].length; col++) {
        int temp = arr[row][col];
        arr[row][col] = arr[col][row];
        arr[col][row] = temp;
      }
    }
  }

}
