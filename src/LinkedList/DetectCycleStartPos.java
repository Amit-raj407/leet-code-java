package LinkedList;

public class DetectCycleStartPos {
    public ListNode detectCycleStart(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) {
                break;
            }
        }

        // no cycle
        if(fast == null || fast.next == null) {
            return null;
        }

        // reset slow to head
        slow = head;
        while(slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow; // or fast, both are at the start of the cycle
    }
}
