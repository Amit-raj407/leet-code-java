package LinkedList;


//🧠 Time and Space Complexity
//Time: O(n)
//
//Space: O(1) – constant space, no extra data structures

public class DetectCycle {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) {
                return true;
            }
        }
        return false;
    }
}

//Using Hashmap
//static boolean detectLoop(Node head) {
//    HashSet<Node> st = new HashSet<>();
//
//    while (head != null) {
//
//        // If this node is already present
//        // in hashmap it means there is a cycle
//        if (st.contains(head))
//            return true;
//
//        // If we are seeing the node for
//        // the first time, insert it in hash
//        st.add(head);
//
//        head = head.next;
//    }
//    return false;
//}
//Time complexity: O(n), where n is the number of nodes in the Linked List.
//Auxiliary Space: O(n), n is the space required to store the value in the hash set.




//141. Linked List Cycle

//Given head, the head of a linked list, determine if the linked list has a cycle in it.

//There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer.
//Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.

//Return true if there is a cycle in the linked list. Otherwise, return false.





