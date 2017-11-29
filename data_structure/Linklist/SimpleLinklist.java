package data_structure.Linklist;

public class SimpleLinklist {

    public Node frist;
    public int index=0;

    public SimpleLinklist() {
        this.frist = null;
    }

    public void addFirst(int elem) {//头插法建立链表
       Node node = new Node(elem);
        node.next = frist;
        frist = node;
    }

    public void addLast(int elem){//尾插
        Node node = new Node(elem);
        Node p  = frist;
        if(frist==null){//如果链表为空，则需要把节点赋给头节点
            node.next = frist;
            frist = node;
        }else {
            while(p.next!=null){
                p = p.next;//p指向最后的节点
            }
            p.next = node;//最后节点的next指向node
        }
    }

    public  void add(int elem , int index){
        Node node = new Node(elem);
        Node pre = frist;
        Node cur = frist;
        while(this.index!=index){//没有找到，前指针域和后指针域同时后移，直到找到位置，跳出循环
            pre = cur;
            cur = cur.next;//找到的时候，pre指向index位置前一个节点，cur指向index位置
            this.index++;
        }
        //  【pre】->【cur】   ==>  【pre】->【node】->【cur】
        node.next = cur;//cur节点为node的后继节点
        pre.next = node;//pre节点为node的前驱节点
        this.index = 0;
    }

    public void delByIndex(int index){
        Node pre = frist;
        Node cur = frist;
        while(this.index!=index) {//没有找到，前指针域和后指针域同时后移，直到找到位置，跳出循环
            pre = cur;
            cur = cur.next;
            this.index++;
        }
        //  【pre】->【index】->【cur】  ==>  【pre】->【cur】
        if(index == 0){//删除第一个元素
            frist = frist.next;
        }else if(cur.next==null){//删除最后一个元素
            pre.next=null;
        }else {
            pre.next = cur.next;
        }
        this.index = 0;
    }

    public void delByValue(int elem){
        Node pre = frist;
        Node cur = frist;
        boolean isEnd = false;
        while(cur.data!=elem){
            pre = cur;
            cur = cur.next;
            if (cur==null){
                isEnd = true;
            }
        }
        if(frist.data == elem){
            frist = frist.next;
        }else if (isEnd){
            pre.next=null;
        }else {
            pre.next = cur.next;
        }
    }

    public void updataByIndex(int elem,int index){
        Node cur = frist;
        while(this.index!=index){
            cur = cur.next;
            this.index++;
        }
        cur.data = elem;
        this.index = 0;
    }

    public int searchByIndex(int index){
        Node cur = frist;
        while(this.index!=index){
            cur = cur.next;
            this.index++;
        }
        return cur.data;
    }

    public int searchByValue(int elem){
        Node cur = frist;
        while(cur.data!=elem){
            cur = cur.next;
            this.index++;
        }
        int index = this.index;
        this.index = 0;
        return index;
    }

    public void printAllNode() {
        Node cur = frist;
        while (cur != null) {
            cur.display();
            cur = cur.next;
        }
    }
}

