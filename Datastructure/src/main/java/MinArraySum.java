import java.util.Scanner;

public class MinArraySum {

  public static void main(String[] args) {

    Scanner keyboard = new Scanner( System.in );
    keyboard.nextLine();
    String input = keyboard.nextLine();

    String[] numbersStr = input.split(" ");

    int[] numbers = new int[ numbersStr.length ];

    Long sum = 0l;
    for ( int i = 0; i < numbersStr.length; i++ )
    {
      numbers[i] = Integer.parseInt( numbersStr[i] );
      sum = sum + numbers[i];
    }


    long remain = sum%(numbersStr.length);


    System.out.print(sum/(numbersStr.length) + 1l);


  }
}
