import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/generate-parentheses/submissions/
 */
public class NumberOfParenthesis {

  public static void main(String[] args) {
    System.out.println(generateParenthesis(2));
  }

  static List<String> generateParenthesis(int n) {
    return generateParenthesis("(" ,n-1, n);
  }

  static List<String> generateParenthesis(String initialString, int open, int close) {
    List<String> list = new ArrayList<>();
    if (open == 0 && close == 0) {
      return Arrays.asList(initialString);
    }

    if (open > 0 && close >= open) {
      String newinitialString = initialString + "(";
      list.addAll(generateParenthesis(newinitialString ,open-1, close));
    }

    if (close > 0 && close >= open) {
      String newinitialString = initialString + ")";
      list.addAll(generateParenthesis(newinitialString ,open, close-1));
    }

    return list;
  }
}
