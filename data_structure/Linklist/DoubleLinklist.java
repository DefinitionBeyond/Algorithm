package data_structure.Linklist;

public class DoubleLinklist {
    public int index = 0;
    public Node1 node;
    public DoubleLinklist(){
        this.node = null;
    }

    public void addFirst(int elem) {//头插
        Node1 n = new Node1(elem);
        if(node==null){
        n.next = node;
        n.prevent = node;
        node = n;
        }else {
            node.prevent = n;
            n.next = node;
            node = n;
        }
    }

    public void addLast(int elem) { //尾插
        Node1 newNode = new Node1(elem);
        Node1 p = node;
        if(node==null){
            newNode.next = node;
            newNode.prevent = node;
            node = newNode;
        }else {
            while(p.next!=null){
                p = p.next;
            }
            p.next = newNode;
            newNode.prevent = p;
        }
    }


    public int queryPrevent(int elem) { //查询前驱元素
        Node1 a =node;
        while(a.data!=elem){
            a= a.next;
        }
        return a.prevent.data;
    }

    public int queryNext(int elem) { //查询后继节点
        Node1 a = node;
        while(a.data!=elem){
            a= a.next;
        }
        return a.next.data;
    }

    public void printAllNode() {
        Node1 cur = node;
        while (cur != null) {
            cur.display();
            cur = cur.next;
        }
    }

}
class test{
    public static void main(String[] args) {
        DoubleLinklist d =new DoubleLinklist();
        DoubleLinklist d1 = new DoubleLinklist();
        d.addFirst(1);
        d.addFirst(2);
        d.addFirst(3);
        d.addLast(6);
        d.addFirst(4);
        d.addFirst(5);
        System.out.println(d.queryPrevent(3));
        System.out.println(d.queryNext(3));
        d.printAllNode();
//        d1.addLast(1);
//        d1.addLast(2);
//        d1.addLast(3);
//        d1.addLast(4);
//        d1.addLast(5);
//        d1.printAllNode();
    }
}