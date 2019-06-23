import java.util.Arrays;
import java.util.Comparator;

/**
 * Given an array of integers arr, write a function absSort(arr), that sorts the array according
 * to the absolute values of the numbers in arr. If two numbers have the same absolute value,
 * sort them according to sign, where the negative numbers come before the positive numbers.
 *
 * Examples:
 *
 * input:  arr = [2, -7, -2, -2, 0]
 * output: [0, -2, -2, 2, -7]
 */
class AbsSortSolution {

  static int[] absSort(int[] arr) {
    // your code goes here
    Integer[] wrappedLong = new Integer[arr.length];
    for (int i = 0; i < arr.length; i++) {
      wrappedLong[i] = arr[i];
    }

    Arrays.sort(wrappedLong, new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {

        if (Math.abs(o1) > Math.abs(o2)) {
          return 1;
        } else if (Math.abs(o1) == Math.abs(o2)) {
          if (o1 > o2) {
            return 1;
          } else if (o1 == o2) {
            return 0;
          }
          return -1;
        } else {
          return -1;
        }
      }
    });
    for (int i = 0; i < wrappedLong.length; i++) {
      arr[i] = wrappedLong[i];
    }
    return arr;
  }

  public static void main(String[] args) {
    int arr[] = {2, -7, -2, -2, -3};

    int result[] = absSort(arr);
    for (int i = 0; i < result.length; i++) {
      System.out.println(result[i]);
    }

  }
}
