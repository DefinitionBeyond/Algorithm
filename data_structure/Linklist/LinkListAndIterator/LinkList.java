package data_structure.Linklist.LinkListAndIterator;

/**
 * @author liutao
 * @date 2018/3/29  12:12
 */
public class LinkList {
    private Link frist; //头节点

    public LinkList() {
        frist = null;
    }

    public Link getFrist() {
        return frist;
    }

    public void setFrist(Link frist) {
        this.frist = frist;
    }

    public boolean isEmpty() {
        return frist == null;
    }

    public Iterator getItertor() { //迭代器
        return new Iterator(this);
    }

    public void display() {
        Link cur = frist;
        while (cur != null) {
            cur.display();
            cur = cur.next;
        }
    }
}
