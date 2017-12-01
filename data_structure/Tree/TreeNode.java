package data_structure.Tree;

public class TreeNode<E> {
    E val;
    TreeNode left;
    TreeNode right;

    public TreeNode(E val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
