import java.util.Stack;

public class PolishNotation {

  public static void main(String[] args) {
    System.out.println(polishNotationCalculation("( + + 7 ( * 8 12 ) ( * * 2 ( + 9 4 ) 7 )"));
  }

  static int polishNotationCalculation(String strCalc){
    Stack sk = new Stack<String>();
    String operation = null;
    String operand1 = null;
    String operand2 = null;

    String[] opList = strCalc.split(" ");

    for(int i = opList.length-1; i>=0;i--){
      String S = opList[i];
      if(S.equals("(") || S.equals(")")) {
        continue;
      }
      if(S.equals("+") || S.equals("-")
          || S.equals("*") || S.equals("/")){
        operation = S;
        if(!sk.isEmpty()){
          operand1 = (String)sk.pop();
        }
        if(!sk.isEmpty()){
          operand2 = (String)sk.pop();
        }
        int interResult = performCalc(operand1,operand2,operation);
        sk.push(String.valueOf(interResult));

      }else {
        sk.push(S);
      }

    }

    String result = (String)sk.pop();
    System.out.println("Result is "+result);
    return Integer.valueOf(result);
  }

  private static int performCalc(String operand1, String operand2,
      String operation) {
    int result =0;
    switch (operation.charAt(0)) {
      case '+':
        result = Integer.valueOf(operand1) + Integer.valueOf(operand2);
        break;
      case '-':
        result = Integer.valueOf(operand1) - Integer.valueOf(operand2);
        break;
      case '*':
        result = Integer.valueOf(operand1) * Integer.valueOf(operand2);
        break;
      case '/':
        result = Integer.valueOf(operand1) / Integer.valueOf(operand2);
        break;
      default:
        break;
    }
    return result;
  }

}
