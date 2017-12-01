package data_structure.Tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class scanTreeByPostOrder {
    /**
     * 后序递归遍历
     *
     * @param parentNode
     */
    public void BinaryTreePostOrder(TreeNode<Integer> parentNode) {
        if (parentNode == null) {
            return;
        }
        BinaryTreePostOrder(parentNode.left);
        BinaryTreePostOrder(parentNode.right);
        System.out.print(parentNode.val + " ");
    }

    /**
     * 后序遍历
     * 非递归
     * 循环遍历
     *
     * @param rootNode
     */
    public void BinaryTreePostOrder_loop(TreeNode<Integer> rootNode) {
        Stack<TreeNode<Integer>> stack = new Stack<TreeNode<Integer>>();
        //使用map来标记已经访问过的节点
        Map<TreeNode<Integer>, Boolean> nodeMap = new HashMap<TreeNode<Integer>, Boolean>();
        stack.push(rootNode);
        while (!stack.isEmpty()) {
            TreeNode<Integer> temp = stack.peek();
            //获取左子树的左节点
            if (temp.left != null && !nodeMap.containsKey(temp.left)) {
                temp = temp.left;
                while (temp != null) {
                    stack.push(temp);
                    temp = temp.left;
                }
                continue;
            }
            //获取右节点
            if (temp.right != null && !nodeMap.containsKey(temp.right)) {
                stack.push(temp.right);
                continue;
            }
            TreeNode<Integer> cur = stack.pop();
            System.out.print(cur.val + " ");
            nodeMap.put(cur, true);
        }
    }
}
