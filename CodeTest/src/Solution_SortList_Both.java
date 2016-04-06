import java.util.*;
/*
class Pair {
    ListNode left;
    ListNode right;
    Pair (ListNode left, ListNode right) {
        this.left = left;
        this.right = right;
    }
}
*/
public class Solution_SortList_Both {
    /**
     * @param head: The head of linked list.
     * @return: You should return the head of the sorted linked list,
                    using constant space complexity.
     */
    public ListNode sortList(ListNode head) {  
        // write your code here
        if (head == null || head.next == null) {
            return head;
        }
        //return mergeSort(head);
        return quickSort(head);
    }
    // MergeSort
    private ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = findMid(head);
        ListNode right = mergeSort(mid.next);
        mid.next = null;
        ListNode left = mergeSort(head);
        return mergeLists(left, right);
    }
    // QuickSort
    private ListNode quickSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        Pair pair = partitionList(head, findMid(head).val);
        ListNode left = quickSort(pair.left);
        ListNode right = quickSort(pair.right);
        return connectLists(left, right);
        
    }
    // Auxiliary functions
    private ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (slow.next != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    private ListNode mergeLists(ListNode head1, ListNode head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (head1 != null && head2 != null) {
            if (head1.val <= head2.val) {
                tail.next = head1;
                head1 = head1.next;
            } else {
                tail.next = head2;
                head2 = head2.next;
            }
            tail = tail.next;
        }
        if (head1 != null) {
            tail.next = head1;
        } else {
            tail.next = head2;
        }
        return dummy.next;
    }
    private Pair partitionList(ListNode head, int mid) {
        ListNode dummyLeft = new ListNode(0);
        ListNode tailLeft = dummyLeft;
        ListNode dummyRight = new ListNode(0);
        ListNode tailRight = dummyRight;
        ListNode dummyMid = new ListNode(0);
        ListNode tailMid = dummyMid;
        while (head != null) {
            if (head.val < mid) {
                tailLeft.next = head;
                tailLeft = head;
            } else if (head.val > mid){
                tailRight.next = head;
                tailRight = head;
            } else {
            	tailMid.next = head;
            	tailMid = head;
            }
            head = head.next;
        }
        tailLeft.next = null;
        tailMid.next = null;
        tailRight.next = null;

        if (dummyLeft.next == null & dummyRight.next == null) {
        	ListNode midNode = findMid(dummyMid.next);
        	dummyLeft.next = dummyMid.next;
        	dummyRight.next = midNode.next;
        	midNode.next = null;
        } else if (dummyLeft.next == null) {
        	tailLeft.next = dummyMid.next;        	
        } else{
        	tailRight.next = dummyMid.next;
        }
        return (new Pair(dummyLeft.next, dummyRight.next));
    }
    private ListNode connectLists(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        tail.next = left;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = right;
        return dummy.next;
    }
    
}
