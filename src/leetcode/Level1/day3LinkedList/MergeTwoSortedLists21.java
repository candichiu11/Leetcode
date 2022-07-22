package leetcode.Level1.day3LinkedList;

import leetcode.ListNode;

public class MergeTwoSortedLists21 {

    //Recursion
    //Time: O(m+n), Space: O(m+n)
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head;

        if(list1.val < list2.val) {
            head = list1;
            list1 = list1.next;
        } else {
            head = list2;
            list2 = list2.next;
        }

        head.next = mergeTwoLists(list1, list2);
        return head;
    }

    //Time: O(m+n), Space: O(1)
    public ListNode mergeTwoListsIterative(ListNode list1, ListNode list2) {
        ListNode prev = new ListNode(-1);
        ListNode curr = prev;

        while(list1 != null && list2 != null) {
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
