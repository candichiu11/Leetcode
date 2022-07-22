package leetcode.Level2.day4LinkedList;

import leetcode.ListNode;

public class SortList148 {

    //Time: O(nlog n), Space: O(log n), where n is the number of nodes in linked list.
    // Since the problem is recursive,
    // we need additional space to store the recursive call stack. The maximum depth of the recursion tree is log n

    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode temp = null;
        ListNode fast = head, slow = head;

        //spilt O(log N)
        while (fast != null && fast.next!=null) {
            temp = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        temp.next = null;

        ListNode leftList = sortList(head);
        ListNode rightList = sortList(slow);
        return mergeList(leftList, rightList); //O(n)

    }

    private ListNode mergeList(ListNode list1, ListNode list2) {
        ListNode prev = new ListNode(-1);
        ListNode curr = prev;

        while (list1!=null && list2!=null) {
            if(list1.val < list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }
        curr.next = list1 == null? list2:list1;
        return prev.next;
    }
}
