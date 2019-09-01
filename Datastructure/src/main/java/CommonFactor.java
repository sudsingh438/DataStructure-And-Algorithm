import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CommonFactor {
  public static void main(String args[] ) throws Exception {


    Long firstNumber = 0l;

    Long secondNumber = 0l;


    //BufferedReader
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String name = br.readLine();                // Reading input from STDIN
    System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

    String[] strs = name.trim().split("\\s+");

    if (strs.length >= 2 ) {
      firstNumber = Long.parseLong(strs[0]);
      secondNumber = Long.parseLong(strs[1]);
    }

    Long numberToLoop = (firstNumber > secondNumber) ? secondNumber : firstNumber;

    numberToLoop = (new Double(Math.sqrt(numberToLoop)).longValue());
    long count = 0;

    for(Long i = 0l; i< numberToLoop ; i++) {
      if (firstNumber%i == 0 && secondNumber%i == 0) {
        count++;
      }
    }

    System.out.print(count);

    //Scanner
    // Scanner s = new Scanner(System.in);
    // String name = s.nextLine();                 // Reading input from STDIN
    // System.out.println("Hi, " + name + ".");    // Writing output to STDOUT


    // Write your code here

  }


  int calculateGCD(int firstNumber, int secondNumber)
  {
    if (firstNumber == 0)
      return secondNumber;

    return calculateGCD(secondNumber%firstNumber,firstNumber);
  }

  int commDiv(int a,int b)
  {
    int n = calculateGCD(a, b);

    int result = 0;
    for (int i=1; i<=Math.sqrt(n); i++)
    {
      if (n%i==0)
      {
        if (n/i == i)
          result += 1;
        else
          result += 2;
      }
    }
    return result;
  }
}
