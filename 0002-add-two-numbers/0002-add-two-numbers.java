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
    ListNode ans;
    public void fn(ListNode l1, ListNode l2,int c){
        if(l1==null && l2==null && c==0)return;
        else if(l1==null && l2==null){
            ans.next = new ListNode(c);
            return;
        } 
        
        int x = c;
        if(l1!=null)x+=l1.val;
        if(l2!=null)x+=l2.val;

        int d = x%10;
        c = x/10;
        ans.next = new ListNode(d);
        ans = ans.next;
        if(l1==null)fn(l1,l2.next,c);
        else if(l2==null)fn(l1.next,l2,c);
        else fn(l1.next,l2.next,c);
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ans = new ListNode();
        ListNode anss = ans;
        fn(l1,l2,0);
        return anss.next;
    }
}