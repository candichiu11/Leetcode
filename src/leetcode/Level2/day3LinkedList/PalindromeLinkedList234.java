package leetcode.Level2.day3LinkedList;


import leetcode.ListNode;

public class PalindromeLinkedList234 {
 /***
    Which node is always points to null in linked list?
    tail node
    The first and last node of a linked list usually are called the head and tail of the list, respectively.
    Thus, we can traverse the list starting at the head and ending at the tail. The tail node is a special node,
    where the next pointer is always pointing or linking to a null reference, indicating the end of the list.
  ***/

     //Time: O(n), Space: O(1)
     public boolean isPalindrome(ListNode head) {
         ListNode fast = head;
         ListNode slow = head;

         //O(n)
         while(fast.next!=null && fast.next.next!=null) {
             fast = fast.next.next;
             slow = slow.next;
         }

         //O(n)
         ListNode secondHalfHead = reverse(slow.next);
         ListNode firstHalfHead = head;

         //O(n)
         while (secondHalfHead != null && firstHalfHead != null) {
             if(firstHalfHead.val != secondHalfHead.val) {
                 return false;
             }
             firstHalfHead = firstHalfHead.next;
             secondHalfHead = secondHalfHead.next;
         }
         return true;
     }

     private ListNode reverse(ListNode head) {
         ListNode previousNode = null;
         ListNode currentNode = head;

         while (currentNode != null) {
             ListNode nextNode = currentNode.next;
             currentNode.next = previousNode;
             previousNode = currentNode;
             currentNode = nextNode;
         }
         return previousNode;
     }

    public static void main ( String [ ] args ) {
         ListNode head = new ListNode(1);
         ListNode ele =  new ListNode(2);
//         ListNode ele2 = new ListNode(2);
//         ListNode ele3 = new ListNode(1);
//        ListNode ele4 = new ListNode(1);

         head.next = ele;
//         ele.next = ele2;
//         ele2.next = ele3;
//         ele3.next =ele4;

         PalindromeLinkedList234 test = new PalindromeLinkedList234();
         test.isPalindrome(head);
    }
}
