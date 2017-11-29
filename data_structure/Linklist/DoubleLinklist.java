package data_structure.Linklist;

public class DoubleLinklist {
    public int index = 0;
    public Node1 node;
    public DoubleLinklist(){
        this.node = null;
    }

    public void addFirst(int elem){//头插法
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

    public void addLast(int elem){
        Node1 n = new Node1(elem);
        Node1 p = node;
        if(node==null){
            n.next = node;
            n.prevent = node;
            node = n;
        }else {
            while(p.next!=null){
                p = p.next;
            }
            p.next = n;
            n.prevent = p;
        }
    }

    public void printAllNode() {
        Node1 cur = node;
        while (cur != null) {
            cur.display();
            cur = cur.next;
        }
    }

    public int queryPrevent(int elem){
        Node1 a =node;
        while(a.data!=elem){
            a= a.next;
        }
        return a.prevent.data;
    }

    public int queryNext(int elem){
        Node1 a = node;
        while(a.data!=elem){
            a= a.next;
        }
        return a.next.data;
    }
}
class test{
    public static void main(String[] args) {
        DoubleLinklist d =new DoubleLinklist();
//        d.addFirst(1);
//        d.addFirst(2);
//        d.addFirst(3);
//        d.addFirst(4);
//        d.addFirst(5);
        d.addLast(1);
        d.addLast(2);
        d.addLast(3);
        d.addLast(4);
        d.addLast(5);
        d.printAllNode();
    }
}