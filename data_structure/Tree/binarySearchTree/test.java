package data_structure.Tree.binarySearchTree;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author liutao
 * @date 2018/5/6  22:16
 */
public class test {
    @Test
    public void go() {
        BinarySearchTree<String> tree = new BinarySearchTree<>(true);
        tree.insert(5, "one");
        tree.insert(3, "two");
        tree.insert(2, "three");
        tree.insert(7, "four");
        tree.insert(6, "five");
        tree.insert(4, "six");
        tree.scanPreOrder(tree);
    }

    @Test
    public void go1() {
        BinarySearchTree<String> tree = new BinarySearchTree<>(false);
        tree.insert(5);
        tree.insert(3);
        tree.insert(2);
        tree.insert(7);
        tree.insert(6);
        tree.insert(4);
        tree.scanPreOrder(tree);
    }
}
