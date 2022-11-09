package leetcode.NeetCode150.LinkedList;

import java.util.HashMap;
import java.util.Map;

public class LRUCache146 {

    private class ListNode {
        int key;
        int value;
        ListNode prev;
        ListNode next;
    }

    Map<Integer, ListNode> map;
    int maxCapacity;
    int currCapacity;
    ListNode dummyHead = new ListNode();
    ListNode dummyTail = new ListNode();

    public LRUCache146(int capacity) {
        map = new HashMap<>();
        maxCapacity = capacity;
        currCapacity = 0;
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
    }

    //O(1)
    public int get(int key) {

        if (map.containsKey(key)) {
            ListNode node = map.get(key);
            moveToHead(node);
            return node.value;
        }

        return -1;

    }

    // Time: O(1)
    // Space: O(capacity)
    public void put(int key, int value) {

        if (map.containsKey(key)) {
            ListNode node = map.get(key);
            node.value = value;
            moveToHead(node);

        } else {
            ListNode newNode = new ListNode();
            newNode.key = key;
            newNode.value = value;

            if (map.size() == maxCapacity) {
                popTail();
                currCapacity--;

            }

            map.put(key, newNode);
            addToFront(newNode);
            currCapacity++;
        }

    }

    private void popTail() {
        ListNode tail = dummyTail.prev;
        removeFromList(tail);
        map.remove(tail.key);
    }

    private void removeFromList(ListNode node) {
        ListNode savedPrev = node.prev;
        ListNode savedNext = node.next;

        savedPrev.next = savedNext;
        savedNext.prev = savedPrev;
    }

    private void addToFront(ListNode node) {
        node.prev = dummyHead;
        node.next = dummyHead.next;

        dummyHead.next.prev = node;
        dummyHead.next = node;
    }

    private void moveToHead(ListNode node) {
        removeFromList(node);
        addToFront(node);
    }

    public static void main(String[] args) {
        LRUCache146 test = new LRUCache146(2);
        test.put(1, 1);
        test.put(2, 2);
        System.out.println(test.get(1));
        test.put(3, 3);
        System.out.println(test.get(2));
    }
}
