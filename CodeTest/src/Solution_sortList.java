import java.util.Set;
public class Solution_sortList {
    public ListNode sortList(ListNode head) {  
        // write your code here
        if (head == null || head.next == null) {
            return head;
        }
        int len = 0;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        while (head != null) {
            len++;
            head = head.next;
        }
        head = dummy.next;
        // divide the list
        ListNode left = head;
        int i = 0;
        while (i < len / 2 - 1) {
            head = head.next;
            i++;
        }
        ListNode right = head.next;
        head.next = null;
        left = sortList(left);
        right = sortList(right);
        System.out.println("IN");
        return mergeLists(left, right);
    }
    private ListNode mergeLists(ListNode head1, ListNode head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head1; 
        ListNode prevNode = dummy;
        while (head1 != null && head2 != null) {
            if (head2.val < head1.val) {
                ListNode temp2 = head2.next;
                prevNode.next = head2;
                head2.next = head1;
                prevNode = head2;
                head2 = temp2;
            } else {
                if (head1.next == null) {
                    head1.next = head2;
                    break;
                } else {
                    if (head1.next.val <= head2.val) {
                        prevNode = head1;
                        head1 = head1.next;
                    } else {
                        ListNode temp2 = head2.next;
                        head2.next = head1.next;
                        head1.next = head2;
                        head2 = temp2;
                        prevNode = head1.next;
                        head1 = head1.next.next;
                    } 
                }                
            }
        }
        return dummy.next;
    }
}
