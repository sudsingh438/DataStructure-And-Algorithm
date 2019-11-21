import java.util.Arrays;
import java.util.HashSet;

public class MinPositiveSolution {




  public static void main(String[] args) {
    int a[] = {1,4, -1,3, 2};
    System.out.print(solution(a));

    System.out.print(solution2("azzddee"));
  }

  public static int solution(int[] A) {

    HashSet<Integer> visited = new HashSet<>();
    // write your code in Java SE 8
      if (A == null || A.length == 0) {
        return 0;
      }
      int nodeCount = 1;
      int index = 0;
      while(A[index] != -1 && !visited.contains(index)) {
        visited.add(index);
        nodeCount++;
        index = A[index];
      }

      return nodeCount;
  }


  static String solution2(String S) {
    int[] occurrences = new int[26];

    char best_char = 'a';
    int  best_res  = 0;

    for (char ch : S.toCharArray()) {
      occurrences[ch - 'a']++;
      if (occurrences[ch - 'a'] >= best_res) {
        best_char = (char)((int)'a' + ch - 'a');
        best_res  = occurrences[ch - 'a'];
      }
    }


//
//    for (int i = 1; i < 26; i++) {
//      if (occurrences[i] > best_res) {
//        best_char = (char)((int)'a' + i);
//        best_res  = occurrences[i];
//      }
//    }

    return Character.toString(best_char);
  }
}
