package data_structure.Linklist;

public class Node1 {
    public int data;
    public Node1 prevent;
    public Node1 next;
    public Node1(int data){
        this.data = data;
    }

    public Node1(int data, Node1 prevent, Node1 next) {
        this.data = data;
        this.prevent = prevent;
        this.next = next;
    }

    public void display() {
        System.out.println(data);
    }
}
