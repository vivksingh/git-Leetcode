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
    public ListNode removeZeroSumSublists(ListNode head) {
        Map<Integer, ListNode> map = new HashMap<>();
        ListNode dummy = new ListNode(0,head);

        int prefix = 0;
        ListNode cur = dummy;

        while(cur != null){
            prefix += cur.val;

            if(map.containsKey(prefix)){
                ListNode prev = map.get(prefix);
                ListNode temp = prev;
                int sum = prefix;
                while(temp.next != cur){
                    temp = temp.next;
                    sum += temp.val;
                    map.remove(sum);
                }
                prev.next = cur.next;
            }
            else map.put(prefix, cur);

            cur = cur.next;
        }

        return dummy.next;
    }
}

// 3 1 9 4 2 4 -10

// 1 2 -3 5
// 0 1 2 -3 5 n