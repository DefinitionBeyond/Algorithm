package data_structure.Tree;

import java.util.Stack;

public class scanTreeByMidOrder {
    /**
     * 二叉树的中序遍历
     * 递归实现
     *
     * @param parentNode
     */
    public void BinaryTreeMidOrder(TreeNode<Integer> parentNode) {
        if (parentNode == null) {
            return;
        }
        BinaryTreeMidOrder(parentNode.left);

        System.out.print(parentNode.val + " ");

        BinaryTreeMidOrder(parentNode.right);
    }

    /**
     * 二叉树的中序遍历
     * <p>
     * 非递归实现
     *
     * @param rootNode
     */
    public void BinaryTreeMidOrder_loop(TreeNode<Integer> rootNode) {
        Stack<TreeNode<Integer>> stack = new Stack<TreeNode<Integer>>();
        TreeNode<Integer> cur = rootNode;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            System.out.print(cur.val + " ");
            cur = cur.right;
        }
    }
}
