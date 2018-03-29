package data_structure.Linklist;

import org.junit.Test;

/**
 * @author liutao
 * @date 2018/3/29  9:58
 */

/**
 * 双端链表，可以首尾操作
 */
public class DoubleNodeLinkList {
    private Link frist; //双端链表的头
    private Link last; //双端链表的尾

    public DoubleNodeLinkList() { //初始化链表头和尾
        frist = null;
        last = null;
    }

    public boolean isEmpty() { // 判断链表是否为空
        return frist == null;
    }

    public void insertFrist(int value) { //在头部插入。头插法插入
        Link newLink = new Link(value);
        if (isEmpty()) //如果链表为空
            last = newLink; //尾指针指向该节点
        newLink.next = frist; //首指针指向该节点，该节点的后面指向null
        frist = newLink;
    }

    public void insertLast(int value) { //尾部插入
        Link newLink = new Link(value);
        if (isEmpty()) //如果是空，首指针指向该节点，尾指针也指向该节点
            frist = newLink;
        else  //不是空，尾指针后移，指导该节点
            last.next = newLink;
        last = newLink;
    }

    public void displayList() {
        Link cur = frist;
        while (cur != null) {
            cur.displayCurrentNode();
            cur = cur.next;
        }
    }

    public int deleteFrist() {
        int value = frist.val;
        if (frist.next == null) { //只有一个元素，last指向空
            last = null;
        }
        frist = frist.next; //指针后移
        return value;
    }

    public void delete(int value) {
        if (frist.val == value) //值是头节点
            deleteFrist();
        if (last.val == value) { //值在尾端
            Link cur = frist;
            while (cur != null) {
                if (cur.next.val == value) {
                    last = cur;
                    cur.next = last;
                    break;
                }
                cur = cur.next;
            }
        } else {  //值在中间
            Link cur = frist;
            while (cur != null) {
                if (cur.next.val == value) {
                    cur.next = cur.next.next;
                    break;
                }
                cur = cur.next;
            }
        }

    }

    @Test
    public void go() {
        DoubleNodeLinkList list = new DoubleNodeLinkList();
        list.insertFrist(5);
        list.insertFrist(4);
        list.insertFrist(3);
        list.insertFrist(2);
        list.insertFrist(1);
        list.insertLast(6);
        list.insertLast(7);
//        System.out.println(list.last.val);
//        list.deleteFrist();
        list.delete(7);
        list.insertLast(8);
        list.displayList();
    }
}


class Link {
    public int val;
    public Link next;

    public Link(int val) {
        this.val = val;
    }

    public void displayCurrentNode() {
        System.out.println(val + "  ");
    }
}