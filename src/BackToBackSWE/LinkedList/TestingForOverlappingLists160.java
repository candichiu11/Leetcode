package BackToBackSWE.LinkedList;

import leetcode.ListNode;

public class TestingForOverlappingLists160 {

     //Time: O(m+n) m: the number of nodes in l1, n: the number of nodes in l2
     //Space: O(1)
     public ListNode getIntersectionNode(ListNode l1, ListNode l2) {
          if(l1 == null || l2 == null) return null;

          int len1 = lengthForLinkedList(l1);
          int len2 = lengthForLinkedList(l2);

          if(len1 > len2) {
               l1 = advanceReferenceBy(len1 - len2, l1);
          } else {
               l2 = advanceReferenceBy(len2 - len1, l2);
          }

          while (l1 != null && l2 != null && l1 != l2) {
               l1 = l1.next;
               l2 = l2.next;
          }

          return l1;
     }

     private ListNode advanceReferenceBy(int distance, ListNode head) {
          while (distance > 0) {
               head = head.next;
               distance--;
          }

          return head;
     }

     private int lengthForLinkedList(ListNode head) {
          if(head == null) return 0;

          ListNode curr = head;
          int length = 1;
          while (curr != null) {
               length++;
               curr = curr.next;
          }

          return length;
     }
}
