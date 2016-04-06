import java.util.*;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Happy Coding!");
		ListNode head = new ListNode(1);
		ListNode node1 = new ListNode(-1);
		node1.next = null;
		head.next = node1;		
		
		Solution objSolution = new Solution();


		int[] gas = {2,0,1,2,3,4,0};
		int[] cost = {0,1,0,0,0,0,11};
		int ans = objSolution.canCompleteCircuit(gas, cost);
		System.out.println("results");
		System.out.println(ans);
		System.out.println("end");
	}
}
