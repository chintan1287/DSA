package exercise;


class Solution {

     // Definition for singly-linked list.
      public static class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; next = null;}
      }

    public static ListNode deleteDuplicates(ListNode head) {

        ListNode x = head;
        boolean skip = false;
        ListNode result = null;

        while (x.next != null) {
            if(x.val == x.next.val) {skip = true; x = x.next; continue;}
            if(skip) { skip = false; x = x.next; continue;}
            if(result == null) result = new ListNode(x.val);
            else {
                ListNode last = result;
                while (last != null && last.next != null) {last = last.next;}
                last.next = new ListNode(x.val);
            }
            x = x.next;
        }

        if(x!=null && !skip) {
            ListNode last = result;
            while (last != null && last.next != null) {last = last.next;}
            last.next = new ListNode(x.val);
        }

        return result;
    }

    public static void main(String[] args){
          ListNode node = new ListNode(1);
          node.next = new ListNode(1);
          node.next.next = new ListNode(1);
          node.next.next.next = new ListNode(3);
          node.next.next.next.next = new ListNode(3);
          node.next.next.next.next.next = new ListNode(3);
          node.next.next.next.next.next.next = new ListNode(3);

        ListNode x = deleteDuplicates(node);
        while(x!=null) {
            System.out.println(x.val);
            x = x.next;
        }
    }
}
