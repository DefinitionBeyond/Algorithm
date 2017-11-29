package two_privi.leetcode;

public class AddTwoNumbers {
    class ListNode{
        public int val;
        public ListNode next;
        public ListNode(int val){
            this.val = val;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        if(l1 == null){
//            return l2;
//        }
//        if(l2 == null){
//            return l1;
//        }4
// boolean flag1 ,flag2;
        ListNode ans = new ListNode(0);
        ListNode p = ans;
        int jinwei = 0;

        while (l1.next != null || l2.next != null) {
            if (l1 != null) {
                jinwei += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                jinwei += l2.val;
                l2 = l2.next;
            }
            p.next = new ListNode(jinwei % 10);
            p = p.next;
            jinwei /= 10;
        }
        if (jinwei == 1) {
            ListNode node = new ListNode(1);
            p.next = node;
        }
        return p.next;
//            flag1 = false;
//            flag2 = false;
//           if(l1.next==null&&(l2.next!=null||l1.val+l2.val>10)){
//                flag1 = true;
//            }
//           if(l2.next==null){
//               flag2 = true;
//           }
//           if(flag1) {
//               ListNode node1 = new ListNode(0);
//               ListNode p = l1;
//               while(p.next!=null){
//                   p = p.next;
//               }
//               p.next = node1;
//           }
//           if (flag2){
//               l1.val %= 10;
//               jinwei = l1.val / 10;
//               l1.next.val = l1.next.val+jinwei;
//               l1 = l1.next;
//           }else {
//               l1.val = (l1.val + l2.val) % 10;
//               jinwei = (l1.val + l2.val) / 10;
//               l1.next.val = l1.next.val + jinwei;
//               l1 = l1.next;
//               l2 = l2.next;
//           }
//       }
//       while(l1.next!=null){
//
//       }
//        return l1;
    }

}
//143 + 564
//607
//341 + 465
//706