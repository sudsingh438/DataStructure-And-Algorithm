public class ATOI {

  public static void main(String[] args) {
    ATOISolution soultion = new ATOISolution();
    System.out.print(soultion.myAtoi(" -00003000000 0020000000 897"));
  }

}


class ATOISolution {
  public int myAtoi(String str) {
    str = str.trim();
    String splitArry[] = str.split(" ");

    boolean isNegative = false;
    String input = "";
    try {
      if (splitArry.length > 0) {
        int j = 0;
        while (j < splitArry[0].length()) {
          if ((splitArry[0].charAt(j) >= 48 && splitArry[0].charAt(j) <= 57)) {

            if (input.isEmpty()) {
              if (splitArry[0].charAt(j) == 48) {
                j++;
                continue;
              }
            }
            input = input + splitArry[0].charAt(j);
            j++;
          } else if (j == 0 && (splitArry[0].charAt(j) == 45 || splitArry[0].charAt(j) == 43)) {
            isNegative = splitArry[0].charAt(j) == 45;
            j++;
            continue;
          } else {
            break;
          }
        }

        if (input.length() > 10) {
          if (isNegative) {
            return Integer.MIN_VALUE;
          } else {
            return Integer.MAX_VALUE;
          }
        }

        long num = Long.parseLong(input);

        if (isNegative) {
          num = num * -1;
        }

        if (num > Integer.MAX_VALUE) {
          return Integer.MAX_VALUE;
        } else if (num < Integer.MIN_VALUE) {
          return Integer.MIN_VALUE;
        } else {
          return (int) num;
        }
      }
    } catch (Exception e) {
      System.out.print(e.toString());
    }
    return 0;
  }
}
