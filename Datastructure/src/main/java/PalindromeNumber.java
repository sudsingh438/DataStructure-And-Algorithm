public class PalindromeNumber {
  public static void main(String[] args) {
    PalindromeNumberSolution solution = new PalindromeNumberSolution();
    System.out.print(solution.isPalindrome(1));
  }
}

class PalindromeNumberSolution {
  public boolean isPalindrome(int x) {
      if (x < 0) {
        return false;
      }
      String number = String.valueOf(x);
      for (int i=0; i< number.length()/2; i++) {
        if (number.charAt(i) == number.charAt(number.length() - i - 1)) {
          continue;
        }
        else {
          return false;
        }
      }
      return true;
  }
}
