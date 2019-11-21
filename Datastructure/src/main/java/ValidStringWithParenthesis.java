import java.util.Stack;

class Item {
  int index = -1;
  Character character;
}


public class ValidStringWithParenthesis {

  public static void main(String[] args) {
    System.out.print(minRemoveToMakeValid("lee(t(c)o)de)"));
  }

  public static String minRemoveToMakeValid(String s) {
    Stack S = new Stack<Item>();
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == ')') {
        if (!S.empty()) {
          Item topVal = (Item) S.peek();
          if (topVal.character == '(') {
            S.pop();
          } else {
            Item temp = new Item();
            temp.index = i;
            temp.character = s.charAt(i);
            S.push(temp);
          }
        } else {
          Item temp = new Item();
          temp.index = i;
          temp.character = s.charAt(i);
          S.push(temp);
        }
      } else if (s.charAt(i) == '(') {
        Item temp = new Item();
        temp.index = i;
        temp.character = s.charAt(i);
        S.push(temp);
      }
    }

    StringBuilder result = new StringBuilder(s);
    while (!S.isEmpty()) {
      Item popedItem = (Item) S.pop();
      result.deleteCharAt(popedItem.index);
    }

    return result.toString();
  }
}
