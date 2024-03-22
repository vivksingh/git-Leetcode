
class ListNode {
      int val;
      ListNode next = null;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
 
class Solution {
    public static boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;

        ListNode middleNode = findMiddleNode(head);
        ListNode reversedHead = findReversedHead(middleNode);

        return true;
        

    }

    private static ListNode findMiddleNode(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private static ListNode findReversedHead(ListNode head){
        ListNode prev = null;
        ListNode cur = head;

        while(cur != null){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;
    }

    private static void printLinkedList(ListNode head){
        ListNode cur = head;

        while(cur != null){
            System.out.print(cur.val + " -> ");
            cur = cur.next;
        }

        System.out.print("null \n");
    }

    private static boolean checkPalindrome(ListNode head1, ListNode head2){

        while(head1 != null && head2 != null){
            if(head1.val != head2.val) return false;
            head1 = head1.next;
            head2 = head2.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode prev = head;

        for(int i=1;i<=3;i++){
            ListNode temp = new ListNode(i);
            prev.next = temp;
            prev = temp;
        }

        for(int i=3;i>=1;i--){
            ListNode temp = new ListNode(i);
            prev.next = temp;
            prev = temp;
        }
        head = head.next;

        ListNode middle = findMiddleNode(head);
        ListNode reversedHead = findReversedHead(middle);
        printLinkedList(reversedHead);
        printLinkedList(head);
        System.out.println(checkPalindrome(head, reversedHead));
        
    }
}