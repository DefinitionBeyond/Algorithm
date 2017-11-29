package one_privi.leetcode;

public class MergeTwoLists {
    class ListNode {
        int val;
        ListNode next;

        public ListNode(int data) {
            this.val = data;
        }
    }

    public static void main(String[] args) {

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode l;//创建一个结果链表
        l = l1.val > l2.val ? l2 : l1;//取最小值
        l.next = l1.val > l2.val ? mergeTwoLists(l1, l2.next) : mergeTwoLists(l1.next, l2);//移动指针，并且取下一跳的值，递归
        return l;
    }
}
