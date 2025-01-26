package org.example.linkedList;

public class LT2AddTwoNumbers {

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    int reminder = 0;
    ListNode currentL1 = l1;
    ListNode currentL2 = l2;
    ListNode result = new ListNode();
    ListNode current = result;
    while(currentL1 != null || currentL2 != null) {
      int num1 = currentL1 != null ? currentL1.val : 0;
      int num2 = currentL2 != null ? currentL2.val : 0;

      int sum = num1 + num2 + reminder;
      reminder = sum / 10;
      current.next = new ListNode(sum%10);
      current = current.next;
      if(currentL1 != null)currentL1 = currentL1.next;
      if(currentL2 != null)currentL2 = currentL2.next;
    }
    if(reminder > 0)
      current.next = new ListNode(reminder);

    return result.next;

  }

  public static void main(String[] args) {
    var lt = new LT2AddTwoNumbers();
  }
}
