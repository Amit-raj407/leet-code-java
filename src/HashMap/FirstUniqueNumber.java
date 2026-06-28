package HashMap;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueNumber {
    class Node {
        int val;
        Node prev, next;

        Node(int val) {
            this.val = val;
        }
    }

    class DoublyLinkedList {
        Node head, tail;

        DoublyLinkedList() {
            head = new Node(-1);
            tail = new Node(-1);

            head.next = tail;
            tail.prev = head;
        }

        void addLast(Node node) {
            Node prev = tail.prev;

            prev.next = node;
            node.prev = prev;

            node.next = tail;
            tail.prev = node;
        }

        void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        int getFirst() {
            return this.isEmpty() ? -1 : head.next.val;
        }

        boolean isEmpty() {
            return head.next == tail;
        }
    }

    private Map<Integer, Integer> freq;
    private Map<Integer, Node> nodeMap;
    private DoublyLinkedList dll;

    public FirstUniqueNumber(int[] nums) {
        freq = new HashMap<>();
        nodeMap = new HashMap<>();
        dll = new DoublyLinkedList();

        for(int num: nums) {
            add(num);
        }
    }

    public int showFirstUnique() {
        return dll.getFirst();
    }

    public void add(int value) {
        int count = freq.getOrDefault(value, 0) + 1;
        freq.put(value, count);

        if(count == 1) {
            Node node = new Node(value);
            dll.addLast(node);
            nodeMap.put(value, node);
        } else if (count == 2) {
            // no longer unique
            Node node = nodeMap.get(value);
            dll.remove(node);
            nodeMap.remove(value);
        }
    }
}
