package data_structure.Tree;

import java.util.Stack;

public class scanTreeByPreOrder {
    /**
     * 二叉树的先序递归遍历
     *
     * @param parentNode
     */
    public void BinaryTreePreOrder(TreeNode<Integer> parentNode) {
        if (parentNode == null) {
            return;
        }
        System.out.print(parentNode.val + " ");
        BinaryTreePreOrder(parentNode.left);
        BinaryTreePreOrder(parentNode.right);
    }

    /**
     * 二叉树的先序循环遍历
     *
     * @param rootNode
     */
    public void BinaryTreePreOrder_loop(TreeNode<Integer> rootNode) {
        Stack<TreeNode<Integer>> stack = new Stack<TreeNode<Integer>>();
        TreeNode<Integer> cur = rootNode;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                System.out.print(cur.val + " ");
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            cur = cur.right;
        }
    }

}
