
  class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }

      ListNode(int x, ListNode next) {
        val = x;
        this.next = next;
    }
  }
 
public class Solution {
    public static boolean hasCycle(ListNode head) {
        if(head==null) return false;

        ListNode i=head;
        ListNode j=head;

        while(j.next!=null && j.next.next!=null){
            i=i.next;
            j=j.next.next;

            if(i==j) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode n4 = new ListNode(0, null);
        ListNode n3 = new ListNode(0, n4);
        ListNode n2 = new ListNode(0, n3);
        ListNode n1 = new ListNode(0, n2);

        ListNode head = n1;

        System.out.println(hasCycle(head));

        n4.next = n2;
        System.out.println(hasCycle(head));

    }
}