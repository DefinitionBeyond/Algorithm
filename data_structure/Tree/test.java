package data_structure.Tree;

import org.junit.Test;

public class test {
    @Test
    public void test() {
        Integer[] a = {39, 21, 69, 6, 78, 21, 83, 53, 69, 52, 85};
        CreateTree tree = new CreateTree(a);
        tree.createTree();
        TreeNode<Integer> rootNode = tree.listnode.get(0);
        new scanTreeByPreOrder().BinaryTreePreOrder(rootNode);
        System.out.println();
        new scanTreeByPreOrder().BinaryTreePreOrder_loop(rootNode);
        new scanTreeByMidOrder().BinaryTreeMidOrder(rootNode);
    }

    @Test
    public void test1() {
        Integer[] a = {39, 21, 69, 6, 78, 21, 83, 53, 69, 52, 85};
        CreateTree tree = new CreateTree(a);
        tree.createTree();
        TreeNode<Integer> rootNode = tree.listnode.get(0);
        new scanTreeByMidOrder().BinaryTreeMidOrder(rootNode);
        System.out.println();
        new scanTreeByMidOrder().BinaryTreeMidOrder_loop(rootNode);
    }

    @Test
    public void test2() {
        Integer[] a = {39, 21, 69, 6, 78, 21, 83, 53, 69, 52, 85};
        CreateTree tree = new CreateTree(a);
        tree.createTree();
        TreeNode<Integer> rootNode = tree.listnode.get(0);
        new scanTreeByPostOrder().BinaryTreePostOrder(rootNode);
        System.out.println();
        new scanTreeByPostOrder().BinaryTreePostOrder_loop(rootNode);
    }
}
