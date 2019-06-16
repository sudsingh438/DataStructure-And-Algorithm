import java.util.HashSet;


public class LongestSubstringWithoutRepeatingCharacters {


  public static void main(String[] args) {

    LongestSubstringWithoutRepeatingCharactersSolution solution = new LongestSubstringWithoutRepeatingCharactersSolution();

    int max = solution.lengthOfLongestSubstring("tabcaed");
    System.out.println(max);
    max = solution.lengthOfLongestSubstring("abcdaefg");
    System.out.println(max);

  }
}

class LongestSubstringWithoutRepeatingCharactersSolution {

  public int lengthOfLongestSubstring(String s) {
    HashSet<String> uniqueVal = new HashSet<String>();
    int startIndex = 0;
    int endIndex = 0;
    int maxLength = 0;
    while (endIndex < (s.length())) {
      if (uniqueVal.contains(s.substring(endIndex, endIndex+1))) {
        startIndex = startIndex + s.substring(startIndex, endIndex).lastIndexOf(s.charAt(endIndex)) + 1;
        int currentLength = endIndex - startIndex;
        if (currentLength > maxLength) {
          maxLength = currentLength;
        }
        uniqueVal.clear();
        endIndex = startIndex;
      } else {
        uniqueVal.add(s.substring(endIndex, endIndex+1));
        endIndex++;
        int currentLength = endIndex - startIndex;
        if (currentLength > maxLength) {
          maxLength = currentLength;
        }
      }
    }
    return maxLength;
  }

}
