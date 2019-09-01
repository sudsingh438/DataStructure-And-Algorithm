import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class FindtheNumber {


  // Complete the findNumber function below.
  static String findNumber(List<Integer> arr, int k) {
    if (arr != null) {
      for (Integer i: arr) {
        if (i == k) {
          return "YES";
        }
      }
    }
    return "NO";
  }

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

    List<Integer> arr = new ArrayList<>();

    for (int i = 0; i < arrCount; i++) {
      int arrItem = Integer.parseInt(bufferedReader.readLine().trim());
      arr.add(arrItem);
    }

    int k = Integer.parseInt(bufferedReader.readLine().trim());

    String res = findNumber(arr, k);

    bufferedWriter.write(res);
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}

