import java.util.Set;
import java.util.ArrayList;
public class Solution_reverseBetween {
    public ListNode reverseBetween(ListNode head, int m , int n) {
        // write your code
        if (m >= n || head == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int ind = 0;
        head = dummy;
        ListNode nodeM_1 = new ListNode(0);
        ListNode nodeM = new ListNode(0);
        ListNode nodeN = new ListNode(0);
        ListNode nodeNp1 = new ListNode(0);
        ListNode prev = dummy;
        ListNode next;
        while (head != null) {
            next = head.next;            
            if (ind == m - 1) {
                nodeM_1 = head;
            } 
            if (ind == m) {
                nodeM = head;
            }
            
            if (ind >= m && ind <= n) {
                head.next = prev;
                if (ind == n) {
                	nodeNp1 = next;
                	nodeN = head;
                	break;
                }
            }
            prev = head;
            head = next;
            ind++;
        }
        nodeM_1.next = nodeN;
        nodeM.next = nodeNp1;
        return dummy.next;
    }
}
