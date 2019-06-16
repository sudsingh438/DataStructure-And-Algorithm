import java.util.ArrayList;
import java.util.List;

public class ZigZagConversion {
  public static void main(String[] args) {
    ZigZagConversionSolution solution = new ZigZagConversionSolution();
    solution.convert("PAYPALISHIRING", 3);
    System.out.println(solution.convert("PAYPALISHIRING", 3));
  }

}

class ZigZagConversionSolution {
  public String convert(String s, int numRows) {
    for (int i = 0; i < numRows; i++) {
      List<String> rows = new ArrayList<>();
    }


    String outputString = "";
    for (int i = 0; i < numRows; i++) {
      int index = i;
      String indexString = "";
      while (index < s.length()) {
        indexString = indexString + s.charAt(index);
        index = index + numRows + 1;
      }
      outputString = outputString + indexString;
    }
    return outputString;
  }
  //PAHNAPLSIIGYIR
}
