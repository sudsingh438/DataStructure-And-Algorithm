public class BalancedString {




  public static void main(String[] args) {
    BalancedString solution = new BalancedString();
    System.out.print(solution.balancedString("WWEQERQWQWWRWWERQWEQ"));
  }

  public int balancedString(String s) {

    int Rcount = 0;
    int Qcount = 0;
    int Wcount = 0;
    int Ecount = 0;

    int ans = 0;
    if (s == null || s.isEmpty()) {
      return -1;
    }

    int balancedCount = s.length() / 4;
    if (s.length() % 4 != 0) {
      return -1;
    }

    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == 'R') {
        Rcount++;
      } else if (s.charAt(i) == 'Q') {
        Qcount++;
      } else if (s.charAt(i) == 'W') {
        Wcount++;
      } else if (s.charAt(i) == 'E') {
        Ecount++;
      }
    }

    if (Rcount > balancedCount) {
      ans = ans + Rcount - balancedCount;
    }

    if (Qcount > balancedCount) {
      ans = ans + Qcount - balancedCount;
    }

    if (Wcount > balancedCount) {
      ans = ans + Wcount - balancedCount;
    }

    if (Ecount > balancedCount) {
      ans = ans + Ecount - balancedCount;
    }

    return ans;

  }

}
