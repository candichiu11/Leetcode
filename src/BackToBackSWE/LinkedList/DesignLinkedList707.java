package BackToBackSWE.LinkedList;

import leetcode.ListNode;

public class DesignLinkedList707 {

    public class MyLinkedList {
        ListNode head;
        int size;

        public MyLinkedList() {
            head = new ListNode(); //a dummy head
        }

        //Time: O(k), k: the index of the element to get
        public int get(int index) {
            if(index < 0 || index >= this.size) return -1;

            ListNode curr = head.next;
            for(int i = 0; i < index; i++) {
                curr = curr.next;
            }

            return curr.val;
        }

        //Time: O(1)
        public void addAtHead(int val) {
            addAtIndex(0, val);
        }

        //Time: O(n)
        public void addAtTail(int val) {
           addAtIndex(size, val);
        }

        //Time: O(k), k: the index of the element to add
        public void addAtIndex(int index, int val) {
            if(index < 0 || index > this.size) return;

            ListNode newNode = new ListNode(val);
            ListNode curr = head;

            for(int i = 0; i <= index; i++) {
                curr = curr.next;
            }

            newNode.next = curr.next;
            curr.next = newNode;
            size++;
        }

        //Time: O(k), k: the index of the element to delete
        public void deleteAtIndex(int index) {
            if(index < 0 || index >= this.size) return;

            ListNode curr = head;
            for(int i = 0; i < index; i++) {
                curr = curr.next;
            }

            curr.next = curr.next.next;
            size--;
        }
    }
}
