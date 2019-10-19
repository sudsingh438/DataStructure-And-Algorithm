import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */

public class LetterCombinationsOfPhoneNumber {

  private static Map<Character, List<Character>> combination = new HashMap<Character, List<Character>>();

  public static void main(String[] args) {
    combination.put('2', Arrays.asList('a', 'b', 'c'));
    combination.put('3', Arrays.asList('d', 'e', 'f'));
    combination.put('4', Arrays.asList('g', 'h', 'i'));
    combination.put('5', Arrays.asList('j', 'k', 'l'));
    combination.put('6', Arrays.asList('m', 'n', 'o'));
    combination.put('7', Arrays.asList('p', 'q', 'r', 's'));
    combination.put('8', Arrays.asList('t', 'u', 'v'));
    combination.put('9', Arrays.asList('w', 'y', 'z'));


    LetterCombinationsOfPhoneNumber solution = new LetterCombinationsOfPhoneNumber();


    System.out.println(solution.letterCombinations("23"));
  }

  public List<String> letterCombinations(String digits) {
      return printCombination(digits);
  }

  List<String> printCombination(String digits) {

    if (digits.isEmpty()) {
      return new ArrayList<String>();
    }
    Iterator<Character> it = combination.get(digits.charAt(0)).iterator();

    List<String> resultantString = new ArrayList<>();

    while (it.hasNext()) {
      Character prependCharacter = it.next();
      List<String> resultant = printCombination(digits.substring(1, digits.length()));

      if (resultant.isEmpty()) {
        resultantString.add(prependCharacter.toString());
      }
      else {
        for (String each : resultant) {
          resultantString.add(prependCharacter + each);
        }
      }
    }

    return resultantString;
  }

}
