package data_structure.Linklist.LinkListAndIterator;

/**
 * @author liutao
 * @date 2018/3/29  12:12
 */
public class Iterator {
    private Link pre;
    private Link cur;
    private LinkList linkList;

    public Iterator(LinkList linkList) {
        this.linkList = linkList;
        reset();
    }

    public void reset() { //当前当前结点为头节点
        cur = linkList.getFrist();
        pre = null;
    }

    public boolean atEnd() { //当前元素是不是最后一个
        return cur == null;
    }

    public void next() { //指针迭代后移
        pre = cur;
        cur = cur.next;
    }

    public Link getCur() {
        return cur;
    }

    public void setCur(Link cur) {
        this.cur = cur;
    }

    /**
     * 在当前结点之后插入一个元素
     * 例：插入 4
     * 1 2 3 4
     */
    public void insertAfter(int value) {
        Link newLink = new Link(value);
        if (linkList.isEmpty()) {
            linkList.setFrist(newLink);
            cur = newLink;
        } else {
            newLink.next = cur.next;
            cur.next = newLink;
            next();
        }
    }

    /**
     * 在当前结点之前插入一个元素
     * 例： 插入4
     * 1 2 4 3
     *
     * @param value
     */
    public void insertBefore(int value) {
        Link newLink = new Link(value);
        if (pre == null) { // 当前链表是空还是一个元素
            newLink.next = linkList.getFrist();
            linkList.setFrist(newLink);
            reset();
        } else {
            newLink.next = pre.next;
            pre.next = newLink;
            cur = newLink;
        }
    }

    /**
     * 删除当前结点
     *
     * @return
     */
    public int deleteCur() {
        int value = cur.val;
        if (pre == null) {
            linkList.setFrist(cur.next);
            reset();
        } else {
            pre.next = cur.next;
            if (atEnd()) {
                reset();
            } else cur = cur.next;
        }
        return value;
    }
}
