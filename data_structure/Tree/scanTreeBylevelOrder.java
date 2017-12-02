package data_structure.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的层次遍历
 * 借助队列实现
 * 如果是父节点
 * 其左右子树入队
 * 并把父节点打印
 */
public class scanTreeBylevelOrder {
    public void BinaryTreeLevelOrder(TreeNode<Integer> rootNode) {
        Queue<TreeNode<Integer>> queue = new LinkedList<TreeNode<Integer>>();
        queue.add(rootNode);
        while (!queue.isEmpty()) {
            TreeNode<Integer> parentNode = queue.poll();
            System.out.print(parentNode.val + " ");
            if (parentNode.left != null) {
                queue.add(parentNode.left);
            }
            if (parentNode.right != null) {
                queue.add(parentNode.right);
            }
        }
    }
}
