import java.util.Set;
public class Solution_reorderList {
    public void reorderList(ListNode head) {  
        // write your code here
        if (head == null) {
            return;
        }
        int len = 0;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        while (head != null) {
            len++;
            head = head.next;
        } 
        if (len <= 2) {
            return;
        }
        head = dummy.next;
        int ind = 0;
        while (ind < len / 2) {
            ind++;
            head = head.next;
        }
        ListNode head2 = head.next;

        head.next = null;
        head2 = reverseList(head2);

        head = dummy.next;

        head = mergeLists(head, head2);
        return;
    }
    private ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode prev, after;
        prev = head;
        head = head.next;
        prev.next = null;
        
        
        while (head != null) {
            after = head.next;
            head.next = prev;
            prev = head;
            head = after;
        }
        return prev;
    }
    private ListNode mergeLists(ListNode head1, ListNode head2) {
        if (head1 == null) {
            return head2;
        } else if (head2 == null) {
            return head1;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head1;
        ListNode next1, next2;
        while (head1 != null && head2 != null) {
            next1 = head1.next; 
            next2 = head2.next;
            head2.next = next1;
            head1.next = head2;
            head1 = next1;
            head2 = next2;
        }
        return dummy.next;
    }
}
