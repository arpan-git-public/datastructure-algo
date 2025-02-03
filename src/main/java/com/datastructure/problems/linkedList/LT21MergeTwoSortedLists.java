package com.datastructure.problems.linkedList;

import java.util.List;

public class LT21MergeTwoSortedLists {

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
//    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//        ListNode mergeNodes = new ListNode();
//        ListNode currentResultNode = mergeNodes;
//
//        ListNode currentL1 = list1;
//        ListNode currentL2 = list2;
//        while(currentL1 != null || currentL2 != null) {
//            int num1 = currentL1!= null ? currentL1.val : Integer.MIN_VALUE;
//            int num2 = currentL2 != null ? currentL2.val : Integer.MIN_VALUE;
//
//            if(num1 !=  Integer.MIN_VALUE && num2 !=  Integer.MIN_VALUE) {
//                if(num1 > num2) {
//                    currentResultNode.next = new ListNode(num2);
//                    if(currentL2.next == null || (currentL2.next != null && currentL2.next.val > num1)) {
//                        currentResultNode = currentResultNode.next;
//                        currentResultNode.next = new ListNode(num1);
//                        if(currentL1!= null) currentL1 = currentL1.next;
//                    }
//                    if(currentL2 != null) currentL2 = currentL2.next;
//                } else if(num1 < num2) {
//                    currentResultNode.next = new ListNode(num1);
//                    if(currentL1.next  == null || (currentL1.next != null && currentL1.next.val > num2)) {
//                        currentResultNode = currentResultNode.next;
//                        currentResultNode.next = new ListNode(num2);
//                        if(currentL2 != null) currentL2 = currentL2.next;
//                    }
//                    if(currentL1!= null) currentL1 = currentL1.next;
//                }else {
//                    currentResultNode.next = new ListNode(num2);
//                    currentResultNode = currentResultNode.next;
//                    currentResultNode.next = new ListNode(num1);
//                    if(currentL1!= null) currentL1 = currentL1.next;
//                    if(currentL2 != null) currentL2 = currentL2.next;
//                }
//            } else if (num1 != Integer.MIN_VALUE) {
//                currentResultNode.next = new ListNode(num1);
//                if(currentL1!= null) currentL1 = currentL1.next;
//            } else if(num2 != Integer.MIN_VALUE) {
//                currentResultNode.next = new ListNode(num2);
//                if(currentL2 != null) currentL2 = currentL2.next;
//            }
//            currentResultNode = currentResultNode.next;
//
//        }
//
//        return mergeNodes.next;
//    }

    //Approach 1
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode merged = new ListNode();
        ListNode currentResult = merged;
        while(list1 != null && list2 != null) {
            if(list1.val >= list2.val) {
                currentResult.next = list2;
                list2 = list2.next;
            } else {
                currentResult.next = list1;
                list1 = list1.next;
            }
            currentResult = currentResult.next;
        }

        currentResult.next = list1==null?list2:list1;
        return merged.next;
    }
}
