/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode cur = head;
        while(cur.next != null){
            ListNode next = cur.next;
            ListNode New = new ListNode(getGCD(cur.val, next.val));
            cur.next = New;
            New.next = next;
            cur = next;
        }

        return head;
    }

    private int getGCD(int a, int b){
        if(b == 0) return a;
        return getGCD(b, a % b);
    }
}