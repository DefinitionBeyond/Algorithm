package data_structure.Linklist;

public class SGLinklist {
    public int index = 0 ;
    public Node node ;
    public SGLinklist(){
        this.node = null;
    }
    public void addList(int elem){
        Node n = new Node(elem);
        Node p = node;
        if(p==null){
            n.next = p;
            p = n;

        }else {
            while(p.next!=null){
                p = p.next;//p指向最后的节点
            }
            p.next = n;//最后节点的next指向node

        }
        p.next = node;
    }

    public void printNext(int elem){
        Node p = node;
        while(p.data != elem){
            p = p.next;
        }
        System.out.println(p.next.data);
    }

    public static void main(String[] args) {
        SGLinklist s = new SGLinklist();
        s.addList(1);
        s.addList(2);
//        s.addList(3);
//        s.addList(4);
//        s.addList(5);
        s.printNext(1);
    }
}
