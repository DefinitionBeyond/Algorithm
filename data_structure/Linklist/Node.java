package data_structure.Linklist;

import org.junit.Test;

public class Node {
    public int data;
    public Node next;

    @Test
    public void run(){

    }

    public Node(int data) {
        this.data = data;
    }

    public void display() {
        System.out.println(data);
    }
}
