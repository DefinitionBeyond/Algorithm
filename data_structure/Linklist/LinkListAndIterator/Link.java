package data_structure.Linklist.LinkListAndIterator;

import java.util.LinkedList;

/**
 * @author liutao
 * @date 2018/3/29  12:12
 */
public class Link {
    public int val;
    public Link next;

    public Link(int val) {
        this.val = val;
    }

    public void display() {
        System.out.print(val + "  ");
    }
}
