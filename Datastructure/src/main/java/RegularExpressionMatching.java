import java.util.Arrays;

public class RegularExpressionMatching {
  public static void main(String[] args) {
    RegularExpressionMatchingSolution solution = new RegularExpressionMatchingSolution();
    System.out.println(solution.isMatch("mississippi", "mis*is*p*."));

  }

}


class RegularExpressionMatchingSolution {
  public boolean isMatch(String s, String p) {
    return isMatch(s, p, 0, 0);
  }

  private boolean isMatch(String s, String p, int i, int j) {
    //     if (isFirstCharacterStar) {
    //
    //     }
    //     else {
    //
    //     }

    if (j == p.length() && i == s.length()) {
      return true;
    }

    if (j != p.length() && i == s.length() ) {
      return false;
    }

    if (j == p.length() && i != s.length() ) {
      return false;
    }

    if (p.charAt(j) == '*' && (p.charAt(j - 1) == s.charAt(i) || p.charAt(j-1) == '.' || (p.charAt(j - 1) == s.charAt(i-1)))){
        boolean result = isMatch(s, p, i + 1, j + 1);
        boolean result1 = isMatch(s, p, i + 1, j);
        boolean result2 = false;
        if (p.charAt(j - 1) == s.charAt(i-1)) {
          result2 = isMatch(s, p, i, j + 1);
        }
        return result || result1 || result2;
    } else if (p.charAt(j) == '.') {
      return isMatch(s, p, i+1, j+1);
    } else if (s.charAt(i) == p.charAt(j)) {
      return isMatch(s, p, i+1, j+1);
    } else if ( j + 1 < p.length()-1 && p.charAt(j+1) == '*') {
      return isMatch(s, p, i, j+2);
    }

    return false;
  }

}
