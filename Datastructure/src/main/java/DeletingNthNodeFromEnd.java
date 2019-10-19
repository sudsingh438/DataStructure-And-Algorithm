
public class DeletingNthNodeFromEnd {

  public static void main(String[] args) {
    DeletingNthNodeFromEnd solution = new DeletingNthNodeFromEnd();

    ListNode head= new ListNode(5);
    head.next = new ListNode(6);
    head.next.next = new ListNode(7);
    ListNode headRsp = solution.removeNthFromEnd(head, 1);

    while(headRsp != null) {
      System.out.println(headRsp.val);
      headRsp = headRsp.next;
    }
  }



  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode forwarNode = head;
    ListNode backWardNode = head;
    ListNode dummyHead = new ListNode(0);
    dummyHead.next = head;
    ListNode prevbackWardNode = dummyHead;
    int i =0;
    while (n > i) {
      if (forwarNode == null) {
        return head;
      }
      forwarNode = forwarNode.next;
      i++;
    }

    while (forwarNode != null) {
      forwarNode = forwarNode.next;
      prevbackWardNode = backWardNode;
      backWardNode = backWardNode.next;
    }

    if (backWardNode != null) {
      prevbackWardNode.next = backWardNode.next;
      backWardNode.next = null;
    }
    return dummyHead.next;
  }
}
