package GoForIt;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by NoClay on 2016/11/16.
 */
public class Solution4 {
    //    输入一个链表，输出该链表中倒数第k个结点。
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindKthToTail(ListNode head, int k) {
        java.util.List<ListNode> list = new java.util.ArrayList<>();
        while (head != null){
            list.add(head);
            head = head.next;
        }
        return k > list.size() ? null : k == 0 ? null :list.get(list.size() - k);
    }
    public ListNode ReverseList(ListNode head) {
        if (head == null){
            return null;
        }

        ListNode pre = null;
        ListNode next = null;
        while(head !=null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    /**
     * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
     */
    public ListNode Merge(ListNode list1,ListNode list2) {
        if (list1 == null && list2 == null){
            return null;
        }
        if (list1 == null){
            return list2;
        }
        if (list2 == null){
            return list1;
        }
        ListNode head = new ListNode(1);
        ListNode temp = head;
        while (list1 != null && list2 != null){
            if (list1.val <= list2.val){
                temp.next = list1;
                list1 = list1.next;
            }else{
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }
        if (list1 != null){
            temp.next = list1;
        }
        if (list2 != null){
            temp.next = list2;
        }
        return head.next;
    }
    public static void main(String []args){
        ListNode head = new Solution4.ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(5);
        ListNode head1 = new ListNode(2);
        head1.next = new ListNode(4);
        head1.next.next = new ListNode(6);
        Solution4 s = new Solution4();
        head = s.Merge(head, head1);

    }
}
