 class ListNode {
      int val;
      ListNode next;
     ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode mergeStart = nodeAtIndex(list1, a-1);
        ListNode mergeEnd = nodeAtIndex(list1, b+1);
        ListNode list2EndNode = LastNode(list2);

        mergeStart.next = list2;
        list2EndNode.next = mergeEnd;

        return list1;
    }

    public ListNode nodeAtIndex(ListNode head, int indx){
        ListNode cur = head;

        while(indx-- != 0){
            cur = cur.next;
        }

        return cur;
    }

    public ListNode LastNode(ListNode head){
        ListNode cur = head;

        while(cur.next != null){
            cur = cur.next;
        }
        
        return cur;
    }
}