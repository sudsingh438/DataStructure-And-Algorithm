import javafx.util.Pair;

/**
 * Node Class
 */
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}

/**
 * Main Class for test cases
 */
public class LinkedListNumberAddition {

  public static void main(String[] args) {

    ListNode firstNode = new ListNode(2);
    firstNode.next = new ListNode(4);
    firstNode.next.next = new ListNode(3);
    firstNode.next.next.next = null;

    ListNode secondNode = new ListNode(9);
    secondNode.next = new ListNode(6);
    secondNode.next.next = new ListNode(4);
    secondNode.next.next.next = new ListNode(3);
    secondNode.next.next.next.next = null;

   Solution solution = new Solution();

   ListNode result = solution.addTwoNumbers(firstNode, secondNode);

   while (result != null) {
     System.out.print(result.val);
     result = result.next;
   }

  }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

    int l1Count = getLength(l1);
    int l2Count = getLength(l2);

    ListNode result = new ListNode(0);

    if (l1Count == l2Count) {
      Pair<Integer, ListNode> resultPair = addEqualAndReturnCarry(l1, l2);
      int carry = resultPair.getKey();
      result = resultPair.getValue();
      if (carry != 0) {
        ListNode temp = new ListNode(carry);
        temp.next = result;
        result = temp;
      }
    }
    else if (l1Count > l2Count) {
      int diff = l1Count - l2Count;
      ListNode tempNode = navigateTo(l1, diff);
      Pair<Integer, ListNode> resultPair = addEqualAndReturnCarry(tempNode, l2);
      int carry = resultPair.getKey();
      result = resultPair.getValue();
      resultPair = addListAndNumberAndReturnCarry(l1,carry, result, tempNode);
      carry = resultPair.getKey();
      result = resultPair.getValue();
      if (carry != 0 ){
        ListNode temp = new ListNode(carry);
        temp.next = result.next;
        result.next = temp;
      }
    } else {
      int diff = l2Count - l1Count;
      ListNode tempNode = navigateTo(l2, diff);
      Pair<Integer, ListNode> resultPair = addEqualAndReturnCarry(tempNode, l1);
      int carry = resultPair.getKey();
      result = resultPair.getValue();
      resultPair = addListAndNumberAndReturnCarry(l2, carry, result, tempNode);
      carry = resultPair.getKey();
      result = resultPair.getValue();
      if (carry != 0) {
        ListNode temp = new ListNode(carry);
        temp.next = result.next;
        result.next = temp;
      }
    }

    return result;
  }

  private ListNode navigateTo(ListNode l, int count) {
    int tempCount = 0;
    ListNode temp = l;
    while (tempCount != count) {
      temp = temp.next;
      tempCount++;
    }
    return temp;
  }

  private int getLength(ListNode l1) {
    int count = 0;
    ListNode temp = l1;
    while (temp.next != null) {
      temp = temp.next;
      count++;
    }
    return count;
  }

  private Pair<Integer, ListNode> addEqualAndReturnCarry(ListNode first, ListNode second) {
    if (first.next != null && second.next != null) {
      Pair<Integer, ListNode> resultPair = addEqualAndReturnCarry(first.next,second.next);
      int carry = resultPair.getKey();
      ListNode result = resultPair.getValue();
      ListNode temp = new ListNode(first.val + second.val + carry);
      int newCarry = temp.val/10;
      temp.val = temp.val%10;
      temp.next = result;
      return new Pair<>(newCarry, temp);
    }
    else {
      ListNode temp = new ListNode(first.val + second.val);
      int newCarry = temp.val/10;
      temp.val = temp.val%10;
      return new Pair<>(newCarry, temp);
    }
  }


  private Pair<Integer, ListNode> addListAndNumberAndReturnCarry(ListNode first,int carry,ListNode result, ListNode endNode) {
    if (first.next != endNode) {
      Pair<Integer, ListNode> resultPair = addListAndNumberAndReturnCarry(first.next,carry,result, endNode);
      int tempCarry = resultPair.getKey();
      result = resultPair.getValue();
      ListNode temp = new ListNode(first.val + tempCarry);
      int newCarry = temp.val/10;
      temp.val = temp.val%10;
      temp.next = result;
      return new Pair<>(newCarry, temp);
    } else {
      ListNode temp = new ListNode(first.val + carry);
      int newCarry = temp.val/10;
      temp.val = temp.val%10;
      temp.next = result;
      return new Pair<>(newCarry, temp);
    }
  }
}
