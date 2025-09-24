package Lecture09;

public class Linear_Search {
  public static void main(String[] args) {
    int [] arr ={2,3,4,5,-4,7,11};
    int item = 14;
    System.out.println(Searchitem(arr, item));
    
  }
  public static int Searchitem(int[] arr, int item){
    for(int i =0;i<arr.length; i++){
      if (arr[i]==item) {
        return item;
      }
    }
    return -1;
  }

}
