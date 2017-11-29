package one_privi.zuochengyun;

import data_structure.Linklist.SimpleLinklist;
import data_structure.Linklist.Node;

public class DelLinklistLastkthNode {
    public static void main(String[] args) {
        SimpleLinklist l1 = new SimpleLinklist();
        int []a = {1,4,6,8,9,12,14,15,16,18};
//        int []b = {2,4,5,9,10,11,13,15,17,18};
        for(int i = 0 ; i < a.length ; i++){
            l1.addLast(a[i]);
        }
        DelLinklistLastkthNode d = new DelLinklistLastkthNode();
//        d.deal(l1,4);
        l1.add(2,1);
        l1.printAllNode();
    }
    public void deal(SimpleLinklist l, int index){
        if(l.frist==null||index<0){
            return;
        }
        Node cur = l.frist;
        while (cur!=null){
            index--;
            cur = cur.next;
        }
        if(index==-1){
            l.delByIndex(0);
        }
        if (index<-1){
            l.delByIndex(Math.abs(index));
        }
    }
}
