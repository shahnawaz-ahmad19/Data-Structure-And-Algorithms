
/*
 * Given a 2D-Array , print the spiral
 * 1 2 3 4  8 13 17 21  20 19 18 14  10 5 6 7  12 16 15 11
 */
package Lecture15;

public class Spiral_Print {
  public static void main(String[] args) {
    int [][] arr= {{1,2,3,4},
                  {5,6,7,8},
                  {9,10,11,12},
                  {13,14,15,16}};
    Spiral(arr);
  }
  public static void Spiral(int [][] arr){
    int minRow = 0;
    int maxRow = arr.length-1;
    int minCol= 0;
    int maxCol = arr[0].length-1;
    int totalElement = arr.length*arr[0].length;
    int count = 0;



    while (count < totalElement) {
        for (int i = minCol; i <= maxCol && count < totalElement; i++) {
        System.out.print(arr[minRow][i]+" ");
        count++;
      }
      minRow++;
      for (int i = minRow; i <= maxRow && count < totalElement; i++) {
        System.out.print(arr[i][maxCol]+" ");
        count++;
      }
      maxCol--;
      for (int i = maxCol; i >= minCol && count < totalElement; i--) {
        System.out.print(arr[maxRow][i]+" ");
        count++;
      }
      maxRow--;
      for (int i = maxRow; i >= minRow && count < totalElement; i--) {
        System.out.print(arr[i][minCol]+" ");
        count++;
      }
      minCol++;
    }
  }

}
