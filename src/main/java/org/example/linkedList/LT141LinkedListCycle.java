package org.example.linkedList;

import java.util.ArrayList;
import java.util.List;

public class LT141LinkedListCycle {

    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
    public boolean hasCycle(ListNode head) {
        List<ListNode> elements = new ArrayList<>();
        ListNode currentNode = head;
        while(currentNode != null) {
            if(elements.contains(currentNode))
                return true;
            else
                elements.add(currentNode);
            currentNode = currentNode.next;
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
