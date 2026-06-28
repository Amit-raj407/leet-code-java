package HashMap;

import java.util.HashMap;
import java.util.Map;

public class LFUCache {

    class Node {
        int key;
        int value;
        int freq;

        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }

    class DoublyLinkedList {
        Node head;
        Node tail;
        int size;

        DoublyLinkedList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);

            head.next = tail;
            tail.prev = head;
        }

        void addFirst(Node node) {
            Node next = head.next;

            head.next = node;
            node.prev = head;

            node.next = next;
            next.prev = node;

            size++;
        }

        Node removeLast() {
            if(size == 0) {
                return null;
            }

            Node last = tail.prev;
            remove(last);

            return last;
        }

        void remove(Node node) {
            Node prev = node.prev;
            Node next = node.next;

            prev.next = next;
            next.prev = prev;

            size--;
        }

        boolean isEmpty() {
            return size == 0;
        }
    }

    private int capacity;
    private int minFreq;

    private Map<Integer, Node> nodeMap;
    private Map<Integer, DoublyLinkedList> freqMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;

        nodeMap = new HashMap<>();
        freqMap = new HashMap<>();

        minFreq = 0;
    }

    public int get(int key) {
        Node node = nodeMap.get(key);

        if(node == null) {
            return -1;
        }
        
        updateFrequency(node);
        return node.value;
    }

    public void put(int key, int value) {
        if(capacity == 0) return;

        Node node = nodeMap.get(key);

        if(node != null) {
            node.value = value;
            updateFrequency(node);
            return;
        }

        // cache full
        if(nodeMap.size() == capacity) {
            DoublyLinkedList minList = freqMap.get(minFreq);

            Node lru = minList.removeLast();

            nodeMap.remove(lru.key);
        }

        Node newNode = new Node(key, value);

        nodeMap.put(key, newNode);

        DoublyLinkedList list = freqMap.getOrDefault(1, new DoublyLinkedList());

        list.addFirst(newNode);

        freqMap.put(1, list);

        minFreq = 1;
    }

    private void updateFrequency(Node node) {
        int currentFreq = node.freq;

        DoublyLinkedList currentDLinkedList = freqMap.get(currentFreq);

        currentDLinkedList.remove(node);

        if(currentFreq == minFreq && currentDLinkedList.isEmpty()) {
            minFreq++;
        }

        node.freq++;
        DoublyLinkedList newList = freqMap.getOrDefault(node.freq, new DoublyLinkedList());
        newList.addFirst(node);

        freqMap.put(node.freq, newList);
    }
}