/**
 * Deletion Distance
 * The deletion distance of two strings is the minimum number of characters you need to delete in
 * the two strings in order to get the same string. For instance, the deletion distance between
 * "heat" and "hit" is 3:
 *
 * By deleting 'e' and 'a' in "heat", and 'i' in "hit", we get the string "ht" in both cases.
 * We cannot get the same string from both strings by deleting 2 letters or fewer.
 * Given the strings str1 and str2, write an efficient function deletionDistance that returns the
 * deletion distance between them. Explain how your function works, and analyze its time and
 * space complexities.
 */

class DeletionDistance {


  static int deletionDistance(String str1, String str2) {
    // your code goes here
    int count = 0;

    if (str1 == null && str2 == null) {
      return 0;
    }

    if (str1 == null || str1.isEmpty()) {
      return str2.length();
    }

    if (str2 == null || str2.isEmpty()) {
      return str1.length();
    }

    if (str1.charAt(0) == str2.charAt(0)) {
      if (str1.length() > 1 && str2.length() > 1) {
        count = deletionDistance(str1.substring(1), str2.substring(1));
      } else {
        if (str1.length() == 1 && str2.length() == 1) {
          return 0;
        } else if (str1.length() == 1) {
          return str2.length() - 1;
        } else {
          return str1.length() - 1;
        }
      }
    } else {
      count++;
      if (str1.length() > 1 && str2.length() > 1) {
        count = count + Math.min(deletionDistance(str1.substring(1), str2),
            deletionDistance(str1, str2.substring(1)));
      } else {
        if (str1.length() == 1 && str2.length() == 1) {
          return 2;
        } else if (str1.length() == 1) {
          count = count + deletionDistance(str1, str2.substring(1));
        } else {
          count = count + deletionDistance(str2, str1.substring(1));
        }
      }
    }

    return count;
  }

  public static void main(String[] args) {
    System.out.println(deletionDistance("ab", "ba"));
  }

}
