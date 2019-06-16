import javafx.util.Pair;

public class LongestPalindromicSubstring {
  public static void main(String arg[]) {
    String test = "abcbe";
    LongestPalindromicSubstringSolution solution = new LongestPalindromicSubstringSolution();
    System.out.println(solution.longestPalindrome(test));
  }
}


class LongestPalindromicSubstringSolution {
  public String longestPalindrome(String s) {
    int maxLength = 0;
    String maxString = "";

   for(int i=0; i< s.length(); i++) {
     Pair<String, Integer> palindromeString = getPalindromeLengthForIndex(i, s);
     Pair<String, Integer> palindromeStringEven = getPalindromeLengthForIndexForEven(i, s);

     Pair<String, Integer> biggerPalindrome = palindromeString.getValue() > palindromeStringEven.getValue() ? palindromeString : palindromeStringEven;

      if (biggerPalindrome.getValue() > maxLength) {
        maxLength = biggerPalindrome.getValue();
        maxString = biggerPalindrome.getKey();
     }
   }

    return maxString;
  }

  private Pair<String, Integer> getPalindromeLengthForIndex(int index, String input) {
    int startIndex = index;
    int endIndex = index;
    int length = 1;
    while ((startIndex - 1) >= 0 && (endIndex + 1) < input.length()) {
      if (input.charAt(startIndex-1) == input.charAt(endIndex+1)) {
        startIndex--;
        endIndex++;
        length = length + 2;
      } else {
        break;
      }
    }
    return new Pair<>(input.substring(startIndex, endIndex+1), length);
  }

  private Pair<String, Integer> getPalindromeLengthForIndexForEven(int index, String input) {
    int startIndex = index;
    int endIndex = index + 1;
    int length = 0;

    if ((startIndex) >= 0 && (endIndex) < input.length()) {
      if (input.charAt(startIndex) == input.charAt(endIndex)) {
        length = length + 2;
      }
      else {
        return new Pair<>(input.substring(startIndex, endIndex), length);
      }
    } else {
      return new Pair<>(input.substring(startIndex, endIndex), length);
    }

    while ((startIndex - 1) >= 0 && (endIndex + 1) < input.length()) {
      if (input.charAt(startIndex-1) == input.charAt(endIndex + 1)) {
        startIndex--;
        endIndex++;
        length = length + 2;
      } else {
        break;
      }
    }
    return new Pair<>(input.substring(startIndex, endIndex + 1), length);
  }
}


